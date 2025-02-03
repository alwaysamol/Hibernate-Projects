package com.main;

import java.util.HashSet;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Customer;
import com.model.Product;

public class TestMain {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Product p1 = new Product(131, "TVVV", "BBBlack");
		Product p2 = new Product(132, "LLaptop", "BBlack");
		Product p3 = new Product(133, "RRing", "BBlack");
		Product p4 = new Product(134, "CChair", "BBlack");
		Product p5 = new Product(135, "MMonitor", "BBlack");
		
		Set<Product> pset1= new HashSet<Product>();
		pset1.add(p1);
		pset1.add(p2);
		pset1.add(p3);
		pset1.add(p4);
		pset1.add(p5);
		
		Set<Product> pset2= new HashSet<Product>();
		pset2.add(p1);
		pset2.add(p2);
		pset2.add(p3);
		pset2.add(p4);
		pset1.add(p5);
		
		Customer c1 = new Customer(3, "AAkash", "75645454", pset1);
		
		Customer c2 = new Customer(4, "Raj", "144636565", pset2);
		
		Set<Customer> cset= new HashSet<Customer>();
		cset.add(c1);
		cset.add(c2);
		
		p1.setcSet(cset);
		p2.setcSet(cset);
		p3.setcSet(cset);
		p4.setcSet(cset);
		p5.setcSet(cset);
		
		session.save(c1);
		session.save(c2);
		
		txn.commit();
		System.out.println("Record Saved....");
		
		
		
		
	}

}
