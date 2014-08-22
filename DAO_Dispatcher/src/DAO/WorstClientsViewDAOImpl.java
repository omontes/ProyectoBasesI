/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.WorstClientsViewDTO;
import InterfaceDAO.WorstClientsViewDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Carlos
 */
public class WorstClientsViewDAOImpl extends DAO implements WorstClientsViewDAO{

   public WorstClientsViewDAOImpl() throws SQLException, NamingException {
        
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
    public ArrayList<WorstClientsViewDTO> getAllClients() {
        ArrayList<WorstClientsViewDTO> ListaClientes = new ArrayList<>();
        try {
            String ConsultaPeoresClientes= this.leerSQL("/ArchivosSQL/PeoresClientes.sql");
            ResultSet rs = statement.executeQuery(ConsultaPeoresClientes);
            while (rs.next()) {
                WorstClientsViewDTO cliente = new WorstClientsViewDTO();
                cliente.setNombre(rs.getString("nombre"));
                ListaClientes.add(cliente);
            }  
            statement.close();
            return ListaClientes;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de los peores clientes");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(WorstClientsViewDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
