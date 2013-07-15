/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao;

import com.pasantia.entidades.DivisionesUbicacion;
import java.util.List;

/**
 *
 * @author david
 */
public interface DivisionesUbicacionDAO {
    /**
     *Metodo que se encarga
     * de guardar los departamentos
     * a los cuales pertenece
     * @param divisionesUbicacion 
     */
    public void insertarDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion);
    
    /**
     *Metodo que se encarga
     * de eliminar los departamentos
     * a los cuales pertenece
     * @param divisionesUbicacion 
     */
    public boolean eliminarDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion);
    
    /**
     *Metodo que se encarga
     * de buscar las asignaciones
     * de ubicacion para las divisiones
     * @param id 
     */
    public List<DivisionesUbicacion> buscarubicacionesxiddivision();
}
