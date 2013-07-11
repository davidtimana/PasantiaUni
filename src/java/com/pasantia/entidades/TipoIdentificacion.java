package com.pasantia.entidades;
// Generated 10/07/2013 05:30:45 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * TipoIdentificacion generated by hbm2java
 */
public class TipoIdentificacion  implements java.io.Serializable {


     private Integer idTipoIdentificacion;
     private String nombreTipoIdentificacion;
     private Set personas = new HashSet(0);

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(String nombreTipoIdentificacion, Set personas) {
       this.nombreTipoIdentificacion = nombreTipoIdentificacion;
       this.personas = personas;
    }
   
    public Integer getIdTipoIdentificacion() {
        return this.idTipoIdentificacion;
    }
    
    public void setIdTipoIdentificacion(Integer idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }
    public String getNombreTipoIdentificacion() {
        return this.nombreTipoIdentificacion;
    }
    
    public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
        this.nombreTipoIdentificacion = nombreTipoIdentificacion;
    }
    public Set getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Set personas) {
        this.personas = personas;
    }




}

