package com.pasantia.entidades;
// Generated 17/07/2013 04:01:51 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Pais generated by hbm2java
 */
public class Pais  implements java.io.Serializable {


     private Integer idPais;
     private String nombrePais;
     private Set departamentos = new HashSet(0);

    public Pais() {
    }

	
    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    public Pais(String nombrePais, Set departamentos) {
       this.nombrePais = nombrePais;
       this.departamentos = departamentos;
    }
   
    public Integer getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }
    public String getNombrePais() {
        return this.nombrePais;
    }
    
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    public Set getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Set departamentos) {
        this.departamentos = departamentos;
    }




}


