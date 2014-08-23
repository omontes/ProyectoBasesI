/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.HistorialPaqueteDTO;
import DTO.PaqueteDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Oscar Montes
 */
public class HistorialPaqueteDAO extends DAO {
     public HistorialPaqueteDAO() throws SQLException, NamingException {
        
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
       
    public ArrayList<HistorialPaqueteDTO> getHistorialPaquete(PaqueteDTO paquete) throws SQLException, Exception {
         ArrayList<HistorialPaqueteDTO> listaHistorialPaquete = new ArrayList<HistorialPaqueteDTO>();
        try {
            String consultarHistorialPaquete= this.leerSQL("/ArchivosSQL/historialPaquete.sql");
            PreparedStatement stm = conexion.prepareStatement(consultarHistorialPaquete);
            stm.setInt(1, paquete.getIdPaquete());
            ResultSet rs =stm.executeQuery();
            while (rs.next()) {
                HistorialPaqueteDTO historialPaquete = new HistorialPaqueteDTO();
                historialPaquete.setEstado(rs.getString("estado"));
                historialPaquete.setFecha(rs.getDate("fecha"));
                listaHistorialPaquete.add(historialPaquete);
            }  
            statement.close();
            return listaHistorialPaquete;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta del tracking"
                    + " del paquete");
            throw(e);

        }
       finally {
            this.cerrarConexion();
        }
    }
    
}
