/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.BestClientsViewDAOImpl;
import DAO.ClienteDAOImpl;
import DTO.BestClientsViewDTO;
import DTO.ClienteDTO;
import DTO.PaqueteDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Oscar Montes
 */
@Path("cliente")
public class ClientesWS {

    
    /**
     * Creates a new instance of ClientesWS
     */
    public ClientesWS() {
    }

    @GET
    @Path("/verificarCliente/{query}")
    @Produces("application/json")
    public String verificarCliente(@PathParam("query") int query) {
        String feeds = null;
        try {
            ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
            ClienteDTO cliente = new ClienteDTO();
            cliente.setIdCliente(query);
            cliente=cliente_dao.verificarCliente(cliente);
            Gson gson = new Gson();
            feeds = gson.toJson(cliente.getNombre());
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }
    @GET
    @Path("/getPaquetes/{query}")
    @Produces("application/json")
    public String getPaquetes(@PathParam("query") String query) {
        String feeds = null;
        try {
            ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
            ArrayList<PaqueteDTO> feedData = null;
            feedData=cliente_dao.findAllPaquetes(query);
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

    /**
     * PUT method for updating or creating an instance of ClientesWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or crearCliented resource.
     */
    
    @GET
    @Path("/getClientes")
    @Produces("application/json")
    public String getClientes() {
        String feeds = null;
        try {
            ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
            ArrayList<ClienteDTO> feedData = null;
            feedData=cliente_dao.consultarClientes();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }
     @GET
    @Path("/getMejoresClientes")
    @Produces("application/json")
    public String getMejoresClientes() {
        String feeds = null;
        try {
            BestClientsViewDAOImpl mejoresClientes_dao = new BestClientsViewDAOImpl();
            ArrayList<BestClientsViewDTO> feedData = null;
            feedData=mejoresClientes_dao.getAllClients();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteDTO create(ClienteDTO cliente) throws SQLException, NamingException {
        ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
        return cliente_dao.crearCliente(cliente);
    }
    
    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClienteDTO update(ClienteDTO cliente) throws SQLException, NamingException {
        ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
        return cliente_dao.actualizarCliente(cliente);
    }
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
    @DELETE 
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteCliente(@PathParam("id") int id) throws SQLException, NamingException {
		ClienteDAOImpl cliente_dao = new ClienteDAOImpl();
                cliente_dao.eliminarCliente(id);
	}
}
