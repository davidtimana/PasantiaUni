/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao.impl;

import com.pasantia.conexion.ConexionHibernate;
import com.pasantia.dao.DivisionesUbicacionDAO;
import com.pasantia.entidades.DivisionesUbicacion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author david
 */
public class DivisionesUbicacionDAOImpl implements DivisionesUbicacionDAO{

    @Override
    public void insertarDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion) {
        Session session = ConexionHibernate.getSessionFactory().openSession();        
        try{            
            session.beginTransaction();            
            session.save(divisionesUbicacion);
            session.beginTransaction().commit();
            }catch(Exception e){
            System.out.println("Error en insertar "+e.getMessage());
            session.beginTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public boolean eliminarDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(divisionesUbicacion);
            session.beginTransaction().commit();
            return true;
        }catch(Exception e){
            System.out.println("Error al eliminar "+e.getMessage());
            session.beginTransaction().rollback();
            return true;
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<DivisionesUbicacion> buscarubicacionesxiddivision() {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        return session.createQuery("from DivisionesUbicacion").list();
    }
    
}
