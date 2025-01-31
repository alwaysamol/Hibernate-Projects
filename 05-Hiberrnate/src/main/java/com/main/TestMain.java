package com.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.config.HibernateUtil;
import com.model.Employee;
import com.model.Laptop;

public class TestMain {

	public static void main(String[] args) {
		SessionFactory factory =HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction txn = session.beginTransaction();
		
		Employee e1 = new Employee();
		e1.setEid(132);
		e1.setEname("rajuu");
		e1.setMno(54549804);
		
		Laptop l1 = new Laptop();
		l1.setLid(1771);
		l1.setLname("NEON");
		l1.setPrice(80098);
		
		e1.setLap(l1);
		l1.setEmp(e1);
		
		session.save(e1);
		session.save(l1);
		txn.commit();
		System.out.println("Record Saved...!");
	
	}
}
