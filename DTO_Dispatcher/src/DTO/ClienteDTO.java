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
public class ClienteDTO {
    
     private int idCliente;
     private int numero_cuenta;
     private int puntos;
     private String nombre;
     private String tipo;
     private int telefono;
     private int idRutaEnvio;
    /**
     * @return the idClienteDTO
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idClienteDTO to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the numero_cuenta
     */
    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    /**
     * @param numero_cuenta the numero_cuenta to set
     */
    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

 
    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
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
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
