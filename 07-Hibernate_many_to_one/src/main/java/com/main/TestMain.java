package com.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Department;
import com.model.Employee;

public class TestMain {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Employee e1 = new Employee(111, "manish", 198989898);
		Employee e2 = new Employee(112, "parth", 298989898);
		Employee e3 = new Employee(113, "pavan", 38989898);
		Employee e4 = new Employee(114, "ujval", 498989898);
		Employee e5 = new Employee(115, "sita", 598989898);
		
		Set<Employee> set1= new HashSet<Employee>();
		set1.add(e1);
		set1.add(e2);
		set1.add(e3);
		
		Department d1 = new Department ();
		d1.setDid(1111);
		d1.setDname("IT");
		d1.seteSet(set1);
		
		Set<Employee> set2= new HashSet<Employee>();
		set2.add(e4);
		set2.add(e5);
		
		Department d2 = new Department();
		d2.setDid(2222);
		d2.setDname("COMP");
		d2.seteSet(set2);
		
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d1);
		
		e4.setDept(d2);
		e5.setDept(d2);
		
		session.save(d1);
		session.save(d2);
		
		txn.commit();
		System.out.println("Record Saved....!");	
	}
}
