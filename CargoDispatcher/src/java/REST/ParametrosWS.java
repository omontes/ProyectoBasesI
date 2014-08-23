/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.ParametrosDAO;
import DTO.ParametrosDTO;
import com.google.gson.Gson;
import java.sql.SQLException;
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
@Path("parametros")
public class ParametrosWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ParametrosWS
     */
    public ParametrosWS() {
    }

    @GET
    @Path("/getParametros")
    @Produces("application/json")
    public String getPeoresClientes() {
        String feeds = null;
        try {
            ParametrosDAO parametros_dao = new ParametrosDAO();
            ParametrosDTO parametros = new ParametrosDTO();
            parametros= parametros_dao.consultarParametros();
            Gson gson = new Gson();
            feeds = gson.toJson(parametros);
            
        } catch (Exception e) {
            System.out.println("Exception Error"); //Console 
        }
        return feeds;
    }
    @POST
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ParametrosDTO update(ParametrosDTO parametros) throws SQLException, NamingException {
        ParametrosDAO parametros_dao = new ParametrosDAO();
        return parametros_dao.actualizarParametros(parametros);
    }

    /**
     * PUT method for updating or creating an instance of ParametrosWS
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
