package com.pasantia.entidades;
// Generated 18/05/2013 04:10:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Vendedores generated by hbm2java
 */
public class Vendedores  implements java.io.Serializable {


     private Integer idVendedores;
     private CatalogoVenta catalogoVenta;
     private String nombres;
     private String apellidos;
     private String cedula;
     private Set<Proveedor> proveedors = new HashSet<Proveedor>(0);

    public Vendedores() {
    }

	
    public Vendedores(CatalogoVenta catalogoVenta, String nombres, String apellidos, String cedula) {
        this.catalogoVenta = catalogoVenta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
    }
    public Vendedores(CatalogoVenta catalogoVenta, String nombres, String apellidos, String cedula, Set<Proveedor> proveedors) {
       this.catalogoVenta = catalogoVenta;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.cedula = cedula;
       this.proveedors = proveedors;
    }
   
    public Integer getIdVendedores() {
        return this.idVendedores;
    }
    
    public void setIdVendedores(Integer idVendedores) {
        this.idVendedores = idVendedores;
    }
    public CatalogoVenta getCatalogoVenta() {
        return this.catalogoVenta;
    }
    
    public void setCatalogoVenta(CatalogoVenta catalogoVenta) {
        this.catalogoVenta = catalogoVenta;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Set<Proveedor> getProveedors() {
        return this.proveedors;
    }
    
    public void setProveedors(Set<Proveedor> proveedors) {
        this.proveedors = proveedors;
    }




}

