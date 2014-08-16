/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ClienteDTO;
import DTO.PaqueteDTO;
import InterfaceDAO.ClienteDAO;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Carlos
 */
public class ClienteDAOImpl implements ClienteDAO{
    
    public Connection conexion;
    public Statement statement;

    public ClienteDAOImpl() throws SQLException, NamingException {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("jdbc/cargodispatcher");
        Connection con = ds.getConnection();
        this.conexion=con;
        this.statement=con.createStatement();
    }

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

    @Override
    public ArrayList<PaqueteDTO> findAllPaquetes(String cliente) {
        ArrayList<PaqueteDTO> Paquetes = null;
        try {
            String consularPaquetes_Cliente= this.leerSQL("/ArchivosSQL/ConsultaPaquetes_Cliente.sql");
            PreparedStatement stm = conexion.prepareStatement(consularPaquetes_Cliente);
            stm.setString(1,cliente);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PaqueteDTO paquete = new PaqueteDTO();
                paquete.setDescripcion(rs.getString("descripcion"));
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setEstadoActual(rs.getString("Descripcion"));
                Paquetes.add(paquete);
            }  
            statement.close();
            return Paquetes;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de paquetes por cliente");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
