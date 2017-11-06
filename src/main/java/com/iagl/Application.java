package com.iagl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.iagl.entities.User;
import com.iagl.persistence.HibernateUtil;

@Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//initDatabase();
	}

	private static void initDatabase() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("delete from TodoList");
		session.beginTransaction();
		query.executeUpdate();
		query = session.createQuery("delete from User");
		query.executeUpdate();
		//query = session.createSQLQuery("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='user'");
		//query.executeUpdate();
		//query = session.createSQLQuery("UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='todolist'");
		//query.executeUpdate();
		User admin = new User();
		admin.setLogin("admin");
		admin.setPassword("root");
		admin.setId(1);
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}
}