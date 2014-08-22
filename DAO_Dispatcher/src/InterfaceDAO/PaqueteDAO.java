/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceDAO;

import DTO.PaqueteDTO;

/**
 *
 * @author Oscar Montes
 */
public interface PaqueteDAO {
 
   
    public PaqueteDTO desalmacenarPaquete(PaqueteDTO paquete) throws Exception;
}

