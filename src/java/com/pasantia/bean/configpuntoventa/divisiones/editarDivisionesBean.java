/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.divisiones;

import com.pasantia.dao.DivisionesDAO;
import com.pasantia.dao.impl.DivisionesDAOImpl;
import com.pasantia.entidades.Divisiones;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author root
 */
@Named(value = "editarDivisionesBean")
@RequestScoped
public class editarDivisionesBean implements Serializable{
    
    //*****************Inicio Atributos de la clase************************
    private Dialog dlgeditarDivisiones;
    private Divisiones division;
    private String nombreDivision;
    private Integer idDivision;
    private InputText txtnombreDivision;
    private DivisionesDAO divisionesDAO;
    //******************Fin Atributos de la clase**************************

    //****************Inicio Metodos de la clase***************************    
    public void cargarEdicion(Integer idDivision,String nombreDiv){
        System.out.println("Abriendo pop up editar con id division "+idDivision);
        division = divisionesDAO.buscarDivisionesporId(idDivision);
        System.out.println("El nombre de la division es el siguiente "+division.getNombreDivision());
        this.setNombreDivision(division.getNombreDivision());
        this.setIdDivision(idDivision);
        System.out.println("El nombre de la division es el siguiente 2"+nombreDivision);
        txtnombreDivision.setValue(nombreDivision);
        
        
        
    }
    //*****************Fin Metodos de la clase***************************    
    
    //**********************Getters and setters****************************

    public Integer getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(Integer idDivision) {
        this.idDivision = idDivision;
    }

    public String getNombreDivision() {
        return nombreDivision;
    }

    public void setNombreDivision(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }
    
    
    public InputText getTxtnombreDivision() {
        return txtnombreDivision;
    }

    public void setTxtnombreDivision(InputText txtnombreDivision) {
        this.txtnombreDivision = txtnombreDivision;
    }
    
    
    public Divisiones getDivision() {
        return division;
    }

    public void setDivision(Divisiones division) {
        this.division = division;
    }
    
    
    public Dialog getDlgeditarDivisiones() {
        return dlgeditarDivisiones;
    }

    public void setDlgeditarDivisiones(Dialog dlgeditarDivisiones) {
        this.dlgeditarDivisiones = dlgeditarDivisiones;
    }
    
    
    //*********************Constructor de la clase************************
    public editarDivisionesBean() {
       
        dlgeditarDivisiones = new Dialog();
        division = new Divisiones();
        txtnombreDivision = new InputText();
        //txtnombreDivision.setReadonly(true);
        divisionesDAO = new DivisionesDAOImpl();
    }
    
    
}
