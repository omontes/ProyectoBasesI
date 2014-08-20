/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.ContenedorDAOImpl;
import DTO.ContenedorDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Carlos
 */
@Path("contenedor")
public class ContenedorWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContenedorWS
     */
    public ContenedorWS() {
    }
    
    @GET
    @Path("/getContenedores")
    @Produces("application/json")
    public String getPaquetes() {
        String feeds = null;
        try {
            ContenedorDAOImpl conteneder_dao = new ContenedorDAOImpl();
            ArrayList<ContenedorDTO> feedData = null;
            feedData=conteneder_dao.getContenedores();
            Gson gson = new Gson();
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }

    /**
     * PUT method for updating or creating an instance of ContenedorWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
