/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.bean.configpuntoventa.divisiones;

import com.pasantia.dao.DivisionesDAO;
import com.pasantia.dao.impl.*;
import com.pasantia.entidades.*;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author David Timana
 */
@Named(value = "divisionesBean")
@RequestScoped
public class DivisionesBean {
                         //******************************Inicio divisionBean*********************************************   
    private DivisionesDAO divisionesDAO;
    
    //*******************Inicio Declaracion de Atributos***********************************    
    private List<Divisiones> divisioneslista;       
    //*******************FIn Declaracion de Atributos***********************************
    
    
    //*************************Inicio Declaracion De Metodos de divisionBean*********************************************  
    public int totalDivisiones(){
        int total=divisioneslista.size();
        return total;
    }        
    //*************************Fin Declaracion De Metodos de divisionBean********************************************* 
    
    
    //********************************************Constructor por Defecto**************************************************************
    
    public DivisionesBean() {        
       divisionesDAO = new DivisionesDAOImpl();
       divisioneslista = divisionesDAO.buscartodasDivisiones();
       
    }    
    
    //***********************Getters and Setters************************************************* 

    public List<Divisiones> getDivisioneslista() {       
        return divisioneslista;
    }

    public void setDivisioneslista(List<Divisiones> divisioneslista) {
        this.divisioneslista = divisioneslista;
    }    

  }     
//******************************Fin divisionBean*********************************************
