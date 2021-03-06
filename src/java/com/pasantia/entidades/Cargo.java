package com.pasantia.entidades;
// Generated 14/08/2013 07:56:36 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private Integer idCargo;
     private String descripcion;
     private Set personas = new HashSet(0);

    public Cargo() {
    }

	
    public Cargo(String descripcion) {
        this.descripcion = descripcion;
    }
    public Cargo(String descripcion, Set personas) {
       this.descripcion = descripcion;
       this.personas = personas;
    }
   
    public Integer getIdCargo() {
        return this.idCargo;
    }
    
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Set personas) {
        this.personas = personas;
    }




}


