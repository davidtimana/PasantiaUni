package com.pasantia.entidades;
// Generated 17/07/2013 04:01:51 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Ubicacion generated by hbm2java
 */
public class Ubicacion  implements java.io.Serializable {


     private Integer idUbicacion;
     private String descripcion;
     private Set productos = new HashSet(0);

    public Ubicacion() {
    }

	
    public Ubicacion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Ubicacion(String descripcion, Set productos) {
       this.descripcion = descripcion;
       this.productos = productos;
    }
   
    public Integer getIdUbicacion() {
        return this.idUbicacion;
    }
    
    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


