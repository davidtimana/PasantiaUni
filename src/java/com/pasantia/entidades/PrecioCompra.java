package com.pasantia.entidades;
// Generated 18/05/2013 04:10:49 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PrecioCompra generated by hbm2java
 */
public class PrecioCompra  implements java.io.Serializable {


     private Integer idPrecioCompra;
     private Date fecha;
     private long precio;
     private Integer activo;
     private Set<Producto> productos = new HashSet<Producto>(0);

    public PrecioCompra() {
    }

	
    public PrecioCompra(Date fecha, long precio) {
        this.fecha = fecha;
        this.precio = precio;
    }
    public PrecioCompra(Date fecha, long precio, Integer activo, Set<Producto> productos) {
       this.fecha = fecha;
       this.precio = precio;
       this.activo = activo;
       this.productos = productos;
    }
   
    public Integer getIdPrecioCompra() {
        return this.idPrecioCompra;
    }
    
    public void setIdPrecioCompra(Integer idPrecioCompra) {
        this.idPrecioCompra = idPrecioCompra;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public long getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(long precio) {
        this.precio = precio;
    }
    public Integer getActivo() {
        return this.activo;
    }
    
    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }




}

