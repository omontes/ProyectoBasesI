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
public class ClienteDAOImpl extends DAO implements ClienteDAO {
    
  

    public ClienteDAOImpl() throws SQLException, NamingException {
        
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
        ArrayList<PaqueteDTO> Paquetes = new ArrayList<PaqueteDTO>();
        try {
            String consularPaquetes_Cliente= this.leerSQL("/ArchivosSQL/ConsultaPaquetes_Cliente.sql");
            PreparedStatement stm = conexion.prepareStatement(consularPaquetes_Cliente);
            stm.setString(1,cliente);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PaqueteDTO paquete = new PaqueteDTO();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setDescripcion(rs.getString("descripcion"));
                paquete.setEstadoActual(rs.getString("EstadoActual"));
                Paquetes.add(paquete);
            }  
            statement.close();
            return Paquetes;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de clientes");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
        
    }

    public ArrayList<ClienteDTO> consultarClientes() throws Exception {
                
        ArrayList<ClienteDTO> listaClientes = new ArrayList<ClienteDTO>();
        try {
            String consultarClientes= this.leerSQL("/ArchivosSQL/ConsultaClientes.sql");
            ResultSet rs = statement.executeQuery(consultarClientes);
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNumero_cuenta(rs.getInt("numero_cuenta"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setIdRutaEnvio(rs.getInt("idRutaEnvio"));
                cliente.setPuntos(rs.getInt("puntos"));
                cliente.setTipo(rs.getString("tipo"));
                
                listaClientes.add(cliente);
            }  
            statement.close();
            return listaClientes;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes");
            throw(e);

        }

    
    }
    
    public ClienteDTO verificarCliente(ClienteDTO cliente) throws Exception {
                
         try {
            String verificarCliente= this.leerSQL("/ArchivosSQL/verificarCliente.sql");
            PreparedStatement stm = conexion.prepareStatement(verificarCliente);
            stm.setInt(1,cliente.getIdCliente());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cliente.setNombre(rs.getString("nombre"));
                
            }  
            statement.close();
            return cliente;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los clientes");
            throw(e);

        }

    
    }
     public int obtenerTipoCliente(ClienteDTO cliente) throws Exception {
         int idTipo = 0;       
         try {
            String obtenerTipoCliente= this.leerSQL("/ArchivosSQL/obtenerTipoCliente.sql");
            PreparedStatement stm = conexion.prepareStatement(obtenerTipoCliente);
            stm.setInt(1,cliente.getIdCliente());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                idTipo=rs.getInt("tipo_cliente");
                
            }  
            statement.close();
            return idTipo;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "el tipo del cliente");
            throw(e);

        }

    
    }


    public ClienteDTO create(ClienteDTO cliente) {
        try {
            
            String verificarCliente= this.leerSQL("/ArchivosSQL/insertarCliente.sql");
            int tipocliente= this.obtenerTipoCliente(cliente);
            PreparedStatement ps = conexion.prepareStatement(verificarCliente);
            ps.setInt(1, cliente.getIdCliente());
            ps.setInt(2, cliente.getNumero_cuenta());
            ps.setString(3, cliente.getNombre());
            ps.setInt(4, cliente.getTelefono());
            ps.setInt(5, cliente.getIdRutaEnvio());
            ps.setInt(6, cliente.getPuntos());
            ps.setInt(7, tipocliente);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            ps.close();
            cliente.setIdCliente(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} 
        return cliente;
    }

 
    
}
