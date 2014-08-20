/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ContenedorDTO;
import InterfaceDAO.ContenedorDAO;
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
public class ContenedorDAOImpl extends DAO implements ContenedorDAO{
    
     public ContenedorDAOImpl() throws SQLException, NamingException {
        
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
    
    public ArrayList<ContenedorDTO> getContenedores(){
        ArrayList<ContenedorDTO> Contenedores = new ArrayList<>();
        try {
            String ConsultaContenedores= this.leerSQL("/ArchivosSQL/ConsultaContenedores.sql");
            PreparedStatement stm = conexion.prepareStatement(ConsultaContenedores);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                ContenedorDTO contenedor = new ContenedorDTO();
                contenedor.setIdContenedor(rs.getInt("idContenedor"));
                contenedor.setIdRuta(rs.getInt("idRuta"));
                contenedor.setPeso_max(rs.getInt("peso_max"));
                Contenedores.add(contenedor);
            }  
            statement.close();
            return Contenedores;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de los contenedores");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
