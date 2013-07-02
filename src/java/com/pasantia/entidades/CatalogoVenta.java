package com.pasantia.entidades;
// Generated 18/05/2013 04:10:49 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * CatalogoVenta generated by hbm2java
 */
public class CatalogoVenta  implements java.io.Serializable {


     private Integer idCatalogoVenta;
     private DiasEntregaPedidos diasEntregaPedidos;
     private DiasPedidos diasPedidos;
     private String descripcion;
     private Set<Vendedores> vendedoreses = new HashSet<Vendedores>(0);

    public CatalogoVenta() {
    }

	
    public CatalogoVenta(DiasEntregaPedidos diasEntregaPedidos, DiasPedidos diasPedidos, String descripcion) {
        this.diasEntregaPedidos = diasEntregaPedidos;
        this.diasPedidos = diasPedidos;
        this.descripcion = descripcion;
    }
    public CatalogoVenta(DiasEntregaPedidos diasEntregaPedidos, DiasPedidos diasPedidos, String descripcion, Set<Vendedores> vendedoreses) {
       this.diasEntregaPedidos = diasEntregaPedidos;
       this.diasPedidos = diasPedidos;
       this.descripcion = descripcion;
       this.vendedoreses = vendedoreses;
    }
   
    public Integer getIdCatalogoVenta() {
        return this.idCatalogoVenta;
    }
    
    public void setIdCatalogoVenta(Integer idCatalogoVenta) {
        this.idCatalogoVenta = idCatalogoVenta;
    }
    public DiasEntregaPedidos getDiasEntregaPedidos() {
        return this.diasEntregaPedidos;
    }
    
    public void setDiasEntregaPedidos(DiasEntregaPedidos diasEntregaPedidos) {
        this.diasEntregaPedidos = diasEntregaPedidos;
    }
    public DiasPedidos getDiasPedidos() {
        return this.diasPedidos;
    }
    
    public void setDiasPedidos(DiasPedidos diasPedidos) {
        this.diasPedidos = diasPedidos;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set<Vendedores> getVendedoreses() {
        return this.vendedoreses;
    }
    
    public void setVendedoreses(Set<Vendedores> vendedoreses) {
        this.vendedoreses = vendedoreses;
    }




}


