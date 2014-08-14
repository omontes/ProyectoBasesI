/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package REST;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Oscar Montes
 */
@Path("helloworld")
public class EmployeeWS {

    @Context
    private UriInfo context;
    private DataSource ds;
    private InitialContext ctx;
    private Connection con;

    /**
     * Creates a new instance of HelloWorld
     */
    public EmployeeWS() {
    }

    /**
     * Retrieves representation of an instance of helloworld.HelloWorld
     * @return an instance of java.lang.String
     */
   
    @GET
    @Path("/getEmpleados")
    @Produces("application/json")
    public String getEmpleados() {
        String feeds = null;
        try {
            ArrayList<EmployeeDTO> feedData = null;
            feedData=EmployeeDAO.getInstance().consultarEmpleados();
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
    @Consumes("text/plain")
    public void putText(String content) {
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createMessage(@FormParam("name") String name,
            @FormParam("message") String message,
            @FormParam("thelist") List<String> list) throws SQLException, NamingException {
        
        
        if (name.trim().length() > 0 && message.trim().length() > 0 && !list.isEmpty()) {
        
        EmployeeDAO.getInstance().insertData();
        EmployeeDAO.getInstance().updateData();
        
            return Response.created(URI.create("/dsf/"
                    + String.valueOf(UUID.randomUUID()))).
                    entity(name + ": "
                            + message + " --> los items: "
                            + list.get(0) + " - " + list.get(1)).build();

        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();

    }

}
