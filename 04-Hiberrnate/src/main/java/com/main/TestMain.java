package com.main;


import java.util.Scanner;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;

public class TestMain {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Employee emp = session.get(Employee.class, 101); //1st hit
		System.out.println(emp);
		
		Employee emp2 = session.get(Employee.class, 101); //no hit
		System.out.println(emp2);
		
		Employee emp3 = session.get(Employee.class, 102); //2nd hit
		System.out.println(emp3);
		
		//session.evict(emp);	//its for perticular object only
		Employee emp4 = session.get(Employee.class, 101);	//no hit
		
		//session.clear(); //it clear all session
		Session session2 = factory.openSession();
		Employee emp5 = session2.get(Employee.class, 101);	//3rd hit

	}

}
