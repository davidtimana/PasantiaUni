/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao.impl;

import com.pasantia.conexion.ConexionHibernate;
import com.pasantia.dao.DivisionesDAO;
import com.pasantia.entidades.Divisiones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class DivisionesDAOImpl implements DivisionesDAO{

    @Override
    public void insertarDivisiones(Divisiones divisiones) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        String descripcion="";
        try{            
            session.beginTransaction();
            descripcion=divisiones.getNombreDivision();
            descripcion=descripcion.toUpperCase();
            descripcion=descripcion.trim();
            divisiones.setNombreDivision(descripcion);
            session.save(divisiones);
            session.beginTransaction().commit();
            }catch(Exception e){
            System.out.println("Error en insertar "+e.getMessage());
            session.beginTransaction().rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void actualizarDivisiones(Divisiones divisiones) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        String descripcion="";
        try{
            session.beginTransaction();
            descripcion=divisiones.getNombreDivision();
            descripcion=descripcion.toUpperCase();
            descripcion=descripcion.trim();
            divisiones.setNombreDivision(descripcion);
            session.update(divisiones);
            session.beginTransaction().commit();            
        }catch(Exception e){
            System.out.println("Error en actualizar "+e.getMessage());
            session.beginTransaction().rollback();
        }
        finally{
            session.close();
        }
    }

    @Override
    public boolean eliminarDivisiones(Divisiones divisiones) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.delete(divisiones);
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
    public Divisiones buscarDivisionesporId(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        Divisiones divisiones=null;
        try{
            divisiones=(Divisiones)session.load(Divisiones.class,id);
            
        }catch(Exception e){
            System.out.println("Error al buscar el id: "+id+" :"+e.getMessage());
        }
        finally{
            session.close();
        }
        return divisiones;
    }

    @Override
    public List<Divisiones> buscartodasDivisiones() {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        return session.createQuery("from Divisiones").list();
    }

    @Override
    public Divisiones buscarDivisionesporNombre(String nombre) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        
        Query q=session.createQuery("from Divisiones as d where d.nombreDivision= :nombre");
        q.setString("nombre", nombre);
        
        return (Divisiones)(q.uniqueResult());
    }
    
}
