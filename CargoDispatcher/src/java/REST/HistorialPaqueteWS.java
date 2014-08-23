/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.HistorialPaqueteDAO;
import DTO.HistorialPaqueteDTO;
import DTO.PaqueteDTO;
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
@Path("tracking")
public class HistorialPaqueteWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HistorialPaqueteWS
     */
    public HistorialPaqueteWS() {
    }

    /**
     * Retrieves representation of an instance of ArchivosSQL.HistorialPaqueteWS
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/getTrackingPaquete/{idPaquete}")
    @Produces("application/json")
    public String getTracking(@PathParam("idPaquete") int idPaquete) {
        String jason = null;
        try {
            HistorialPaqueteDAO historialpaquete_dao = new HistorialPaqueteDAO();
            PaqueteDTO paquete = new PaqueteDTO();
            paquete.setIdPaquete(idPaquete);
            ArrayList<HistorialPaqueteDTO> listahistorial =null;
            listahistorial=historialpaquete_dao.getHistorialPaquete(paquete);
            Gson gson = new Gson();
            jason = gson.toJson(listahistorial);
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return jason;
    }
    /**
     * PUT method for updating or creating an instance of HistorialPaqueteWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
