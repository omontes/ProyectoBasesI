
package DAO;

import DTO.EmployeeDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Oscar Montes
 */
public class EmployeeDAO {
    private Connection conexion;
    private Statement statement;
    public Object[][] infoFact;
    private static EmployeeDAO AdminBD;

    public EmployeeDAO(Connection conection, Statement statement) {
        this.conexion = conection;
        this.statement = statement;

    }

    public static EmployeeDAO getInstance() throws SQLException, NamingException {
        
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/companytrigger");
        Connection con = ds.getConnection();
        AdminBD = new EmployeeDAO(con, con.createStatement());

        return AdminBD;
    }
    
    /******* OPERACIONES BASICAS QUE SE REALIZAN A LA BASE DE DATOS *******/
    
    /**
     * Este metodo realiza una consulta a la tabla de Departamentos y obtiene
     * la informacion Dname, Dno y Total_sal
     */ 
    public ArrayList<EmployeeDTO> consultarEmpleados() throws Exception {
        ArrayList<EmployeeDTO> listaEmpleados = new ArrayList<EmployeeDTO>();
        try {
            String consultaempleados= this.leerSQL("/ArchivosSQL/ConsultaEmpleados.sql");
            ResultSet rs = statement.executeQuery(consultaempleados);
            while (rs.next()) {
                EmployeeDTO empleado = new EmployeeDTO();
                empleado.setName(rs.getString("Name"));
                empleado.setSsn(rs.getString("Ssn"));
                listaEmpleados.add(empleado);
            }  
            statement.close();
            return listaEmpleados;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
            throw(e);

        }

    }
    /**
     * Este metodo realiza una inserccion en la BD
     */
    public void insertData() {
        String Name="Varela";
        String Ssn="77777";
        int Salary=500;
        int dno=1;
        try {
            conexion.setAutoCommit(false);
            String InsertEmpleado= this.leerSQL("/ArchivosSQL/InsertEmpleado.sql");
            PreparedStatement stm = conexion.prepareStatement(InsertEmpleado);
            stm.setString(1,Name);
            stm.setString(2,Ssn);
            stm.setInt(3,Salary);
            stm.setInt(4,dno);
            stm.executeUpdate();
            conexion.commit();
            stm.close();
                                  
            
        }
       catch (Exception e) {
            System.out.println("Error al realizar la inserccion");
        }
    }
    /**
     * Realiza una actualizacion a la base de Datos
     */
    public void updateData() {
        try {
                     
            String UpdateSalary= this.leerSQL("/ArchivosSQL/UpdateSalary.sql");
            PreparedStatement stm = conexion.prepareStatement(UpdateSalary);
            stm.executeUpdate();
            System.out.println("Actualizacion Exitosa");
            stm.close();
            
        }
       catch (Exception e) {
            System.out.println("Error al realizar la actualizacion");
        }
    }
    /**
     * Realiza la lectura del archivo sql
     * @param direccion
     * @return
     * @throws IOException 
     */
    private String leerSQL(String direccion) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputfile = classLoader.getResourceAsStream(direccion);
        StringBuilder sb;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(inputfile))) {
            String str;
            sb = new StringBuilder();
            while ((str = input.readLine()) != null) {
                sb.append(str).append("\n");
            }
        }
        return sb.toString();
    }
}
