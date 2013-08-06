/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.divisiones;

import com.pasantia.dao.DepartamentoDAO;
import com.pasantia.dao.DivisionesDAO;
import com.pasantia.dao.DivisionesUbicacionDAO;
import com.pasantia.dao.PaisDAO;
import com.pasantia.dao.impl.DepartamentoDAOImpl;
import com.pasantia.dao.impl.DivisionesDAOImpl;
import com.pasantia.dao.impl.DivisionesUbicacionDAOImpl;
import com.pasantia.dao.impl.PaisDAOImpl;
import com.pasantia.entidades.Departamento;
import com.pasantia.entidades.Divisiones;
import com.pasantia.entidades.DivisionesUbicacion;
import com.pasantia.entidades.Pais;
import com.pasantia.utilidades.Utilidad;



import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;


import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;


/**
 *
 * @author root
 */
@Named(value = "agregarDivisionesBean")
@RequestScoped
public class agregarDivisionesBean {
    
    private String descripcion;
    private Divisiones divisiones;
    private DivisionesDAO divisionesDAO;
    private Dialog dlgNuevo;
    
    
    
    
    

    public void prepararGuardadoDelasDivisiones(){  
        dlgNuevo.setVisible(true);
    }  
    
    
    
   
    public void guardarNuevaDivision(){        
        
        if(descripcion.equals("") || descripcion.isEmpty() || descripcion==null){                       
            Utilidad.mensajeFatal("Error al guardar la division.", "Nombre de la division requerida.");            
        }
        else{              
            divisiones.setNombreDivision(descripcion);               
                if(divisionesDAO.insertarDivisiones(divisiones)){
                    Utilidad.mensajeInfo("Guardado Exitoso.", "Division guardada Exitosamente.");          
                }                
                else{
                    Utilidad.mensajeFatal("Guardado Incorrecto.", "...ERROR... al guardar.");          
                }
                descripcion="";            
           }
    }
    
    public void cancelarNuevaDivision(){
        dlgNuevo.setVisible(false);
        descripcion="";
    }
    
     public agregarDivisionesBean() {
        divisionesDAO = new DivisionesDAOImpl();
        dlgNuevo = new Dialog();
        divisiones = new Divisiones();
        
        //Valores por defecto
        dlgNuevo.setVisible(false);
    }
    

    public Dialog getDlgNuevo() {
        return dlgNuevo;
    }

    public void setDlgNuevo(Dialog dlgNuevo) {
        this.dlgNuevo = dlgNuevo;
    }   

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Divisiones getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(Divisiones divisiones) {
        this.divisiones = divisiones;
    }
    
    
    
   
    
         

    
    
   
   
    
   
    
   
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
    
    
    
}
