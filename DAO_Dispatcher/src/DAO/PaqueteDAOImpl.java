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
import java.sql.PreparedStatement;
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
            cs.execute();
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

    public ArrayList<PaqueteDTO> getPaquetesAlmacenadosyListos() throws SQLException, Exception {
         ArrayList<PaqueteDTO> listaPaquetes = new ArrayList<PaqueteDTO>();
        try {
            String consultarPaquetesAlmacenadosyListos= this.leerSQL("/ArchivosSQL/consultarPaquetesAlmacenadosyListos.sql");
            ResultSet rs = statement.executeQuery(consultarPaquetesAlmacenadosyListos);
            while (rs.next()) {
                PaqueteDTO paquete = new PaqueteDTO();
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setPeso(rs.getInt("peso"));
                paquete.setDescripcion(rs.getString("descripcion"));
                paquete.setValor(rs.getBigDecimal("valor"));
                paquete.setIdCliente(rs.getInt("idCliente"));
                paquete.setCategoria(rs.getString("categoria"));
                paquete.setEstadoActual(rs.getString("estadoActual"));
                paquete.setEstado(rs.getInt("idEstado"));
                listaPaquetes.add(paquete);
            }  
            statement.close();
            return listaPaquetes;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "los paquetes almacenados");
            throw(e);

        }
       finally {
            this.cerrarConexion();
        }
    }

    public PaqueteDTO desembalarPaquete(PaqueteDTO paquete) throws SQLException, Exception {
       try {
           String desembalarPaquete = this.leerSQL("/ArchivosSQL/desembalarPaquete.sql");
           PreparedStatement stm = conexion.prepareStatement(desembalarPaquete);
           stm.setInt(1, paquete.getIdPaquete());
           stm.executeUpdate();
           statement.close();

           return paquete;
        } catch (Exception e) {
            System.out.println("Error al desembalarpaquete");
            throw(e);
        }
      finally {
            this.cerrarConexion();
        }
    
    }

    public PaqueteDTO crearPaquete(PaqueteDTO paquete) throws SQLException {
        try {
            
            String insertarPaquete= this.leerSQL("/ArchivosSQL/insertarPaquete.sql");
            PreparedStatement ps = conexion.prepareStatement(insertarPaquete);
            int tipo=this.obtenerTipoPaquete(paquete);
            ps.setInt(1, paquete.getIdPaquete());
            ps.setInt(2, paquete.getPeso());
            ps.setString(3, paquete.getDescripcion());
            ps.setBigDecimal(4, paquete.getValor());
            ps.setInt(5, tipo);
            ps.setInt(6, paquete.getIdCliente());
            ps.executeUpdate();
            
            
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
	       } finally {
            this.cerrarConexion();
        }
        return paquete;
    }

    private int obtenerTipoPaquete(PaqueteDTO paquete) throws Exception  {
         int idTipo = 0;    
         try {
            String obtenerTipoPaquete= this.leerSQL("/ArchivosSQL/obtenerTipoPaquete.sql");
            PreparedStatement stm = conexion.prepareStatement(obtenerTipoPaquete);
            stm.setString(1,paquete.getCategoria());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                idTipo=rs.getInt("idCategoriaPaquetes");
                
            }
            statement.close();
            return idTipo;
            


        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de obtener "
                    + "el tipo del cliente");
            throw(e);

        }
    }


    

}
