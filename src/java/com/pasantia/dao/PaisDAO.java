/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao;

import com.pasantia.entidades.Pais;
import java.util.List;

/**
 *
 * @author root
 */
public interface PaisDAO {
    
    /**
     *Metodo que se encarga de
     * listar los paises
     * @return lista de paises
     */
    public List<Pais> buscartodasPaises();
    
}
