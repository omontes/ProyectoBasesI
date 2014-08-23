/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.PaqueteDAOImpl;
import DTO.PaqueteDTO;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @Path("/getPaquetesEmpleado")
    @Produces("application/json")
    public String getPaquetesAlmacenados() {
        String jason = null;
        try {
            PaqueteDAOImpl paquete_dao = new PaqueteDAOImpl();
            ArrayList<PaqueteDTO> feedData = null;
            feedData=paquete_dao.getPaquetesAlmacenadosyListos();
            Gson gson = new Gson();
            jason = gson.toJson(feedData);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return jason;
    }
    @GET
    @Path("/desalmacenar/{paquete}")
    @Produces("application/json")
    public String desalmacenarPaquete(@PathParam("paquete") int idPaquete) {
        String jason = null;
        try {
            PaqueteDAOImpl paquete_dao = new PaqueteDAOImpl();
            PaqueteDTO paquete = new PaqueteDTO();
            paquete.setIdPaquete(idPaquete);
            paquete=paquete_dao.desalmacenarPaquete(paquete);
            Gson gson = new Gson();
            jason = gson.toJson(paquete);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return jason;
    }
    @GET
    @Path("/desembalar/{paquete}")
    @Produces("application/json")
    public String desembalarPaquete(@PathParam("paquete") int idPaquete) {
        String jason = null;
        try {
            PaqueteDAOImpl paquete_dao = new PaqueteDAOImpl();
            PaqueteDTO paquete = new PaqueteDTO();
            paquete.setIdPaquete(idPaquete);
            paquete=paquete_dao.desembalarPaquete(paquete);
            Gson gson = new Gson();
            jason = gson.toJson(paquete);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return jason;
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PaqueteDTO create(PaqueteDTO paquete) throws SQLException, NamingException {
        PaqueteDAOImpl paquete_dao = new PaqueteDAOImpl();
        return paquete_dao.crearPaquete(paquete);
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
