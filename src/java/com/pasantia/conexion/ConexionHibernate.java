/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasantia.conexion;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author david
 */
public class ConexionHibernate {

    private static SessionFactory sessionFactory;  
    static {  
        try {  
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
        } catch (Throwable ex) {  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
    public static SessionFactory getSessionFactory() {  
        if (sessionFactory == null) {  
            try {  
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();  
            } catch (Throwable ex) {  
                System.err.println("Initial SessionFactory creation failed." + ex);  
                throw new ExceptionInInitializerError(ex);  
            }  
  
        }  
        return sessionFactory;  
    }  
    public static Session getSession() {  
        return sessionFactory  
                .getCurrentSession();  
    }  
    public static Session openSession() {  
        return sessionFactory  
                .openSession();  
    }  
}
