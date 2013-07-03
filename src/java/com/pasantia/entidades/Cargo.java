package com.pasantia.entidades;
// Generated 18/05/2013 04:10:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private Integer idCargo;
     private String descripcion;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Cargo() {
    }

	
    public Cargo(String descripcion) {
        this.descripcion = descripcion;
    }
    public Cargo(String descripcion, Set<Usuario> usuarios) {
       this.descripcion = descripcion;
       this.usuarios = usuarios;
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
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}

