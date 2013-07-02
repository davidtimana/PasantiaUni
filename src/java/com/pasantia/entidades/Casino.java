package com.pasantia.entidades;
// Generated 18/05/2013 04:10:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Casino generated by hbm2java
 */
public class Casino  implements java.io.Serializable {


     private Integer idCasino;
     private Usuario usuario;
     private Pais pais;
     private String nombre;
     private String direccion;
     private String nit;
     private Set<Producto> productos = new HashSet<Producto>(0);
     private Set<Pais> paises = new HashSet<Pais>(0);

    public Casino() {
    }

	
    public Casino(Usuario usuario, Pais pais, String nombre, String direccion, String nit) {
        this.usuario = usuario;
        this.pais = pais;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
    }
    public Casino(Usuario usuario, Pais pais, String nombre, String direccion, String nit, Set<Producto> productos, Set<Pais> paises) {
       this.usuario = usuario;
       this.pais = pais;
       this.nombre = nombre;
       this.direccion = direccion;
       this.nit = nit;
       this.productos = productos;
       this.paises = paises;
    }
   
    public Integer getIdCasino() {
        return this.idCasino;
    }
    
    public void setIdCasino(Integer idCasino) {
        this.idCasino = idCasino;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
    public Set<Pais> getPaises() {
        return this.paises;
    }
    
    public void setPaises(Set<Pais> paises) {
        this.paises = paises;
    }




}


