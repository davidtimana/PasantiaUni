/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import com.pasantia.dao.CargoDAO;
import com.pasantia.dao.CategoriaDAO;
import com.pasantia.dao.impl.CargoDAOImpl;
import com.pasantia.dao.impl.CategoriaDAOImpl;
import com.pasantia.entidades.Cargo;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author root
 */
@Named(value = "cargoBean")
@RequestScoped
public class CargoBean {

    private Cargo cargo;
    private List<Cargo> cargos;
    private Integer id;
    private String descripcion;
    private Dialog dlgNuevaCategoria,dlgeditarcategoria,dlgeliminarcomfirmar;
    private InputText txtdescripcioning,txtdescripcioneditar,txtideditar,txtideliminar;
    
    public CargoBean() {
        cargo = new Cargo();
        dlgNuevaCategoria = new Dialog();
        txtdescripcioning = new InputText();
        dlgeditarcategoria = new Dialog(); 
        txtdescripcioneditar = new InputText();
        txtideditar = new InputText();
        dlgeliminarcomfirmar = new Dialog();
        txtideliminar = new InputText();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Dialog getDlgNuevaCategoria() {
        return dlgNuevaCategoria;
    }

    public void setDlgNuevaCategoria(Dialog dlgNuevaCategoria) {
        this.dlgNuevaCategoria = dlgNuevaCategoria;
    }

    public Dialog getDlgeditarcategoria() {
        return dlgeditarcategoria;
    }

    public void setDlgeditarcategoria(Dialog dlgeditarcategoria) {
        this.dlgeditarcategoria = dlgeditarcategoria;
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
        cargo=new Cargo();
        dlgNuevaCategoria.setVisible(Boolean.TRUE);
        
    }
    public void guardarNuevaCategoria(){
        System.out.println("Guardando el cargo con descripcion  -->>>"+this.descripcion);
        Cargo c= new Cargo();
        c.setDescripcion(this.descripcion);        
         
          if (c.getDescripcion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Al Guardar El Cargo Del Usuario"
                    , "Descripcion Del Cargo Requerida"));
            dlgNuevaCategoria.setVisible(Boolean.TRUE);
            
            
          }else{
              System.out.println("--------------------------- "+c.getDescripcion());
              
              CargoDAO cargoDAO = new CargoDAOImpl();
              cargoDAO.insertarCargo(c);
              FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Cargo Guardado Exitosamente"));
              dlgNuevaCategoria.setVisible(Boolean.TRUE);
              this.descripcion=null;
          }        
        cargo=new Cargo();
    }
    public void prepararActualizadoDeCategoria(Integer Id,String descripcion){
        dlgeditarcategoria.setVisible(Boolean.TRUE);
        System.out.println("Preparando para actualizar un cargo con id:"+Id);
        CargoDAO cargoDAO=new CargoDAOImpl();
        cargo=cargoDAO.buscarCargoporId(Id);
        
        txtideditar.setValue(Id);
        txtideditar.setReadonly(true);
        this.setDescripcion(descripcion);
        this.setId(Id);
        txtdescripcioneditar.setValue(descripcion);
    }
    public void actualizarCargo(){
        System.out.println("Actualizando cargo con descripcion: "+this.descripcion);
        Cargo c = new Cargo();
        c.setDescripcion(this.descripcion);
        c.setIdCargo(this.id);
        if (c.getDescripcion().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error En La Actualizacion Del Cargo Del Usuario"
                    , "Descripcion Del Cargo Requerido"));
            dlgeditarcategoria.setVisible(Boolean.FALSE);
          }else{
            CargoDAO cargoDAO=new CargoDAOImpl();
            System.out.println("---------------------------"+c.getDescripcion());
            System.out.println("---------------------------"+c.getIdCargo());
            cargoDAO.actualizarCargo(c);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Cargo Actualizado Exitosamente"));
            dlgeditarcategoria.setVisible(Boolean.TRUE);
        }
        cargo=new Cargo();
    }
    public void prepararEliminarCargo(Integer Id,String descripcion){
        System.out.println("Preparando para eliminar un cargo con id:"+Id);
        dlgeliminarcomfirmar.setVisible(true);
        dlgeliminarcomfirmar.setHeader("¿Desea Eliminar el cargo con Descripcion: " +descripcion +"?");
        txtideliminar.setValue(Id);
        txtideliminar.setReadonly(Boolean.TRUE);
        CargoDAO cargoDAO=new CargoDAOImpl();
        cargo=cargoDAO.buscarCargoporId(Id);
       this.setId(Id);
       this.setDescripcion(descripcion);
    }
    public void eliminarCategoria(){
        Cargo c = new Cargo();
        CargoDAO cargoDAO=new CargoDAOImpl();
        System.out.println("Eliminando cargo con id"+txtideliminar.getValue());
        c=cargoDAO.buscarCargoporId((Integer)(txtideliminar.getValue()));
        
        
        boolean resultado=cargoDAO.eliminarCargo(c);
        if(resultado){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Cargo Eliminada Exitosamente"));
            dlgeliminarcomfirmar.setVisible(Boolean.FALSE);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al eliminar"
                    , "Cargo: "+c.getDescripcion()+". no eliminado."));
            dlgeliminarcomfirmar.setVisible(Boolean.FALSE);
        }
        
        
        cargo=new Cargo();
    }
    public int totalCargo(){
        int total=cargos.size();
        return total;
    }
    
    
}
