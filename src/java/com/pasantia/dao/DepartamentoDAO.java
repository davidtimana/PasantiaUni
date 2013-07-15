/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao;

import com.pasantia.entidades.Departamento;
import java.util.List;

/**
 *
 * @author root
 */
public interface DepartamentoDAO {
    
    /**
     *Metodo que se encarga de
     * listar los departamentos
     * @return lista de departametos
     */
    public List<Departamento> buscartodosDepartamentos();
    
    /**
     *Metodo que se encarga de buscar
     * un departamento por su id
     * @param id
     * @return Departamento
     */
    public List<Departamento> buscarDepartamentoporId(Integer id);
    
    /**
     *Metodo que se encarga de buscar
     * un departamento por su id
     * @param id
     * @return Departamento
     */
    public Departamento buscarDepartamentoporIdUno(Integer id);
}
