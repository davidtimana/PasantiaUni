/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import com.pasantia.dao.RolDAO;
import com.pasantia.dao.impl.RolDAOImpl;
import com.pasantia.entidades.Rol;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@ManagedBean(name="rolBean")
@SessionScoped
public class RolBean {

    private Rol rol;
    private List<Rol> roles;
    
    public RolBean() {
        rol=new Rol();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRoles() {
        RolDAO rolDAO = new RolDAOImpl();
        roles=rolDAO.buscartodosRoles();
        return roles;
    }
    public void prepararGuardadoDelRol(){
        rol=new Rol();        
    }
    public void guardarNuevoRol(){
        System.out.println("Guardado del nuevo rol: "+rol.getDescripcion());
        RolDAO rolDAO = new RolDAOImpl();
        rolDAO.insertarRol(rol);
        FacesContext context = FacesContext.getCurrentInstance();          
        context.addMessage(null, new FacesMessage("Rol Guardado Exitosamente."));        
        rol=new Rol();        
    }
    
    public void prepararActualizadoDelRol(Integer Id){
        RolDAO rolDAO=new RolDAOImpl();
        rol=rolDAO.buscarRolPorId(Id);        
    }
    public void actualizarRol(){
        RolDAO rolDAO = new RolDAOImpl();
        rolDAO.actualizarRol(rol);
        FacesContext context = FacesContext.getCurrentInstance();          
        context.addMessage(null, new FacesMessage("Rol Actualizado Exitosamente."));        
        rol=new Rol();                
    }
     public void eliminarRol(){
        RolDAO rolDAO = new RolDAOImpl();
        rolDAO.eliminarRol(rol);
        FacesContext context = FacesContext.getCurrentInstance();          
        context.addMessage(null, new FacesMessage("Rol Eliminado Exitosamente."));        
        rol=new Rol();                
    }
     public void prepararEliminarDelRol(Integer Id){
        RolDAO rolDAO=new RolDAOImpl();
        rol=rolDAO.buscarRolPorId(Id);        
    }
    
              
             
    
}
