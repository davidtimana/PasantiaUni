package com.pasantia.entidades;
// Generated 14/08/2013 07:56:36 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private Integer idCategoria;
     private String descripcion;
     private Set productos = new HashSet(0);

    public Categoria() {
    }

	
    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }
    public Categoria(String descripcion, Set productos) {
       this.descripcion = descripcion;
       this.productos = productos;
    }
   
    public Integer getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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


