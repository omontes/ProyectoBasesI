/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ClienteDTO;
import DTO.PaqueteDTO;
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
import javax.naming.NamingException;

/**
 *
 * @author Oscar Montes
 */
public class ClienteDAO extends DAO {

    public ClienteDAO() throws SQLException, NamingException{
    
    }

    public ArrayList<PaqueteDTO> consultarPaquetes(String cliente) throws Exception {
        ArrayList<PaqueteDTO> listaPaquetes = new ArrayList<PaqueteDTO>();
        try {
            String consularPaquetes_Cliente= this.leerSQL("/ArchivosSQL/ConsultaPaquetes_Cliente.sql");
            PreparedStatement stm = conexion.prepareStatement(consularPaquetes_Cliente);
            stm.setString(1,cliente);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PaqueteDTO paquete = new PaqueteDTO();
                paquete.setDescripcion(rs.getString("descripcion"));
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                listaPaquetes.add(paquete);
            }  
            statement.close();
            return listaPaquetes;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de paquetes por cliente");
            throw(e);

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
