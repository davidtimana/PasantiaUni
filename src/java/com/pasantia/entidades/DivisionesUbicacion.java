package com.pasantia.entidades;
// Generated 17/07/2013 04:01:51 PM by Hibernate Tools 3.2.1.GA



/**
 * DivisionesUbicacion generated by hbm2java
 */
public class DivisionesUbicacion  implements java.io.Serializable {


     private Integer idDivisionesUbicacion;
     private Departamento departamento;
     private Divisiones divisiones;

    public DivisionesUbicacion() {
    }

    public DivisionesUbicacion(Departamento departamento, Divisiones divisiones) {
       this.departamento = departamento;
       this.divisiones = divisiones;
    }
   
    public Integer getIdDivisionesUbicacion() {
        return this.idDivisionesUbicacion;
    }
    
    public void setIdDivisionesUbicacion(Integer idDivisionesUbicacion) {
        this.idDivisionesUbicacion = idDivisionesUbicacion;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Divisiones getDivisiones() {
        return this.divisiones;
    }
    
    public void setDivisiones(Divisiones divisiones) {
        this.divisiones = divisiones;
    }




}


