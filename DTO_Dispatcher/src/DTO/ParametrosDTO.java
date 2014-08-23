/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.sql.Timestamp;

/**
 *
 * @author Oscar Montes
 */
public class ParametrosDTO {
     private Timestamp diaActual;
     private int porcent_vol_contenedor;
     private int costo_almacenado;

    /**
     * @return the diaActual
     */
    public Timestamp getDiaActual() {
        return diaActual;
    }

    /**
     * @param diaActual the diaActual to set
     */
    public void setDiaActual(Timestamp diaActual) {
        this.diaActual = diaActual;
    }

    /**
     * @return the porcent_vol_contenedor
     */
    public int getPorcent_vol_contenedor() {
        return porcent_vol_contenedor;
    }

    /**
     * @param porcent_vol_contenedor the porcent_vol_contenedor to set
     */
    public void setPorcent_vol_contenedor(int porcent_vol_contenedor) {
        this.porcent_vol_contenedor = porcent_vol_contenedor;
    }

    /**
     * @return the costo_almacenado
     */
    public int getCosto_almacenado() {
        return costo_almacenado;
    }

    /**
     * @param costo_almacenado the costo_almacenado to set
     */
    public void setCosto_almacenado(int costo_almacenado) {
        this.costo_almacenado = costo_almacenado;
    }
}
