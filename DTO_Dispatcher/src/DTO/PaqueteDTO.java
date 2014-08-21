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
     private int idCategoria;
     private int idContenedor;
     private String estadoActual;

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
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the idContenedor
     */
    public int getIdContenedor() {
        return idContenedor;
    }

    /**
     * @param idContenedor the idContenedor to set
     */
    public void setIdContenedor(int idContenedor) {
        this.idContenedor = idContenedor;
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
}
