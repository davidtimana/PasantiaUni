package com.pasantia.entidades;
// Generated 13/07/2013 11:12:50 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * DetalleCompra generated by hbm2java
 */
public class DetalleCompra  implements java.io.Serializable {


     private Integer idDetalleCompra;
     private Proveedor proveedor;
     private Producto producto;
     private int cantidad;
     private long iva;
     private Long subtotal;
     private Long total;
     private Set inventarios = new HashSet(0);

    public DetalleCompra() {
    }

	
    public DetalleCompra(Proveedor proveedor, Producto producto, int cantidad, long iva) {
        this.proveedor = proveedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.iva = iva;
    }
    public DetalleCompra(Proveedor proveedor, Producto producto, int cantidad, long iva, Long subtotal, Long total, Set inventarios) {
       this.proveedor = proveedor;
       this.producto = producto;
       this.cantidad = cantidad;
       this.iva = iva;
       this.subtotal = subtotal;
       this.total = total;
       this.inventarios = inventarios;
    }
   
    public Integer getIdDetalleCompra() {
        return this.idDetalleCompra;
    }
    
    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public long getIva() {
        return this.iva;
    }
    
    public void setIva(long iva) {
        this.iva = iva;
    }
    public Long getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }
    public Long getTotal() {
        return this.total;
    }
    
    public void setTotal(Long total) {
        this.total = total;
    }
    public Set getInventarios() {
        return this.inventarios;
    }
    
    public void setInventarios(Set inventarios) {
        this.inventarios = inventarios;
    }




}


