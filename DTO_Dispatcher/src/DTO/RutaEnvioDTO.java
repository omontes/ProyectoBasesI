/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Oscar Montes
 */
public class RutaEnvioDTO {
     private String nombre;
     private int idRutaEnvio;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idRutaEnvio
     */
    public int getIdRutaEnvio() {
        return idRutaEnvio;
    }

    /**
     * @param idRutaEnvio the idRutaEnvio to set
     */
    public void setIdRutaEnvio(int idRutaEnvio) {
        this.idRutaEnvio = idRutaEnvio;
    }
}
