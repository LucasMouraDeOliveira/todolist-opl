package com.iagl.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.iagl.entities.TodoList;

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

    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
    
    public static void main(String[] args) {
    	  System.out.println("Maven + Hibernate + MySQL");
          Session session = HibernateUtil.getSessionFactory().openSession();

          session.beginTransaction();
          TodoList todolist = new TodoList();
          
          todolist.setName("4715");

          session.save(todolist);
          session.getTransaction().commit();
	}

}