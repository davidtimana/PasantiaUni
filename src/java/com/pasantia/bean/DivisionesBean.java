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

   
    private Divisiones divisiones,divisiones2;
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
    private CommandButton btnagregardivision,btnagregarubicacion;
    private List<DivisionesUbicacion> listubicaciones;
    private DepartamentoDAO departamentoDAO;
    private PaisDAO paisDAO;
    private DivisionesUbicacion divisionesUbicacion;
    private String desasig;
    private DivisionesUbicacionDAO divisionesubicacionDAO;
    
    
    
    
    
    
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

    public CommandButton getBtnagregardivision() {
        return btnagregardivision;
    }

    public void setBtnagregardivision(CommandButton btnagregardivision) {
        this.btnagregardivision = btnagregardivision;
    }

    public List<DivisionesUbicacion> getListubicaciones() {
        listubicaciones=divisionesubicacionDAO.buscarubicacionesxiddivision();
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

   

    

    

    
    
    
    
    public void prepararGuardadoDelasDivisiones(){
        divisiones=new Divisiones();
        dlgNuevaDivision.setVisible(Boolean.TRUE);
        
        
        
    }
    
    
    
    public void cargarListaDepartamentoxpais(){
                
        
        
        String secpais = cmbpais.getValue().toString();      
        
        if(secpais!=null){
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
        DivisionesDAO divisionesDAO = new DivisionesDAOImpl();
        Divisiones d = new Divisiones();
        System.out.println("*************La descripcion es "+descripcion);       
        
        
        if(descripcion.equals("") || descripcion.isEmpty() || descripcion==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                    , "Nombre de la division requerida."));          
        }
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
        DivisionesDAO dDAO = new DivisionesDAOImpl();
        System.out.println("*************El departamento es "+secdepartamento);        
        System.out.println("*************El pais es "+pais);
        System.out.println("el desasig queda con -->");
        
        
        if(pais == null || pais.equals("") || pais.isEmpty()){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                    , "Seleccion de pais requerido."));
                    }else{
                        if(secdepartamento == null || secdepartamento.equals("") || secdepartamento.isEmpty()){
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Error al guardar la division."
                           , "Seleccion de Departamento requerido."));
                        }else{
                                
                                departamento=departamentoDAO.buscarDepartamentoporIdUno(Integer.parseInt(secdepartamento));
                                divisiones2=dDAO.buscarDivisionesporNombre(descripcion);
                                
                                System.out.println("divisiones 2 queda con"+divisiones2.getNombreDivision()+divisiones.getIdDivisiones());
                               
                               divisionesUbicacion.setDepartamento(departamento);
                               divisionesUbicacion.setDivisiones(divisiones2);
                               System.out.println("la division es "+divisionesUbicacion.getDepartamento().getNombreDepartamento());
                               System.out.println("el departamento es "+divisionesUbicacion.getDivisiones().getNombreDivision());
                               //listubicaciones.add(divisionesUbicacion);
                               divisionesubicacionDAO.insertarDivisionesUbicacion(divisionesUbicacion);
                               
                               
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
    
    public void inicializar(){
        
    }
    
    
    
    
}
