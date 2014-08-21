/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.math.BigDecimal;

/**
 *
 * @author Oscar Montes
 */
public class RutaEnvioDTO {
     private String nombre;
     private int idRutaEnvio;
     private String pto_llegada;
     private String pto_salida;
     private int tiempo_dias;
     private BigDecimal costo;
     private int maximocontenedor;

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
     * @return the tiempo_dias
     */
    public int getTiempo_dias() {
        return tiempo_dias;
    }

    /**
     * @param tiempo_dias the tiempo_dias to set
     */
    public void setTiempo_dias(int tiempo_dias) {
        this.tiempo_dias = tiempo_dias;
    }

    /**
     * @return the costo
     */
    public BigDecimal getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    /**
     * @return the maximocontenedor
     */
    public int getMaximocontenedor() {
        return maximocontenedor;
    }

    /**
     * @param maximocontenedor the maximocontenedor to set
     */
    public void setMaximocontenedor(int maximocontenedor) {
        this.maximocontenedor = maximocontenedor;
    }
}
