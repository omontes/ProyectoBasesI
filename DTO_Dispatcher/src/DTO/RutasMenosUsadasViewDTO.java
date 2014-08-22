/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

/**
 *
 * @author Carlos
 */
public class RutasMenosUsadasViewDTO {
    private int idRutaEnvio;
    private String nombre;
    private String pto_salida;
    private String pto_llegada;

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
     * @return the pto_salida
     */
    public String getPto_salida() {
        return pto_salida;
    }

    /**
     * @param pto_salida the pto_salida to set
     */
    public void setPto_salida(String pto_salida) {
        this.pto_salida = pto_salida;
    }

    /**
     * @return the pto_llegada
     */
    public String getPto_llegada() {
        return pto_llegada;
    }

    /**
     * @param pto_llegada the pto_llegada to set
     */
    public void setPto_llegada(String pto_llegada) {
        this.pto_llegada = pto_llegada;
    }
}
