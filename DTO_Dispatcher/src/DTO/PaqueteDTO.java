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
public class PaqueteDTO {
     private int idPaquete;
     private int peso;
     private String descripcion;
     private BigDecimal valor;
     private String categoria;
     private String idContenedor;
     private int idCliente;
     private String estadoActual;
     private int estado;

    /**
     * @return the idPaqueteDTO
     */
    public int getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaqueteDTO to set
     */
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

  
    /**
     * @return the idContenedor
     */
    public String getIdContenedor() {
        return idContenedor;
    }

    /**
     * @param idContenedor the idContenedor to set
     */
    public void setIdContenedor(int idContenedor) {
        this.setIdContenedor(idContenedor);
    }

    /**
     * @return the estadoActual
     */
    public String getEstadoActual() {
        return estadoActual;
    }

    /**
     * @param estadoActual the estadoActual to set
     */
    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param Categoria the categoria to set
     */
    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

    /**
     * @param idContenedor the idContenedor to set
     */
    public void setIdContenedor(String idContenedor) {
        this.idContenedor = idContenedor;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
