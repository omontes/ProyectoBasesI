/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.ClienteDAOImpl;
import DTO.ClienteDTO;
import DTO.PaqueteDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
     * @return an HTTP response with content of the updated or created resource.
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
            System.out.println("Llego aqui");
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
            
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
