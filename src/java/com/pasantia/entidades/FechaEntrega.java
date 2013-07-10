package com.pasantia.entidades;
// Generated 10/07/2013 05:30:45 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FechaEntrega generated by hbm2java
 */
public class FechaEntrega  implements java.io.Serializable {


     private Integer idFechaEntrega;
     private Date fecha;
     private Set compras = new HashSet(0);

    public FechaEntrega() {
    }

	
    public FechaEntrega(Date fecha) {
        this.fecha = fecha;
    }
    public FechaEntrega(Date fecha, Set compras) {
       this.fecha = fecha;
       this.compras = compras;
    }
   
    public Integer getIdFechaEntrega() {
        return this.idFechaEntrega;
    }
    
    public void setIdFechaEntrega(Integer idFechaEntrega) {
        this.idFechaEntrega = idFechaEntrega;
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


