package com.iagl.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void saveOrInsert(Object entity) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;

    	try {
    	   tx = session.beginTransaction();
    	   session.save(entity);
    	   tx.commit();
    	}

    	catch (Exception e) {
    	   if (tx!=null) tx.rollback();
    	   e.printStackTrace(); 
    	} finally {
    	   session.close();
    	}
    }
    
    public static void delete(Object entity) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;

    	try {
    	   tx = session.beginTransaction();
    	   session.delete(entity);
    	   tx.commit();
    	}

    	catch (Exception e) {
    	   if (tx!=null) tx.rollback();
    	   e.printStackTrace(); 
    	} finally {
    	   session.close();
    	}
    }
    
    public static Object find(Class<?> entityClass, int id) {
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	Object entity = null;
    	try {
    	   tx = session.beginTransaction();
    	   entity = session.get(entityClass, id);
    	   tx.commit();
    	   return entity;
    	}

    	catch (Exception e) {
    	   if (tx!=null) tx.rollback();
    	   e.printStackTrace(); 
    	} finally {
    	   session.close();
    	}
    	return null;
    }

    public static void shutdown() {
    	getSessionFactory().close();
    }
    
//    public static void main(String[] args) {
//    	  System.out.println("Maven + Hibernate + MySQL");
//          Session session = HibernateUtil.getSessionFactory().openSession();
//
//          session.beginTransaction();
//          TodoList todolist = new TodoList();
//          
//          todolist.setName("4715");
//
//          session.save(todolist);
//          session.getTransaction().commit();
//	}

}