package com.pasantia.entidades;
// Generated 17/07/2013 04:01:51 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Divisiones generated by hbm2java
 */
public class Divisiones  implements java.io.Serializable {


     private Integer idDivisiones;
     private String nombreDivision;
     private Set batallons = new HashSet(0);
     private Set divisionesUbicacions = new HashSet(0);

    public Divisiones() {
    }

	
    public Divisiones(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }
    public Divisiones(String nombreDivision, Set batallons, Set divisionesUbicacions) {
       this.nombreDivision = nombreDivision;
       this.batallons = batallons;
       this.divisionesUbicacions = divisionesUbicacions;
    }
   
    public Integer getIdDivisiones() {
        return this.idDivisiones;
    }
    
    public void setIdDivisiones(Integer idDivisiones) {
        this.idDivisiones = idDivisiones;
    }
    public String getNombreDivision() {
        return this.nombreDivision;
    }
    
    public void setNombreDivision(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }
    public Set getBatallons() {
        return this.batallons;
    }
    
    public void setBatallons(Set batallons) {
        this.batallons = batallons;
    }
    public Set getDivisionesUbicacions() {
        return this.divisionesUbicacions;
    }
    
    public void setDivisionesUbicacions(Set divisionesUbicacions) {
        this.divisionesUbicacions = divisionesUbicacions;
    }




}


