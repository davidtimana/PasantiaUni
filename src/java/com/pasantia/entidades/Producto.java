package com.pasantia.entidades;
// Generated 17/07/2013 04:01:51 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer idProducto;
     private Casino casino;
     private Categoria categoria;
     private PrecioCompra precioCompra;
     private Ubicacion ubicacion;
     private String descripcion;
     private int cantidadActual;
     private long precioVenta1;
     private Long precioVenta2;
     private long iva;
     private String codigoBarras;
     private int cantidadMinima;
     private String imagen;
     private Set detalleVentas = new HashSet(0);
     private Set detalleCompras = new HashSet(0);

    public Producto() {
    }

	
    public Producto(Casino casino, Categoria categoria, PrecioCompra precioCompra, Ubicacion ubicacion, String descripcion, int cantidadActual, long precioVenta1, long iva, String codigoBarras, int cantidadMinima) {
        this.casino = casino;
        this.categoria = categoria;
        this.precioCompra = precioCompra;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.cantidadActual = cantidadActual;
        this.precioVenta1 = precioVenta1;
        this.iva = iva;
        this.codigoBarras = codigoBarras;
        this.cantidadMinima = cantidadMinima;
    }
    public Producto(Casino casino, Categoria categoria, PrecioCompra precioCompra, Ubicacion ubicacion, String descripcion, int cantidadActual, long precioVenta1, Long precioVenta2, long iva, String codigoBarras, int cantidadMinima, String imagen, Set detalleVentas, Set detalleCompras) {
       this.casino = casino;
       this.categoria = categoria;
       this.precioCompra = precioCompra;
       this.ubicacion = ubicacion;
       this.descripcion = descripcion;
       this.cantidadActual = cantidadActual;
       this.precioVenta1 = precioVenta1;
       this.precioVenta2 = precioVenta2;
       this.iva = iva;
       this.codigoBarras = codigoBarras;
       this.cantidadMinima = cantidadMinima;
       this.imagen = imagen;
       this.detalleVentas = detalleVentas;
       this.detalleCompras = detalleCompras;
    }
   
    public Integer getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    public Casino getCasino() {
        return this.casino;
    }
    
    public void setCasino(Casino casino) {
        this.casino = casino;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public PrecioCompra getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(PrecioCompra precioCompra) {
        this.precioCompra = precioCompra;
    }
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCantidadActual() {
        return this.cantidadActual;
    }
    
    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    public long getPrecioVenta1() {
        return this.precioVenta1;
    }
    
    public void setPrecioVenta1(long precioVenta1) {
        this.precioVenta1 = precioVenta1;
    }
    public Long getPrecioVenta2() {
        return this.precioVenta2;
    }
    
    public void setPrecioVenta2(Long precioVenta2) {
        this.precioVenta2 = precioVenta2;
    }
    public long getIva() {
        return this.iva;
    }
    
    public void setIva(long iva) {
        this.iva = iva;
    }
    public String getCodigoBarras() {
        return this.codigoBarras;
    }
    
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public int getCantidadMinima() {
        return this.cantidadMinima;
    }
    
    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Set getDetalleVentas() {
        return this.detalleVentas;
    }
    
    public void setDetalleVentas(Set detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
    public Set getDetalleCompras() {
        return this.detalleCompras;
    }
    
    public void setDetalleCompras(Set detalleCompras) {
        this.detalleCompras = detalleCompras;
    }




}


