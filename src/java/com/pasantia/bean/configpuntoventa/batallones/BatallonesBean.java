/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.batallones;

import com.pasantia.dao.BatallonDAO;
import com.pasantia.dao.impl.BatallonDAOImpl;
import com.pasantia.entidades.Batallon;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author root
 */
@Named(value = "batallonesBean")
@ApplicationScoped
public class BatallonesBean {

    private List<Batallon> batallones;
    private BatallonDAO batallonDAO;
    private ModeloBatallon modeloBatallon;
    private Batallon batallonSeleccionado;
    private Boolean visualizarFila;
    
    public void cargarFilaSelecionada(){
        visualizarFila=true;
        System.out.println("la fila seleccionada es la siguiente---> "+batallonSeleccionado.getNombreBatallon()+batallonSeleccionado.getDireccion());
    }
    
    public BatallonesBean() {
        batallonDAO = new BatallonDAOImpl(); 
        batallonSeleccionado = new Batallon();
        cargarBatallones();
        modeloBatallon = new ModeloBatallon(batallones);
        visualizarFila=false;
    }
    
    public Integer totalBatallones(){
        return batallones.size();
    }
    
    public void cargarBatallones(){
        batallones = batallonDAO.buscartodosBatallones();
    }

    public List<Batallon> getBatallones() {
        return batallones;
    }

    public void setBatallones(List<Batallon> batallones) {
        this.batallones = batallones;
    }

    public ModeloBatallon getModeloBatallon() {
        return modeloBatallon;
    }

    public void setModeloBatallon(ModeloBatallon modeloBatallon) {
        this.modeloBatallon = modeloBatallon;
    }

    public Batallon getBatallonSeleccionado() {
        return batallonSeleccionado;
    }

    public void setBatallonSeleccionado(Batallon batallonSeleccionado) {
        this.batallonSeleccionado = batallonSeleccionado;
    }

    public Boolean getVisualizarFila() {
        return visualizarFila;
    }

    public void setVisualizarFila(Boolean visualizarFila) {
        this.visualizarFila = visualizarFila;
    }
    
    
    
    
    
    
    
    
    
    
}
