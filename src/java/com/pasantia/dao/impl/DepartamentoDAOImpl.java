/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.dao.impl;

import com.pasantia.conexion.ConexionHibernate;
import com.pasantia.dao.DepartamentoDAO;
import com.pasantia.entidades.Departamento;
import com.pasantia.entidades.Pais;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author root
 */
public class DepartamentoDAOImpl implements DepartamentoDAO{

    private EntityManager entityManager;
    
    @Override
    public List<Departamento> buscartodosDepartamentos() {
        Session session = ConexionHibernate.getSessionFactory().openSession();        
        return session.createQuery("from Departamento").list();
    }

    @Override
    public List<Departamento> buscarDepartamentoporId(Integer id) {
        Session session = ConexionHibernate.getSessionFactory().openSession();
        
        Query q=session.createQuery("from Departamento as d where d.pais.idPais= :pais");
        q.setInteger("pais", id);
        return q.list();
    }

    @Override
    public Departamento buscarDepartamentoporIdUno(Integer id) {
        
        Session session = ConexionHibernate.getSessionFactory().openSession();
        
        Query q=session.createQuery("from Departamento as d where d.idDepartamento= :id");
        q.setInteger("id", id);
        return (Departamento)(q.uniqueResult());
    }
    
}
