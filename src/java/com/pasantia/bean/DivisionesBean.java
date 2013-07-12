/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import com.pasantia.dao.DepartamentoDAO;
import com.pasantia.dao.DivisionesDAO;
import com.pasantia.dao.PaisDAO;
import com.pasantia.dao.impl.DepartamentoDAOImpl;
import com.pasantia.dao.impl.DivisionesDAOImpl;
import com.pasantia.dao.impl.PaisDAOImpl;
import com.pasantia.entidades.Departamento;
import com.pasantia.entidades.Divisiones;
import com.pasantia.entidades.Pais;
import com.sun.faces.taglib.jsf_core.SelectItemsTag;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.xml.transform.OutputKeys;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;

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
    private String descripcion,pais,secdepartamento;
    private Departamento departamento;
    private Dialog dlgNuevaDivision,dlgeditardivision,dlgeliminarcomfirmar;
    private InputText txtdescripcioning,txtdescripcioneditar,txtideditar,txtideliminar;
    private OutputLabel lbldepartamento;
    private SelectOneMenu cmbdepartamento;
    private List<Pais> paises;
    private List<Departamento> departamentos;
    private List<SelectItem> paisescombo,departamentoscombo;
    private SelectOneMenu cmbpais;
    
    
    
    public DivisionesBean() {
        divisiones = new Divisiones();
        dlgNuevaDivision = new Dialog();
        dlgeditardivision = new Dialog();
        dlgeliminarcomfirmar = new Dialog();
        txtdescripcioning = new InputText();
        txtdescripcioneditar = new InputText();
        txtideditar = new InputText();
        txtideliminar = new InputText();
        cmbdepartamento = new SelectOneMenu();
        cmbdepartamento.setDisabled(Boolean.TRUE);

        
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
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
    
    public SelectOneMenu getCmbdepartamento() {
        
        return cmbdepartamento;
    }

    public void setCmbdepartamento(SelectOneMenu cmbdepartamento) {
        this.cmbdepartamento = cmbdepartamento;
    }

    public OutputLabel getLbldepartamento() {
        return lbldepartamento;
    }

    public void setLbldepartamento(OutputLabel lbldepartamento) {
        this.lbldepartamento = lbldepartamento;
    }

    public List<Pais> getPaises() {
        
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public List<SelectItem> getPaisescombo() {
        PaisDAO paisDAO = new PaisDAOImpl();
        paises=paisDAO.buscartodasPaises();
        paisescombo = new ArrayList<SelectItem>();
        for (int i=0;i<paises.size();i++){
            paisescombo.add(new SelectItem(paises.get(i).getIdPais(), paises.get(i).getNombrePais()));
        }
        return paisescombo;
    }

    public void setPaisescombo(List<SelectItem> paisescombo) {
        this.paisescombo = paisescombo;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<SelectItem> getDepartamentoscombo() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAOImpl();
        departamentos= departamentoDAO.buscartodosDepartamentos();
        departamentoscombo = new ArrayList<SelectItem>();
       
         for (int i=0;i<departamentos.size();i++) {
            departamentoscombo.add(new SelectItem(departamentos.get(i).getIdDepartamento(),departamentos.get(i).getNombreDepartamento()));
        }
        
        return departamentoscombo;
    }

    public void setDepartamentoscombo(List<SelectItem> departamentoscombo) {
        this.departamentoscombo = departamentoscombo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSecdepartamento() {        
        return secdepartamento;
    }

    public void setSecdepartamento(String secdepartamento) {
        this.secdepartamento = secdepartamento;
    }

    public SelectOneMenu getCmbpais() {
        return cmbpais;
    }

    public void setCmbpais(SelectOneMenu cmbpais) {
        this.cmbpais = cmbpais;
    }  
    
    public void prepararGuardadoDelasDivisiones(){
        divisiones=new Divisiones();
        dlgNuevaDivision.setVisible(Boolean.TRUE);       
        
    }
    
    
    public void cargarListaDepartamentoxpais(){
                
        DepartamentoDAO departamentoDAO = new DepartamentoDAOImpl();
        
        String secpais = cmbpais.getValue().toString();      
        
        if(secpais!=null || !secpais.equals("")){
            departamentos=departamentoDAO.buscarDepartamentoporId(Integer.parseInt(pais));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Cuidado."
                    , "No se ha seleccionado ningun pais."));
        }       
        
        departamentoscombo = new ArrayList<SelectItem>();
        for (int i=0;i<departamentos.size();i++) {
            departamentoscombo.add(new SelectItem(departamentos.get(i).getIdDepartamento(),departamentos.get(i).getNombreDepartamento()));
        }
        
       setDepartamentoscombo(departamentoscombo);
       cmbdepartamento.setDisabled(Boolean.FALSE);               
    }
   
    public void guardarNuevaDivision(){
        
        System.out.println("*************La descripcion es "+descripcion);
        System.out.println("*************El departamento es "+secdepartamento);
        
        System.out.println("*************El pais es "+pais);
        
        
        if(descripcion.equals("") || descripcion.isEmpty() || descripcion==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                    , "Nombre de la division requerida."));
            
        }
        else{
                    if(pais == null || pais.equals("") || pais.isEmpty()){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                    , "Seleccion de pais requerido."));
                    }else{
                        if(secdepartamento == null || secdepartamento.equals("") || descripcion==null){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                           , "Seleccion de Departamento requerido."));
                        }else{
                            
                            
                               FacesContext context = FacesContext.getCurrentInstance();
                                    context.addMessage(null, new FacesMessage("Division Guardada Exitosamente"));                         
                        }
                    }
            
        }
    }        
        
    
    
    public int totalDivisiones(){
        int total=divisioneslista.size();
        return total;
    }
    
    
    
    
    
}
