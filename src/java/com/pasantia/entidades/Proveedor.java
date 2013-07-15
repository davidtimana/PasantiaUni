package com.pasantia.entidades;
// Generated 13/07/2013 11:12:50 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Proveedor generated by hbm2java
 */
public class Proveedor  implements java.io.Serializable {


     private Integer idProveedor;
     private Persona persona;
     private String nombre;
     private String telefono;
     private String direccion;
     private String nit;
     private Set detalleCompras = new HashSet(0);
     private Set compras = new HashSet(0);

    public Proveedor() {
    }

	
    public Proveedor(Persona persona, String nombre, String telefono, String direccion, String nit) {
        this.persona = persona;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nit = nit;
    }
    public Proveedor(Persona persona, String nombre, String telefono, String direccion, String nit, Set detalleCompras, Set compras) {
       this.persona = persona;
       this.nombre = nombre;
       this.telefono = telefono;
       this.direccion = direccion;
       this.nit = nit;
       this.detalleCompras = detalleCompras;
       this.compras = compras;
    }
   
    public Integer getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
    public Set getDetalleCompras() {
        return this.detalleCompras;
    }
    
    public void setDetalleCompras(Set detalleCompras) {
        this.detalleCompras = detalleCompras;
    }
    public Set getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set compras) {
        this.compras = compras;
    }




}


