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
public class ContenedorDTO {
     private String idContenedor;
     private int idRuta;
     private int peso_max;
     private int peso_actual;

    /**
     * @return the idContenedor
     */
   

    /**
     * @return the idRuta
     */
    public int getIdRuta() {
        return idRuta;
    }

    /**
     * @param idRuta the idRuta to set
     */
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    /**
     * @return the peso_max
     */
    public int getPeso_max() {
        return peso_max;
    }

    /**
     * @param peso_max the peso_max to set
     */
    public void setPeso_max(int peso_max) {
        this.peso_max = peso_max;
    }

    /**
     * @return the peso_actual
     */
    public int getPeso_actual() {
        return peso_actual;
    }

    /**
     * @param peso_actual the peso_actual to set
     */
    public void setPeso_actual(int peso_actual) {
        this.peso_actual = peso_actual;
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
    public void setIdContenedor(String idContenedor) {
        this.idContenedor = idContenedor;
    }

}
