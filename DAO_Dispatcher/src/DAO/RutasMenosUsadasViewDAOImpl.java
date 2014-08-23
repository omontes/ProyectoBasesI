/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import DTO.RutasMenosUsadasViewDTO;
import InterfaceDAO.RutasMenosUsadasViewDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Carlos
 */
public class RutasMenosUsadasViewDAOImpl  extends DAO implements RutasMenosUsadasViewDAO{
    
    public RutasMenosUsadasViewDAOImpl() throws SQLException, NamingException {
        
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
    public ArrayList<RutasMenosUsadasViewDTO> getRutas() {
        ArrayList<RutasMenosUsadasViewDTO> ListaRutas = new ArrayList<>();
        try {
            String ConsultaRutasMenosUsadas= this.leerSQL("/ArchivosSQL/RutasMenosUsadas.sql");
            ResultSet rs = statement.executeQuery(ConsultaRutasMenosUsadas);
            while (rs.next()) {
                RutasMenosUsadasViewDTO ruta = new RutasMenosUsadasViewDTO();
                ruta.setNombre(rs.getString("nombre"));
                ruta.setIdRutaEnvio(rs.getInt("idRutaEnvio"));
                ruta.setPto_llegada(rs.getString("pto_llegada"));
                ruta.setPto_salida(rs.getString("pto_salida"));
                ListaRutas.add(ruta);
            }  
            statement.close();
            return ListaRutas;
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de los rutas menos utilizadas");
            try {
                throw(e);
            } catch (Exception ex) {
                Logger.getLogger(RutasMenosUsadasViewDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
