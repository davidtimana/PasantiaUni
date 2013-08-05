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
    
    private Divisiones divisiones,ultimaDivision;
    private Dialog dlggeolocallizacion; 
    private DataTable tblasigubicaciones; 
    private String descripcion,titulo;
    private InputText txtdescripcioning;
    private CommandButton btnagregardivision;    
    private Utilidad utilidadMensajes;
    private DivisionesDAO divisionesDAO;
    private Integer secpais;
    private SelectOneMenu cmbpais,cmbdepartamento;
    private List<SelectItem> paisescombo,departamentoscombo;
    private List<Pais> paises;
    private PaisDAO paisDAO;
    private List<Departamento> departamentos;
    private DepartamentoDAO departamentoDAO;
    private Integer secdepartamento;
    private DivisionesUbicacionDAO divisionesUbicacionDAO;
    private List<DivisionesUbicacion> divisionesUbicacionlistcomprobar,divisionesUbicacionGuardadas;
    private Departamento departamento;
    private Integer secdivisionUltima,total;
    private DivisionesUbicacion divisionesUbicacion,divisionesUbicacionEliminar;
    
    
    
    

    public void prepararGuardadoDelasDivisiones(){  
        iniciarDialog();       
    }  
    public void prepararEliminadoUbicacion(Integer idDivisionUbicacion){
        System.out.println("funciona con objeto es el siguiente-->"+idDivisionUbicacion);
        System.out.println("buscando para eliminar");
        divisionesUbicacionEliminar = divisionesUbicacionDAO.buscarubicacionesxid(idDivisionUbicacion);
    }
    
    
    public void eliminarUbicacion(){
        System.out.println("entrando a eliminar con -->"+divisionesUbicacionEliminar.getIdDivisionesUbicacion());
        if(divisionesUbicacionDAO.eliminarDivisionesUbicacion(divisionesUbicacionEliminar)){
            Utilidad.mensajeInfo("Eliminar Ubicaciones.", "Ubicacion Eliminada correctamente.");
            cargarListaDepartamentoxpais();
        }else{
            Utilidad.mensajeFatal("Eliminar Ubicaciones", "Error al eliminar la ubicacion.");
        }
    }
    
    public void cargarListaDepartamentoxpais(){  
        //String secpais = cmbpais.getValue().toString();
        System.out.println("cambiando*********************");
        departamentos = departamentoDAO.buscarDepartamentoporIdPais(secpais);
        eliminarDepartamentosSeleccioanados();
        departamentoscombo = new ArrayList<SelectItem>();
            for (int i = 0; i < departamentos.size(); i++) {
              departamentoscombo.add(new SelectItem(departamentos.get(i).getIdDepartamento(), departamentos.get(i).getNombreDepartamento()));
            }
        
        if (!departamentoscombo.isEmpty()) {
            this.setDepartamentoscombo(departamentoscombo);
            cmbdepartamento.setDisabled(Boolean.FALSE);
        } else {
            Utilidad.mensajePeligro("...Cuidado...", "Pais sin departamentos asociados o todos sus departamentos ya asignados.");            
            cmbdepartamento.setDisabled(Boolean.TRUE);
        }        
        
    }
   
    public void guardarNuevaDivision(){        
        
        if(descripcion.equals("") || descripcion.isEmpty() || descripcion==null){                       
            Utilidad.mensajeFatal("Error al guardar la division.", "Nombre de la division requerida.");
            //Utilidad.abrirDialog("dlgNuevo");
        }
        else{  
            Utilidad.abrirDialog("dlgNuevo");
            System.out.println("vacio");
            divisiones.setNombreDivision(descripcion);
            //this.setDesasig(d.getNombreDivision());
            //divisiones.setNombreDivision(descripcion);
            divisionesDAO.insertarDivisiones(divisiones);
            Utilidad.mensajeInfo("Guardado Exitoso.", "Division guardada Exitosamente.");
            cmbpais.setDisabled(Boolean.FALSE);
            txtdescripcioning.setReadonly(Boolean.TRUE);
            btnagregardivision.setDisabled(Boolean.TRUE);
//            btnagregarubicacion.setDisabled(Boolean.FALSE);
           }
    } 
    
    public void asignarDepartamentoaUbicacion(){                  
        
       
        System.out.println("el pais es--->"+secpais);
        if (secpais==null) {            
            Utilidad.mensajeFatal("Error al guardar la division.", "Seleccion de pais requerido.");
            //Utilidad.abrirDialog("dlgNuevo");
        } else {
            if (secdepartamento==null) {
                Utilidad.mensajeFatal("Error al guardar la division.", "Seleccion de Departamento requerido.");
                //Utilidad.abrirDialog("dlgNuevo");
            } else {
                  //Utilidad.abrirDialog("dlgNuevo");
                  departamento = departamentoDAO.buscarDepartamentoporIdUno(secdepartamento);
                  System.out.println("asignando departamento "+departamento.getNombreDepartamento());
                  secdivisionUltima = divisionesDAO.buscarUltimaIngresada();
                  System.out.println("obteniendo secuencial ultima division "+secdivisionUltima);
                  ultimaDivision = divisionesDAO.buscarDivisionesporId(secdivisionUltima);
                  System.out.println("asignando division "+ultimaDivision.getNombreDivision());
                  divisionesUbicacion.setDepartamento(departamento);
                  divisionesUbicacion.setDivisiones(ultimaDivision);
                  divisionesUbicacionDAO.insertarDivisionesUbicacion(divisionesUbicacion);
                  divisionesUbicacionGuardadas = divisionesUbicacionDAO.buscarubicacionesxiddivision(secdivisionUltima);
                  total=divisionesUbicacionGuardadas.size();
                  tblasigubicaciones.setStyle("display: block");
                  tblasigubicaciones.setEmptyMessage("No hay Ubicaciones para: " + ultimaDivision.getNombreDivision() + " disponibles.");
                  titulo=ultimaDivision.getNombreDivision();
                  cargarListaDepartamentoxpais();

            }
        }
    }
    
    private void cargarDepartamentos(){            
     
            departamentos = departamentoDAO.buscartodosDepartamentos();
            eliminarDepartamentosSeleccioanados();
            departamentoscombo = new ArrayList<SelectItem>();
            for (int i = 0; i < departamentos.size(); i++) {
            departamentoscombo.add(new SelectItem(departamentos.get(i).getIdDepartamento(), departamentos.get(i).getNombreDepartamento()));
        }
    }      

    public void iniciarDialog(){
       
        //RequestContext.getCurrentInstance().update(":frmnuevadivision");
        tblasigubicaciones.setStyle("display: none");
        cmbpais.setDisabled(Boolean.TRUE);
        cmbdepartamento.setDisabled(Boolean.TRUE);
        txtdescripcioning.setReadonly(Boolean.FALSE);
        btnagregardivision.setDisabled(Boolean.FALSE);
        cargarPaises();
        cargarDepartamentos();
    }
    
    public int totalUbicaciones(){
        int total=divisionesUbicacionGuardadas.size();
        return total;
    }
    
    public void cargarDivisionesUbicacion(){
        divisionesUbicacionGuardadas = divisionesUbicacionDAO.buscarubicaciones();
    }
    
    public void cargarPaises(){
        paises = paisDAO.buscartodasPaises();
        paisescombo = new ArrayList<SelectItem>();
        for (int i = 0; i < paises.size(); i++) {
            paisescombo.add(new SelectItem(paises.get(i).getIdPais(), paises.get(i).getNombrePais()));
        }
    }
    
    public void eliminarDepartamentosSeleccioanados(){
        for (int i = 0; i < departamentos.size(); i++) {
            int sec = departamentos.get(i).getIdDepartamento();
            divisionesUbicacionlistcomprobar = divisionesUbicacionDAO.buscarubicacionesxidDepartamento(sec);
            if (!divisionesUbicacionlistcomprobar.isEmpty()) {
                departamentos.remove(i);
            }
        }
    }
    
    public agregarDivisionesBean() {
        divisiones = new Divisiones();        
        tblasigubicaciones = new DataTable();
        dlggeolocallizacion = new Dialog();        
        txtdescripcioning = new InputText();
        btnagregardivision = new CommandButton();
        cmbdepartamento = new SelectOneMenu();
        cmbpais = new SelectOneMenu();
        paisDAO = new PaisDAOImpl();
        divisionesUbicacion = new DivisionesUbicacion();
        divisionesUbicacionEliminar = new DivisionesUbicacion();
        
        titulo="";
        total=0;
        secdivisionUltima=0;        
        ultimaDivision = new Divisiones();
        departamento = new Departamento();
        divisionesUbicacionDAO = new DivisionesUbicacionDAOImpl();
        secpais=0;
        secdepartamento=0;        
        departamentoDAO = new DepartamentoDAOImpl();
        cmbpais.setDisabled(Boolean.TRUE);
        cmbdepartamento.setDisabled(Boolean.TRUE);
        divisionesDAO = new DivisionesDAOImpl();
        tblasigubicaciones.setStyle("display: none");
        txtdescripcioning.setReadonly(false);
        btnagregardivision.setDisabled(false);
        dlggeolocallizacion.setVisible(false);
        cargarPaises();
        cargarDepartamentos();
        cargarDivisionesUbicacion();
  
    }
    
    
    
    public List<SelectItem> getPaisescombo() {      
        return paisescombo;
    }

    public void setPaisescombo(List<SelectItem> paisescombo) {
        this.paisescombo = paisescombo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputText getTxtdescripcioning() {
        return txtdescripcioning;
    }

    public void setTxtdescripcioning(InputText txtdescripcioning) {
        this.txtdescripcioning = txtdescripcioning;
    }

    public CommandButton getBtnagregardivision() {
        return btnagregardivision;
    }

    public void setBtnagregardivision(CommandButton btnagregardivision) {
        this.btnagregardivision = btnagregardivision;
    }

    public Utilidad getUtilidadMensajes() {
        return utilidadMensajes;
    }

    public void setUtilidadMensajes(Utilidad utilidadMensajes) {
        this.utilidadMensajes = utilidadMensajes;
    }

    public Divisiones getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(Divisiones divisiones) {
        this.divisiones = divisiones;
    }
   
    public SelectOneMenu getCmbpais() {
        return cmbpais;
    }

    public void setCmbpais(SelectOneMenu cmbpais) {
        this.cmbpais = cmbpais;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
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

    public SelectOneMenu getCmbdepartamento() {
        return cmbdepartamento;
    }

    public void setCmbdepartamento(SelectOneMenu cmbdepartamento) {
        this.cmbdepartamento = cmbdepartamento;
    }

    public Integer getSecdepartamento() {
        return secdepartamento;
    }

    public void setSecdepartamento(Integer secdepartamento) {
        this.secdepartamento = secdepartamento;
    }

    public Integer getSecpais() {
        return secpais;
    }

    public void setSecpais(Integer secpais) {
        this.secpais = secpais;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacionlistcomprobar() {
        return divisionesUbicacionlistcomprobar;
    }

    public void setDivisionesUbicacionlistcomprobar(List<DivisionesUbicacion> divisionesUbicacionlistcomprobar) {
        this.divisionesUbicacionlistcomprobar = divisionesUbicacionlistcomprobar;
    }

    public DataTable getTblasigubicaciones() {
        return tblasigubicaciones;
    }

    public void setTblasigubicaciones(DataTable tblasigubicaciones) {
        this.tblasigubicaciones = tblasigubicaciones;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacionGuardadas() {
        return divisionesUbicacionGuardadas;
    }

    public void setDivisionesUbicacionGuardadas(List<DivisionesUbicacion> divisionesUbicacionGuardadas) {
        this.divisionesUbicacionGuardadas = divisionesUbicacionGuardadas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Divisiones getUltimaDivision() {
        return ultimaDivision;
    }

    public void setUltimaDivision(Divisiones ultimaDivision) {
        this.ultimaDivision = ultimaDivision;
    }

    public Integer getSecdivisionUltima() {
        return secdivisionUltima;
    }

    public void setSecdivisionUltima(Integer secdivisionUltima) {
        this.secdivisionUltima = secdivisionUltima;
    }

    public DivisionesUbicacion getDivisionesUbicacion() {
        return divisionesUbicacion;
    }

    public void setDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion) {
        this.divisionesUbicacion = divisionesUbicacion;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public DivisionesUbicacion getDivisionesUbicacionEliminar() {
        return divisionesUbicacionEliminar;
    }

    public void setDivisionesUbicacionEliminar(DivisionesUbicacion divisionesUbicacionEliminar) {
        this.divisionesUbicacionEliminar = divisionesUbicacionEliminar;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
    
    
    
}
