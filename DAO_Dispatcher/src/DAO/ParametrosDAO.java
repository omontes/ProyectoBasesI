/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.ParametrosDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Oscar Montes
 */
public class ParametrosDAO extends DAO {
    public ParametrosDAO() throws SQLException, NamingException{
    
    

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
    
    public ParametrosDTO consultarParametros() throws Exception {
                
        
        try {
            String consultarClientes = this.leerSQL("/ArchivosSQL/ConsultaClientes.sql");
            ResultSet rs = statement.executeQuery(consultarClientes);
            ParametrosDTO parametros = new ParametrosDTO();
            while (rs.next()) {

                parametros.setDiaActual(rs.getTimestamp("diaActual"));
                parametros.setPorcent_vol_contenedor(rs.getInt("porcent_vol_contenedor"));
                parametros.setCosto_almacenado(rs.getInt("costo_almacenado"));

            }
            statement.close();
            return parametros;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "todos los parametros");
            throw(e);

        }
       finally {
            this.cerrarConexion();
        }

    
    }
    
    public ParametrosDTO actualizarParametros(ParametrosDTO parametros) throws SQLException {
            
        try {
            String actualizarParametros = this.leerSQL("/ArchivosSQL/actualizarParametros.sql");
            PreparedStatement ps = conexion.prepareStatement(actualizarParametros);
            ps.setTimestamp(1, parametros.getDiaActual());
            ps.setInt(2, parametros.getPorcent_vol_contenedor());
            ps.setInt(3, parametros.getCosto_almacenado());
            ps.executeUpdate();
            ps.close();

        }
    
    catch (Exception e

    
        ) {
            e.printStackTrace();
        throw new RuntimeException(e);
    }

    
        finally {
            this.cerrarConexion();
    }
    return parametros ;
}
}
