/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import com.pasantia.dao.UbicacionDAO;
import com.pasantia.dao.impl.UbicacionDAOImpl;
import com.pasantia.entidades.Ubicacion;
import com.pasantia.entidades.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@ManagedBean(name="ubicacionBean")
@SessionScoped
public class UbicacionBean {

    private Ubicacion ubicacion;
    private List<Ubicacion> ubicaciones;
    private Usuario usuario;
    
    public UbicacionBean() {
        ubicacion=new Ubicacion();
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Ubicacion> getUbicaciones() {
        UbicacionDAO ubicacionDAO = new UbicacionDAOImpl();
        ubicaciones=ubicacionDAO.buscartodasUbicaciones();
        return ubicaciones;
    }
    public void prepararGuardadoDelaUbicacion(){
        ubicacion=new Ubicacion();
    }
    public void guardarNuevaUbicacion(){
        System.out.println("LLegue a guardar -->>>"+ubicacion.getDescripcion());
        UbicacionDAO ubicacionDAO = new UbicacionDAOImpl();
        ubicacionDAO.insertarUbicacion(ubicacion);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ubicacion Guardada Exitosamente"));
        ubicacion=new Ubicacion();
    }
    public void prepararActualizadoDeUbicacion(Integer Id){
        System.out.println("Preparando para actualizar una ubicacion con id:"+Id);
        UbicacionDAO ubicacionDAO=new UbicacionDAOImpl();
        ubicacion=ubicacionDAO.buscarUbicacionporId(Id);        
    }
    public void actualizarUbicacion(){
        System.out.println("Actualizando ubicacion");
        UbicacionDAO ubicacionDAO=new UbicacionDAOImpl();
        ubicacionDAO.actualizarUbicacion(ubicacion);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ubicacion Actualizada Exitosamente"));
        ubicacion=new Ubicacion();
    }
    public void eliminarUbicacion(){
        System.out.println("Eliminando ubicacion");
        UbicacionDAO ubicacionDAO = new UbicacionDAOImpl();
        ubicacionDAO.eliminarUbicacion(ubicacion);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Ubicacion Eliminada Exitosamente"));
        ubicacion=new Ubicacion();
    }
    public void prepararEliminarUbicacion(Integer Id){
        System.out.println("Preparando para eliminar una ubicacion con id:"+Id);
        UbicacionDAO ubicacionDAO=new UbicacionDAOImpl();
        ubicacion=ubicacionDAO.buscarUbicacionporId(Id);
    }
    
}
