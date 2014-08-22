/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.PaqueteDAOImpl;
import DTO.PaqueteDTO;
import com.google.gson.Gson;
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
@Path("paquete")
public class PaqueteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PaqueteWS
     */
    public PaqueteWS() {
    }

 
    @GET
    @Path("/desalmacenar/{paquete}")
    @Produces("application/json")
    public String desalmacenarPaquete(@PathParam("paquete") int idPaquete) {
        String jason = null;
        try {
            PaqueteDAOImpl cliente_dao = new PaqueteDAOImpl();
            PaqueteDTO paquete = new PaqueteDTO();
            paquete.setIdPaquete(idPaquete);
            paquete=cliente_dao.desalmacenarPaquete(paquete);
            Gson gson = new Gson();
            jason = gson.toJson(paquete);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return jason;
    }
    /**
     * PUT method for updating or creating an instance of PaqueteWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
