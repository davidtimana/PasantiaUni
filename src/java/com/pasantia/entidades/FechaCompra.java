package com.pasantia.entidades;
// Generated 14/08/2013 07:56:36 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FechaCompra generated by hbm2java
 */
public class FechaCompra  implements java.io.Serializable {


     private Integer idFechaCompra;
     private Date fecha;
     private Set compras = new HashSet(0);

    public FechaCompra() {
    }

	
    public FechaCompra(Date fecha) {
        this.fecha = fecha;
    }
    public FechaCompra(Date fecha, Set compras) {
       this.fecha = fecha;
       this.compras = compras;
    }
   
    public Integer getIdFechaCompra() {
        return this.idFechaCompra;
    }
    
    public void setIdFechaCompra(Integer idFechaCompra) {
        this.idFechaCompra = idFechaCompra;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getCompras() {
        return this.compras;
    }
    
    public void setCompras(Set compras) {
        this.compras = compras;
    }




}


