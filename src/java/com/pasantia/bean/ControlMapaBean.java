/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author root
 */
@Named(value = "controlMapaBean")
@RequestScoped
public class ControlMapaBean {

    /**
     * Creates a new instance of ControlMapaBean
     */
    
    public void visualizarMapa(){
        System.out.println("visualizando mapa");
    }
    
    public ControlMapaBean() {
        System.out.println("...Inicializando control de mapa...");
    }
}
