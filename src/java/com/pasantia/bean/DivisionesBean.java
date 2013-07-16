/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

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
import com.sun.faces.taglib.html_basic.PanelGridTag;
import java.util.ArrayList;
import java.util.List;
import javax.el.ValueExpression;
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

/**
 *
 * @author David Timana
 */
@Named(value = "divisionesBean")
@RequestScoped
public class DivisionesBean {

                         //******************************Inicio divisionBean*********************************************
   
    
    //*******************Inicio Declaracion de Atributos***********************************
    private Divisiones divisiones,divisiones2,divgeo;
    private List<Divisiones> divisioneslista;
    private Integer id;
    private String descripcion,pais,secdepartamento;
    private Departamento departamento;
    private Pais p;
    private Dialog dlgNuevaDivision,dlgeditardivision,dlgeliminarcomfirmar;
    private InputText txtdescripcioning,txtdescripcioneditar,txtideditar,txtideliminar;
    private OutputLabel lbldepartamento;
    private SelectOneMenu cmbdepartamento;
    private List<Pais> paises;
    private List<Departamento> departamentos;
    private List<SelectItem> paisescombo,departamentoscombo;
    private SelectOneMenu cmbpais;
    private CommandButton btnagregardivision,btnagregarubicacion,btngeolocalizacion;
    private List<DivisionesUbicacion> listubicaciones,liscomprobar,listaGeo;
    private DepartamentoDAO departamentoDAO;
    private PaisDAO paisDAO;
    private DivisionesUbicacion divisionesUbicacion;
    private String desasig;
    private DivisionesUbicacionDAO divisionesubicacionDAO;
    private OutputLabel lbltotalubicaciones,etiqueta,lblubigeo;
    private DataTable tblasigubicaciones,tblgeo;  
    private Dialog dlggeolocallizacion;
    private DivisionesDAO divDAO;
    //*******************FIn Declaracion de Atributos***********************************
    
    
    //*************************Inicio Declaracion De Metodos de divisionBean*********************************************
    public void prepararCargaGeolocalizacion(Integer id){
        
        
        System.out.println("llegando con id-->"+id);
//        Divisiones divu=new Divisiones();
//        divu = divDAO.buscarDivisionesporId(id);
//        String tituloDialog=divu.getNombreDivision();        
//        dlggeolocallizacion.setHeader("Geolocalizacion para: "+tituloDialog);
//        lblubigeo.setValue(tituloDialog);
//        
//        
//        this.setListaGeo(listaGeo);
        
        
    }
    
    public void prepararGuardadoDelasDivisiones(){
        divisiones=new Divisiones();
        dlgNuevaDivision.setVisible(Boolean.TRUE);
        tblasigubicaciones.setStyle("display: none");      
  }    
    
    
    public void cargarListaDepartamentoxpais(){  
        String secpais = cmbpais.getValue().toString();
        departamentoscombo = cargarDepartamentos(secpais);

        if (!departamentoscombo.isEmpty()) {
            this.setDepartamentoscombo(departamentoscombo);
            cmbdepartamento.setDisabled(Boolean.FALSE);
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "...Cuidado...", "Pais sin departamentos asociados o todos sus departamentos ya asignados."));
            cmbdepartamento.setDisabled(Boolean.TRUE);
        }        
        
    }
   
    public void guardarNuevaDivision(){
        DivisionesDAO divisionesDAO = new DivisionesDAOImpl();
        Divisiones d = new Divisiones();       
        
        if(descripcion.equals("") || descripcion.isEmpty() || descripcion==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                    , "Nombre de la division requerida."));                  }
        else{                    
            d.setNombreDivision(descripcion);
            this.setDesasig(d.getNombreDivision());
            divisiones.setNombreDivision(descripcion);
            divisionesDAO.insertarDivisiones(d);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Division Guardada Exitosamente"));                         
            cmbpais.setDisabled(Boolean.FALSE);
            txtdescripcioning.setReadonly(Boolean.TRUE);
            btnagregardivision.setDisabled(Boolean.TRUE);
            btnagregarubicacion.setDisabled(Boolean.FALSE);
           }
    } 
    
    public void asignarDepartamentoaUbicacion(){                  
        
        DivisionesDAO divisionDAO = new DivisionesDAOImpl();        
        
        if (pais == null || pais.equals("") || pais.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al guardar la division.", "Seleccion de pais requerido."));
        } else {
            if (secdepartamento == null || secdepartamento.equals("") || secdepartamento.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error al guardar la division.", "Seleccion de Departamento requerido."));
            } else {

                departamento = departamentoDAO.buscarDepartamentoporIdUno(Integer.parseInt(secdepartamento));
                divisiones2 = divisionDAO.buscarUltimaIngresada();
                divisionesUbicacion.setDepartamento(departamento);
                divisionesUbicacion.setDivisiones(divisiones2);
                divisionesubicacionDAO.insertarDivisionesUbicacion(divisionesUbicacion);
                this.setListubicaciones(divisionesubicacionDAO.buscarubicacionesxiddivision(divisiones2.getIdDivisiones()));
                lbltotalubicaciones.setValue(this.totalUbicaciones());
                tblasigubicaciones.setStyle("display: block");
                tblasigubicaciones.setEmptyMessage("No hay Ubicaciones para: " + divisiones2.getNombreDivision() + " disponibles.");
                etiqueta.setValue(divisiones2.getNombreDivision());

            }
        }
    } 
    
    public int totalDivisiones(){
        int total=divisioneslista.size();
        return total;
    }
    
    public int totalUbicaciones(){
        int total=listubicaciones.size();
        return total;
    }
    
    private List<SelectItem> cargarDepartamentos(String secpais){
        
        if (secpais != null && !secpais.equals("")) {
            departamentos = departamentoDAO.buscarDepartamentoporId(Integer.parseInt(pais));
        } else {
            departamentos = departamentoDAO.buscartodosDepartamentos();
        }

        for (int i = 0; i < departamentos.size(); i++) {
            int sec = departamentos.get(i).getIdDepartamento();
            liscomprobar = divisionesubicacionDAO.buscarubicacionesxidDepartamento(sec);
            if (!liscomprobar.isEmpty()) {
                departamentos.remove(i);
            }
        }
        
        departamentoscombo = new ArrayList<SelectItem>();
        for (int i = 0; i < departamentos.size(); i++) {
            departamentoscombo.add(new SelectItem(departamentos.get(i).getIdDepartamento(), departamentos.get(i).getNombreDepartamento()));
        }

        return departamentoscombo;
    }
    //*************************Fin Declaracion De Metodos de divisionBean*********************************************
    
    
    
    
    //********************************************Constructor por Defecto**************************************************************
    
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
        cmbpais = new SelectOneMenu();
        cmbdepartamento.setDisabled(Boolean.TRUE);
        btnagregardivision = new CommandButton();
        btnagregarubicacion = new  CommandButton();
        btnagregarubicacion.setDisabled(Boolean.TRUE);
        paisDAO = new PaisDAOImpl();
        departamentoDAO= new DepartamentoDAOImpl();
        divisiones2 = new Divisiones();
        p = new Pais();
        departamento = new Departamento();
        divisionesUbicacion = new DivisionesUbicacion();
        divisionesubicacionDAO = new DivisionesUbicacionDAOImpl();
        lbltotalubicaciones = new OutputLabel();
        tblasigubicaciones = new DataTable();
        tblasigubicaciones.setStyle("display: none");
        etiqueta = new  OutputLabel();
        departamentoscombo=cargarDepartamentos("");
        dlggeolocallizacion = new Dialog();
        tblgeo = new DataTable();
        divDAO = new DivisionesDAOImpl();
        divgeo = new Divisiones();
        lblubigeo = new OutputLabel();
        btngeolocalizacion = new CommandButton();
        
       // btngeolocalizacion.setOnclick("dlgMapa.show()");
    }
    
    
    //***********************Getters and Setters*************************************************
    
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
         
        paises = paisDAO.buscartodasPaises();
        paisescombo = new ArrayList<SelectItem>();
        for (int i = 0; i < paises.size(); i++) {
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

    public CommandButton getBtnagregardivision() {
        return btnagregardivision;
    }

    public void setBtnagregardivision(CommandButton btnagregardivision) {
        this.btnagregardivision = btnagregardivision;
    }

    public List<DivisionesUbicacion> getListubicaciones() {
        
        return listubicaciones;
    }

    public void setListubicaciones(List<DivisionesUbicacion> listubicaciones) {
        this.listubicaciones = listubicaciones;
    }

    public CommandButton getBtnagregarubicacion() {
        return btnagregarubicacion;
    }

    public void setBtnagregarubicacion(CommandButton btnagregarubicacion) {
        this.btnagregarubicacion = btnagregarubicacion;
    }

    public Divisiones getDivisiones2() {
        return divisiones2;
    }

    public void setDivisiones2(Divisiones divisiones2) {
        this.divisiones2 = divisiones2;
    }

    public Pais getP() {
        return p;
    }

    public void setP(Pais p) {
        this.p = p;
    }

    public DepartamentoDAO getDepartamentoDAO() {
        return departamentoDAO;
    }

    public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
        this.departamentoDAO = departamentoDAO;
    }

    public PaisDAO getPaisDAO() {
        return paisDAO;
    }

    public void setPaisDAO(PaisDAO paisDAO) {
        this.paisDAO = paisDAO;
    }

    public DivisionesUbicacion getDivisionesUbicacion() {
        return divisionesUbicacion;
    }

    public void setDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion) {
        this.divisionesUbicacion = divisionesUbicacion;
    }

    public String getDesasig() {
        return desasig;
    }

    public void setDesasig(String desasig) {
        this.desasig = desasig;
    }

    public DivisionesUbicacionDAO getDivisionesubicacionDAO() {
        return divisionesubicacionDAO;
    }

    public void setDivisionesubicacionDAO(DivisionesUbicacionDAO divisionesubicacionDAO) {
        this.divisionesubicacionDAO = divisionesubicacionDAO;
    }

    public OutputLabel getLbltotalubicaciones() {
        return lbltotalubicaciones;
    }

    public void setLbltotalubicaciones(OutputLabel lbltotalubicaciones) {
        this.lbltotalubicaciones = lbltotalubicaciones;
    }

    public DataTable getTblasigubicaciones() {
        return tblasigubicaciones;
    }

    public void setTblasigubicaciones(DataTable tblasigubicaciones) {
        this.tblasigubicaciones = tblasigubicaciones;
    }

    public OutputLabel getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(OutputLabel etiqueta) {
        this.etiqueta = etiqueta;
    }

    public List<DivisionesUbicacion> getLiscomprobar() {
        return liscomprobar;
    }

    public void setLiscomprobar(List<DivisionesUbicacion> liscomprobar) {
        this.liscomprobar = liscomprobar;
    }

    public Dialog getDlggeolocallizacion() {
        return dlggeolocallizacion;
    }

    public void setDlggeolocallizacion(Dialog dlggeolocallizacion) {
        this.dlggeolocallizacion = dlggeolocallizacion;
    }

    public List<DivisionesUbicacion> getListaGeo() {
        return listaGeo;
    }

    public void setListaGeo(List<DivisionesUbicacion> listaGeo) {
        this.listaGeo = listaGeo;
    }

    public DataTable getTblgeo() {
        return tblgeo;
    }

    public void setTblgeo(DataTable tblgeo) {
        this.tblgeo = tblgeo;
    }

    public Divisiones getDivgeo() {
        return divgeo;
    }

    public void setDivgeo(Divisiones divgeo) {
        this.divgeo = divgeo;
    }

    public DivisionesDAO getDivDAO() {
        return divDAO;
    }

    public void setDivDAO(DivisionesDAO divDAO) {
        this.divDAO = divDAO;
    }

    public OutputLabel getLblubigeo() {
        return lblubigeo;
    }

    public void setLblubigeo(OutputLabel lblubigeo) {
        this.lblubigeo = lblubigeo;
    }

    public CommandButton getBtngeolocalizacion() {
        return btngeolocalizacion;
    }

    public void setBtngeolocalizacion(CommandButton btngeolocalizacion) {
        this.btngeolocalizacion = btngeolocalizacion;
    }
    
    
    
}//******************************Fin divisionBean*********************************************
