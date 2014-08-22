/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.BestClientsViewDTO;
import InterfaceDAO.BestClientsViewDAO;
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
public class BestClientsViewDAOImpl extends DAO implements BestClientsViewDAO {
    
    public BestClientsViewDAOImpl() throws SQLException, NamingException {
        
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
    public ArrayList<BestClientsViewDTO> getAllClients() {
        ArrayList<BestClientsViewDTO> ListaClientes = new ArrayList<>();
        try {
            String ConsultaMejoresClientes= this.leerSQL("/ArchivosSQL/MejoresClientes.sql");
            ResultSet rs = statement.executeQuery(ConsultaMejoresClientes);
            while (rs.next()) {
                BestClientsViewDTO cliente = new BestClientsViewDTO();
                cliente.setNombre(rs.getString("nombre"));
                ListaClientes.add(cliente);
            }  
            statement.close();
            return ListaClientes;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de los mejores clientes");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(BestClientsViewDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
