/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao.impl;

import com.pasantia.conexion.ConexionHibernate;
import com.pasantia.dao.DivisionesUbicacionDAO;
import com.pasantia.entidades.Departamento;
import com.pasantia.entidades.DivisionesUbicacion;
import com.sun.xml.ws.api.tx.at.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;

/**
 *
 * @author david
 */
public class DivisionesUbicacionDAOImpl implements DivisionesUbicacionDAO{

    @Override
    public boolean insertarDivisionesUbicacion(DivisionesUbicacion divisionesUbicacion) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.save(divisionesUbicacion);
            session.beginTransaction().commit();
            result = true;
        } catch (Exception e) {
            System.err.println("Error en insertar " + e.getMessage());
            session.beginTransaction().rollback();
            result = false;
        } finally {
            System.out.println("cerranndo sesion en insertarDivisionesUbicacion");
            session.close();
        }
        return result;
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
            return false;
        }
        finally{
            System.out.println("cerranndo sesion en eliminarDivisionesUbicacion");
            session.close();
        }
    }

    @Override
    public List<DivisionesUbicacion> buscarubicaciones() {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        return session.createQuery("from DivisionesUbicacion").list();
    }

    @Override    
    public List<DivisionesUbicacion> buscarubicacionesxiddivision(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        List list = new ArrayList();
        List <DivisionesUbicacion> ubicaciones = new ArrayList<DivisionesUbicacion>();
        try{
        
        Query q=session.createQuery("from DivisionesUbicacion as d where d.divisiones.idDivisiones=:id");
        q.setInteger("id", id);
        list=q.list();
        ubicaciones=(List<DivisionesUbicacion>)list;
        
       }catch(Exception e){
           ubicaciones=null;
            System.out.println("Error en buscar "+e.getMessage());
            session.beginTransaction().rollback();
        }
        finally{
            System.out.println("cerrando la sesion en buscarubicacionesxiddivision");
            session.flush();
            session.close();
        }
      
        return ubicaciones;
        
    }

    @Override
    public List<DivisionesUbicacion> buscarubicacionesxidDepartamento(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();        
        Query q=session.createQuery("from DivisionesUbicacion as d where d.departamento.idDepartamento=:id");
        q.setInteger("id", id);
        return q.list();
    }

    @Override
    public DivisionesUbicacion buscarubicacionesxid(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        DivisionesUbicacion divisionUbicacion=null;;
        try{
            Query q=session.createQuery("from DivisionesUbicacion as d where d.idDivisionesUbicacion=:id");
            q.setInteger("id", id);
            divisionUbicacion=(DivisionesUbicacion)q.uniqueResult();
            
        }catch(Exception e){
            System.out.println("Error en buscar x id Ubicacion "+e.getMessage());
            session.beginTransaction().rollback();
            divisionUbicacion= null;
        }
        finally{
            System.out.println("cerrando la sesion en buscarubicacionesxid");
            session.flush();
            session.close();
        }
        return divisionUbicacion;
        
    }

    @Override
    public List<Departamento> buscarUbicacionesxIdDivision(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        List list = new ArrayList();
        List <Departamento> departamentos = new ArrayList<Departamento>();
        try{
        String jpql =
        " SELECT d "
        + " FROM DivisionesUbicacion as du JOIN du.departamento d"
        + " WHERE du.divisiones.idDivisiones=:id";
        Query q=session.createQuery(jpql);
        
        
        q.setInteger("id", id);
        list=q.list();
        departamentos=(List<Departamento>)list;
        
       }catch(Exception e){
           departamentos=null;
            System.out.println("Error en buscar "+e.getMessage());
            session.beginTransaction().rollback();
        }
        finally{
            System.out.println("cerrando la sesion en buscarubicacionesxiddivision retorna departamentos");
            session.flush();
            session.close();
        }       
      
        return departamentos;
    }
    
}
