package com.pasantia.entidades;
// Generated 13/07/2013 11:12:50 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Casino generated by hbm2java
 */
public class Casino  implements java.io.Serializable {


     private Integer idCasino;
     private Persona persona;
     private Batallon batallon;
     private String nombre;
     private String nit;
     private String telefono1;
     private String telefono2;
     private Set productos = new HashSet(0);

    public Casino() {
    }

	
    public Casino(Batallon batallon, String nombre, String nit, String telefono1) {
        this.batallon = batallon;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono1 = telefono1;
    }
    public Casino(Persona persona, Batallon batallon, String nombre, String nit, String telefono1, String telefono2, Set productos) {
       this.persona = persona;
       this.batallon = batallon;
       this.nombre = nombre;
       this.nit = nit;
       this.telefono1 = telefono1;
       this.telefono2 = telefono2;
       this.productos = productos;
    }
   
    public Integer getIdCasino() {
        return this.idCasino;
    }
    
    public void setIdCasino(Integer idCasino) {
        this.idCasino = idCasino;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Batallon getBatallon() {
        return this.batallon;
    }
    
    public void setBatallon(Batallon batallon) {
        this.batallon = batallon;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNit() {
        return this.nit;
    }
    
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getTelefono1() {
        return this.telefono1;
    }
    
    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
    public String getTelefono2() {
        return this.telefono2;
    }
    
    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


