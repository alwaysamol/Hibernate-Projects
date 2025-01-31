package com.config;


import java.util.Properties;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.model.Employee;
import com.model.Laptop;


import org.hibernate.SessionFactory; 

public class HibernateUtil
{
	public static SessionFactory factory;

	public static SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			Configuration cfg = new Configuration();
			
			Properties properties = new Properties();
			
			/* Database Properties */
			properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost:3306/anmol");
			properties.put(Environment.USER,"root");
			properties.put(Environment.PASS,"amol5941");
			
			/* Hibernate Properties */
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
			properties.put(Environment.HBM2DDL_AUTO,"update");
			properties.put(Environment.SHOW_SQL, true);
			
			cfg.setProperties(properties);
			cfg.addAnnotatedClass(Employee.class);
			cfg.addAnnotatedClass(Laptop.class);
			
			ServiceRegistry registry =  new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			factory =  cfg.buildSessionFactory(registry);
		}
		return factory;
	}
}