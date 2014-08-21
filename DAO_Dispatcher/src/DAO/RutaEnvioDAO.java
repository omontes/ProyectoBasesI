/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.RutaEnvioDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 *
 * @author Oscar Montes
 */
public class RutaEnvioDAO extends DAO {
       
    public RutaEnvioDAO() throws SQLException, NamingException{
    
    

    }
    /******* OPERACIONES BASICAS QUE SE REALIZAN A LA BASE DE DATOS *******/
    
    /**
     * Este metodo realiza una consulta a la tabla de Departamentos y obtiene
     * la informacion Dname, Dno y Total_sal
     */ 
    public ArrayList<RutaEnvioDTO> consultarRutas() throws Exception {
        ArrayList<RutaEnvioDTO> lsitaRutas = new ArrayList<RutaEnvioDTO>();
        try {
            String consultarRutas= this.leerSQL("/ArchivosSQL/ConsultaRutas.sql");
            ResultSet rs = statement.executeQuery(consultarRutas);
            while (rs.next()) {
                RutaEnvioDTO rutaEnvio = new RutaEnvioDTO();
                rutaEnvio.setNombre(rs.getString("nombre"));
                rutaEnvio.setIdRutaEnvio(rs.getInt("idRutaEnvio"));
                rutaEnvio.setPto_llegada(rs.getString("pto_llegada"));
                rutaEnvio.setPto_salida(rs.getString("pto_salida"));
                rutaEnvio.setTiempo_dias(rs.getInt("tiempo"));
                rutaEnvio.setCosto(rs.getBigDecimal("costo"));
                rutaEnvio.setMaximocontenedor(rs.getInt("maximocontenedor"));
                
                lsitaRutas.add(rutaEnvio);
            }  
            statement.close();
            return lsitaRutas;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de contenedores");
            throw(e);

        }
       finally {
            this.cerrarConexion();
        }

    }
    
      /**
     * Realiza la lectura del archivo sql
     * @param direccion
     * @return
     * @throws IOException 
     */
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
      /**"campo-idrutaEnvio"  
      "campo-nombre"
      "campo-salida" 
      "campo-llegada"
      "campo-tiempo" 
      "campo-costo"
      "campo-maximocontenedores"***/
    public RutaEnvioDTO crearRuta(RutaEnvioDTO ruta) throws SQLException {
       try {
            
            String insertarRuta= this.leerSQL("/ArchivosSQL/insertarRuta.sql");
            int direccion= this.obtenerDireccionRuta(ruta);
            PreparedStatement ps = conexion.prepareStatement(insertarRuta);
            ps.setInt(1, ruta.getIdRutaEnvio());
            ps.setString(2, ruta.getNombre());
            ps.setInt(3, direccion);
            ps.setInt(4, ruta.getTiempo_dias());
            ps.setBigDecimal(5, ruta.getCosto());
            ps.setInt(6, ruta.getMaximocontenedor());
            ps.executeUpdate();
            
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
	       } finally {
            this.cerrarConexion();
        }
        return ruta;
    }

    private int obtenerDireccionRuta(RutaEnvioDTO ruta) throws Exception {
         int idRuta = 0;    
         try {
            String obtenerDireccionRuta= this.leerSQL("/ArchivosSQL/obtenerDireccionRuta.sql");
            PreparedStatement stm = conexion.prepareStatement(obtenerDireccionRuta);
            stm.setString(1,ruta.getPto_llegada());
            stm.setString(2,ruta.getPto_salida());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                idRuta=rs.getInt("idRuta");
                
            }
            statement.close();
            return idRuta;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "el tipo del cliente");
            throw(e);

        }
    }
    
}
