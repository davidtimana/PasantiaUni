package com.pasantia.entidades;
// Generated 13/07/2013 11:12:50 AM by Hibernate Tools 3.2.1.GA



/**
 * Inventario generated by hbm2java
 */
public class Inventario  implements java.io.Serializable {


     private Integer idInventario;
     private DetalleVenta detalleVenta;
     private DetalleCompra detalleCompra;
     private int cantidad;

    public Inventario() {
    }

    public Inventario(DetalleVenta detalleVenta, DetalleCompra detalleCompra, int cantidad) {
       this.detalleVenta = detalleVenta;
       this.detalleCompra = detalleCompra;
       this.cantidad = cantidad;
    }
   
    public Integer getIdInventario() {
        return this.idInventario;
    }
    
    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }
    public DetalleVenta getDetalleVenta() {
        return this.detalleVenta;
    }
    
    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
    public DetalleCompra getDetalleCompra() {
        return this.detalleCompra;
    }
    
    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


