/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.RutaEnvioDAO;
import DTO.RutaEnvioDTO;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author Oscar Montes
 */
@Path("generic")
public class RutasWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ContenedoresWS
     */
    public RutasWS() {
    }

    /**
     * Retrieves representation of an instance of REST.RutasWS
     * @return an instance of java.lang.String
     */
   @GET
    @Path("/getRutas")
    @Produces("application/json")
    public String getRutas() {
        String feeds = null;
        try {
            RutaEnvioDAO rutadao = new RutaEnvioDAO();
            ArrayList<RutaEnvioDTO> feedData = null;
            feedData=rutadao.consultarRutas();
            Gson gson = new Gson();
            System.out.println("Llego aqui");
            System.out.println(gson.toJson(feedData));
            feeds = gson.toJson(feedData);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }


    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
