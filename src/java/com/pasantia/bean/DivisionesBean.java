/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import com.pasantia.dao.DivisionesDAO;
import com.pasantia.dao.impl.DivisionesDAOImpl;
import com.pasantia.entidades.Divisiones;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author root
 */
@Named(value = "divisionesBean")
@RequestScoped
public class DivisionesBean {

   
    private Divisiones divisiones;
    private List<Divisiones> divisioneslista;
    private Integer id;
    private String descripcion;
    private int departamento;
    private Dialog dlgNuevaDivision,dlgeditardivision,dlgeliminarcomfirmar;
    private InputText txtdescripcioning,txtdescripcioneditar,txtideditar,txtideliminar;
    
    
    public DivisionesBean() {
        divisiones = new Divisiones();
        dlgNuevaDivision = new Dialog();
        dlgeditardivision = new Dialog();
        dlgeliminarcomfirmar = new Dialog();
        txtdescripcioning = new InputText();
        txtdescripcioneditar = new InputText();
        txtideditar = new InputText();
        txtideliminar = new InputText();
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
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

    public List<Divisiones> getDivisioneslista() {
        DivisionesDAO divisionesDAO = new DivisionesDAOImpl();
        divisioneslista = divisionesDAO.buscartodasDivisiones();
        return divisioneslista;
    }

    public void setDivisioneslista(List<Divisiones> divisioneslista) {
        this.divisioneslista = divisioneslista;
    }

    public Dialog getDlgNuevaDivision() {
        return dlgNuevaDivision;
    }

    public void setDlgNuevaDivision(Dialog dlgNuevaDivision) {
        this.dlgNuevaDivision = dlgNuevaDivision;
    }

    public Dialog getDlgeditardivision() {
        return dlgeditardivision;
    }

    public void setDlgeditardivision(Dialog dlgeditardivision) {
        this.dlgeditardivision = dlgeditardivision;
    }

    public Dialog getDlgeliminarcomfirmar() {
        return dlgeliminarcomfirmar;
    }

    public void setDlgeliminarcomfirmar(Dialog dlgeliminarcomfirmar) {
        this.dlgeliminarcomfirmar = dlgeliminarcomfirmar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InputText getTxtdescripcioneditar() {
        return txtdescripcioneditar;
    }

    public void setTxtdescripcioneditar(InputText txtdescripcioneditar) {
        this.txtdescripcioneditar = txtdescripcioneditar;
    }

    public InputText getTxtdescripcioning() {
        return txtdescripcioning;
    }

    public void setTxtdescripcioning(InputText txtdescripcioning) {
        this.txtdescripcioning = txtdescripcioning;
    }

    public InputText getTxtideditar() {
        return txtideditar;
    }

    public void setTxtideditar(InputText txtideditar) {
        this.txtideditar = txtideditar;
    }

    public InputText getTxtideliminar() {
        return txtideliminar;
    }

    public void setTxtideliminar(InputText txtideliminar) {
        this.txtideliminar = txtideliminar;
    }
    
    public void prepararGuardadoDelCargo(){
        divisiones=new Divisiones();
        dlgNuevaDivision.setVisible(Boolean.TRUE);        
    }
    
    public int totalDivisiones(){
        int total=divisioneslista.size();
        return total;
    }
    
    
    
}
