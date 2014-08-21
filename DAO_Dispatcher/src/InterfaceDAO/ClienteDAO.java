/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceDAO;

import DTO.ClienteDTO;
import DTO.PaqueteDTO;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public interface ClienteDAO {
    public ArrayList<PaqueteDTO> findAllPaquetes(String cliente);
}
