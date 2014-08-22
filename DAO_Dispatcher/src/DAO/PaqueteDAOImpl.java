/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import DTO.PaqueteDTO;
import InterfaceDAO.PaqueteDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Oscar Montes
 */
public class PaqueteDAOImpl extends DAO implements PaqueteDAO {
    
    public PaqueteDAOImpl() throws SQLException, NamingException {
        
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
    public PaqueteDTO desalmacenarPaquete(PaqueteDTO paquete) throws Exception {
        try {
            CallableStatement cs = this.conexion.prepareCall("{call desalmacenarPaquete(?)}");
            cs.setInt(1,paquete.getIdPaquete());
            //cs.registerOutParameter(2, java.sql.Types.VARCHAR);
            //cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.execute();
            //System.out.println(cs.getString(2));
            //System.out.println(cs.getInt(3));
            cs.close();
            return paquete;
        } catch (Exception e) {
            System.out.println("Error al procesar el desalmacenaje del paquete");
            throw(e);
        }
      finally {
            this.cerrarConexion();
        }
    }

    
}