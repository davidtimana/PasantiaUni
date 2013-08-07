/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.divisiones;


import com.pasantia.dao.DepartamentoDAO;
import com.pasantia.dao.DivisionesUbicacionDAO;
import com.pasantia.dao.PaisDAO;
import com.pasantia.dao.impl.DepartamentoDAOImpl;
import com.pasantia.dao.impl.DivisionesUbicacionDAOImpl;
import com.pasantia.dao.impl.PaisDAOImpl;
import com.pasantia.entidades.Departamento;
import com.pasantia.entidades.Divisiones;
import com.pasantia.entidades.DivisionesUbicacion;
import com.pasantia.entidades.Pais;
import com.pasantia.utilidades.Utilidad;
import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.security.auth.message.callback.PrivateKeyCallback;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;

/**
 *
 * @author root
 */
@Named(value = "asignarDepartamentosaDivision")
@ApplicationScoped
public class AsignarDepartamentosaDivision {

    
    //http://www.primefaces.org/showcase/ui/stack.jsf    
    
    private Dialog dlgasignar;
    private List<Departamento> departamentos,departamentosSeleccionados;
    private DepartamentoDAO departamentoDAO;
    private List<DivisionesUbicacion> divisionesUbicacion,divisionesUbicacionlistcomprobar,divisionesUbicacionValidar,divisionesUbicacionCargar;
    private DivisionesUbicacionDAO divisionesUbicacionDAO;
    private ModeloDatosDepartamento modeloDatosDepartamento;
    private List<Pais> paises;
    private PaisDAO paisDAO;
    private List<SelectItem> paisescombo;
    private Pais pais;
    private Divisiones division;
    private DivisionesUbicacion divisionubicacion;
    private DataTable tblDepartamentos;
    private Integer width,height;
    private SelectOneMenu sompaises;
    private OutputLabel lblpais;
    private CommandButton btnguardarAsig;
    
    public void cargarAsignacion(Divisiones d){
        System.out.println("la division seleccionada es-->" + d.getNombreDivision());
        departamentos = departamentoDAO.buscarDepartamentoporIdPais(51);
         modeloDatosDepartamento = new ModeloDatosDepartamento(departamentos);
        if (d != null) {
            division = d;
            divisionesUbicacionValidar = divisionesUbicacionDAO.buscarubicacionesxiddivision(division.getIdDivisiones());
            if (divisionesUbicacionValidar.isEmpty()) {//Si no tiene departamentos asociados
                width = 620;
                height = 140;
                tblDepartamentos.setStyle("display:none");
                sompaises.setStyle("display:block");
                lblpais.setStyle("display:block");
                btnguardarAsig.setStyle("display:none");
                System.out.println("*****LISTA VACIA CAMBIANDO PROPIEDADES");
            } else {//Si tiene departamentos asociados
                cargarPropiedadesConAsociaciones();
            }
            dlgasignar.setVisible(true);
        } else {
            Utilidad.mensajeFatal("Selección Divisiones", "...ERROR...Al seleccionar la división.");
        }
        
    }    
    
    
    public void cargarPaises(){
        paises = paisDAO.buscartodasPaises();
        paisescombo = new ArrayList<SelectItem>();
        for (int i = 0; i < paises.size(); i++) {
            paisescombo.add(new SelectItem(paises.get(i).getIdPais(), paises.get(i).getNombrePais()));
        }
    }
    
    public void cargarDepartamentosxPais(){        
        departamentos = departamentoDAO.buscarDepartamentoporIdPais(pais.getIdPais());
        eliminarDepartamentosSeleccionados();
        modeloDatosDepartamento = new ModeloDatosDepartamento(departamentos); 
        tblDepartamentos.setStyle("display:block");
        System.out.println("antes width: "+width+" height "+height);
        width=700;
        height=590;
        System.out.println("despues width: "+width+" height "+height);
        btnguardarAsig.setStyle("display:block");
        Utilidad.abrirDialog("dlgasignar");
    }    
  
    
     public Integer totalDepartamentos(){        
        return departamentos.size();
    }
     
     public void cancelarAsignacion(){
         dlgasignar.setVisible(false);
         departamentosSeleccionados = null;
         tblDepartamentos.setStyle("display:none");         
         width = 640;
         height = 180;
         departamentosSeleccionados=null;
         cargarPaises();
         departamentos = departamentoDAO.buscarDepartamentoporIdPais(51);
         modeloDatosDepartamento = new ModeloDatosDepartamento(departamentos);
         
     }
     
     public void guardarAsignacion() {
        System.out.println("La division a la cual se le van asignar es-->" + division.getNombreDivision());
        System.out.println("Guardando asignacion la lista de departamentos seleccionados es la siguiente-->");
        List<Boolean> results = new ArrayList<Boolean>();
        if (division != null && !departamentosSeleccionados.isEmpty()) {
            for (Departamento departamento : departamentosSeleccionados) {
                System.out.println("los departamentos seleccionados son los siguientes-->" + departamento.getNombreDepartamento());
                divisionubicacion.setDivisiones(division);
                divisionubicacion.setDepartamento(departamento);
                System.out.println("la asignacion quedo de la siguiente manera---> departamento -->" + divisionubicacion.getDepartamento().getNombreDepartamento() + " division quedo --> " + divisionubicacion.getDivisiones().getNombreDivision());
                    if (divisionesUbicacionDAO.insertarDivisionesUbicacion(divisionubicacion)) {
                        results.add(Boolean.TRUE);
                    } else {
                        results.add(Boolean.FALSE);
                        Utilidad.mensajeFatal("Guardar Asignaciones.", "Ocurrio un error al ejecutar la operación no se pudo asignar ubicaciones a: " + divisionubicacion.getDivisiones().getNombreDivision());
                    }
                    
            }
        } else {
            Utilidad.mensajeFatal("Guardar Asignaciones.", "Ocurrio un error al ejecutar la operación.");
        }
        Integer tam = results.size();
        Integer cont = 0;
        for (Boolean boolean1 : results) {
            if (boolean1) {
                cont++;
            }
        }

        if (cont == tam) {
            Utilidad.mensajeInfo("Guardar Asignaciones.", "Asignaciones a la división " + division.getNombreDivision() + ". Guardadas Correctamente.");            
            cargarDepartamentosxPais();            
        }else{
            Utilidad.mensajeFatal("Guardar Asignaciones.", "Ocurrio un error al ejecutar la operación no se pudo asignar ubicaciones a: " + divisionubicacion.getDivisiones().getNombreDivision());
        }
    }
     
     public void eliminarDepartamentosSeleccionados(){
        for (int i = 0; i < departamentos.size(); i++) {
            int sec = departamentos.get(i).getIdDepartamento();
            System.out.println("los departamentos son los siguientes-->"+departamentos.get(i).getNombreDepartamento());
            divisionesUbicacionlistcomprobar = divisionesUbicacionDAO.buscarubicacionesxidDepartamento(sec);
            System.out.println("la list sale con el siguiente tamaño "+divisionesUbicacionlistcomprobar.size());
            if (!divisionesUbicacionlistcomprobar.isEmpty()) {
                System.out.println("removi el elemento "+departamentos.get(i).getNombreDepartamento());
                departamentos.remove(i);
            }
        }
    }
     
     public void cargarPropiedadesConAsociaciones(){
         
         width = 620;
         height = 600;
         tblDepartamentos.setStyle("display:block");
         sompaises.setStyle("display:none");
         lblpais.setStyle("display:none");
         btnguardarAsig.setStyle("display:block");
         System.out.println("*****LISTA LLENA CAMBIANDO PROPIEDADES");
         if (division.getIdDivisiones() != 0 && division.getIdDivisiones() != 0) {
             //divisionesUbicacionCargar = divisionesUbicacionDAO.buscarubicacionesxiddivision(division.getIdDivisiones());
             departamentosSeleccionados = divisionesUbicacionDAO.buscarUbicacionesxIdDivision(division.getIdDivisiones());

             System.out.println("Iniciando a recorrer lista");
             for (Departamento departamento : departamentosSeleccionados) {
                 System.out.println("La lista de departamentos seleccionados para: " + division.getNombreDivision() + " son: " + departamento.getNombreDepartamento());
             }
         } else {
             Utilidad.mensajeFatal("Carga de Departamentos.", "...ERROR...Al cargar los departamentos seleccionados para la división escojida.");
         }
         System.out.println("el pais de los departamentos es: "+departamentosSeleccionados.get(0).getPais().getIdPais());
         departamentos = departamentoDAO.buscarDepartamentoporIdPais(departamentosSeleccionados.get(0).getPais().getIdPais());
         modeloDatosDepartamento = new ModeloDatosDepartamento(departamentos);
         
         
         
     }
      
    public AsignarDepartamentosaDivision() {
        dlgasignar = new Dialog();
        departamentoDAO = new DepartamentoDAOImpl();
        paisDAO = new PaisDAOImpl();
        divisionesUbicacionDAO = new DivisionesUbicacionDAOImpl();
        pais = new Pais();
        division = new Divisiones();
        divisionubicacion =  new DivisionesUbicacion();
        tblDepartamentos = new DataTable();
        sompaises = new SelectOneMenu();
        lblpais = new OutputLabel();
        btnguardarAsig = new CommandButton();
        departamentosSeleccionados = new ArrayList<Departamento>();
        //Valores por defecto
        sompaises.setStyle("display:block");
        width=620;
        height=140;
        dlgasignar.setVisible(false);
        tblDepartamentos.setStyle("display:none");
        departamentos = departamentoDAO.buscartodosDepartamentos();
        eliminarDepartamentosSeleccionados();
        divisionesUbicacion = divisionesUbicacionDAO.buscarubicaciones();
        modeloDatosDepartamento = new ModeloDatosDepartamento(departamentos);        
        cargarPaises();
        
        
    }   

    public Dialog getDlgasignar() {
        return dlgasignar;
    }

    public void setDlgasignar(Dialog dlgasignar) {
        this.dlgasignar = dlgasignar;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacion() {
        return divisionesUbicacion;
    }

    public void setDivisionesUbicacion(List<DivisionesUbicacion> divisionesUbicacion) {
        this.divisionesUbicacion = divisionesUbicacion;
    }

    public List<Departamento> getDepartamentosSeleccionados() {
        return departamentosSeleccionados;
    }

    public void setDepartamentosSeleccionados(List<Departamento> departamentosSeleccionados) {
        this.departamentosSeleccionados = departamentosSeleccionados;
    }

    public ModeloDatosDepartamento getModeloDatosDepartamento() {
        return modeloDatosDepartamento;
    }

    public void setModeloDatosDepartamento(ModeloDatosDepartamento modeloDatosDepartamento) {
        this.modeloDatosDepartamento = modeloDatosDepartamento;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<SelectItem> getPaisescombo() {
        return paisescombo;
    }

    public void setPaisescombo(List<SelectItem> paisescombo) {
        this.paisescombo = paisescombo;
    }

    public Divisiones getDivision() {
        return division;
    }

    public void setDivision(Divisiones division) {
        this.division = division;
    }

    public DivisionesUbicacion getDivisionubicacion() {
        return divisionubicacion;
    }

    public void setDivisionubicacion(DivisionesUbicacion divisionubicacion) {
        this.divisionubicacion = divisionubicacion;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacionlistcomprobar() {
        return divisionesUbicacionlistcomprobar;
    }

    public void setDivisionesUbicacionlistcomprobar(List<DivisionesUbicacion> divisionesUbicacionlistcomprobar) {
        this.divisionesUbicacionlistcomprobar = divisionesUbicacionlistcomprobar;
    }

    public DataTable getTblDepartamentos() {
        return tblDepartamentos;
    }

    public void setTblDepartamentos(DataTable tblDepartamentos) {
        this.tblDepartamentos = tblDepartamentos;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacionValidar() {
        return divisionesUbicacionValidar;
    }

    public void setDivisionesUbicacionValidar(List<DivisionesUbicacion> divisionesUbicacionValidar) {
        this.divisionesUbicacionValidar = divisionesUbicacionValidar;
    }

    public SelectOneMenu getSompaises() {
        return sompaises;
    }

    public void setSompaises(SelectOneMenu sompaises) {
        this.sompaises = sompaises;
    }

    public OutputLabel getLblpais() {
        return lblpais;
    }

    public void setLblpais(OutputLabel lblpais) {
        this.lblpais = lblpais;
    }

    public CommandButton getBtnguardarAsig() {
        return btnguardarAsig;
    }

    public void setBtnguardarAsig(CommandButton btnguardarAsig) {
        this.btnguardarAsig = btnguardarAsig;
    }

    public List<DivisionesUbicacion> getDivisionesUbicacionCargar() {
        return divisionesUbicacionCargar;
    }

    public void setDivisionesUbicacionCargar(List<DivisionesUbicacion> divisionesUbicacionCargar) {
        this.divisionesUbicacionCargar = divisionesUbicacionCargar;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
