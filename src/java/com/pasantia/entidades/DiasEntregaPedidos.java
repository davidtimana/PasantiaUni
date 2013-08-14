package com.pasantia.entidades;
// Generated 14/08/2013 07:56:36 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * DiasEntregaPedidos generated by hbm2java
 */
public class DiasEntregaPedidos  implements java.io.Serializable {


     private Integer idDiasEntregaPedidos;
     private int lunes;
     private int martes;
     private int miercoles;
     private int jueves;
     private int viernes;
     private int sabado;
     private int domingo;
     private Set catalogoVentas = new HashSet(0);

    public DiasEntregaPedidos() {
    }

	
    public DiasEntregaPedidos(int lunes, int martes, int miercoles, int jueves, int viernes, int sabado, int domingo) {
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
        this.sabado = sabado;
        this.domingo = domingo;
    }
    public DiasEntregaPedidos(int lunes, int martes, int miercoles, int jueves, int viernes, int sabado, int domingo, Set catalogoVentas) {
       this.lunes = lunes;
       this.martes = martes;
       this.miercoles = miercoles;
       this.jueves = jueves;
       this.viernes = viernes;
       this.sabado = sabado;
       this.domingo = domingo;
       this.catalogoVentas = catalogoVentas;
    }
   
    public Integer getIdDiasEntregaPedidos() {
        return this.idDiasEntregaPedidos;
    }
    
    public void setIdDiasEntregaPedidos(Integer idDiasEntregaPedidos) {
        this.idDiasEntregaPedidos = idDiasEntregaPedidos;
    }
    public int getLunes() {
        return this.lunes;
    }
    
    public void setLunes(int lunes) {
        this.lunes = lunes;
    }
    public int getMartes() {
        return this.martes;
    }
    
    public void setMartes(int martes) {
        this.martes = martes;
    }
    public int getMiercoles() {
        return this.miercoles;
    }
    
    public void setMiercoles(int miercoles) {
        this.miercoles = miercoles;
    }
    public int getJueves() {
        return this.jueves;
    }
    
    public void setJueves(int jueves) {
        this.jueves = jueves;
    }
    public int getViernes() {
        return this.viernes;
    }
    
    public void setViernes(int viernes) {
        this.viernes = viernes;
    }
    public int getSabado() {
        return this.sabado;
    }
    
    public void setSabado(int sabado) {
        this.sabado = sabado;
    }
    public int getDomingo() {
        return this.domingo;
    }
    
    public void setDomingo(int domingo) {
        this.domingo = domingo;
    }
    public Set getCatalogoVentas() {
        return this.catalogoVentas;
    }
    
    public void setCatalogoVentas(Set catalogoVentas) {
        this.catalogoVentas = catalogoVentas;
    }




}


