package com.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.User;

public class TestMain {
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Scanner s = new Scanner(System.in);
		
		//getRecordBySQL(session);
		
		getDataByHQL(session);
		
		//deleteRecordById(session,s);
		
		//updateRecord(session, s);
		
	}

	private static void updateRecord(Session session, Scanner s) {
		Transaction txn = session.beginTransaction();
		
		String hql = "update User set uname=:uname, mno=:mno where uid=:uid";
		Query query = session.createQuery(hql);
		
		System.out.println("Enter uid to update Record:");
		query.setParameter("uid", s.nextInt());
		
		System.out.println("Enter New Name:");
		query.setParameter("uname", s.next());
		
		System.out.println("Enter New Mobile Number:");
		query.setParameter("mno", s.nextLong());
		
		query.executeUpdate();
		txn.commit();
		System.err.println("Record Update..!");	
	}
	
	private static void deleteRecordById(Session session, Scanner s) {
		Transaction txn = session.beginTransaction();
		String hql = "delete from User where uid=:uid";
		Query query = session.createQuery(hql);
		query.setParameter("uid", s.nextInt());
		query.executeUpdate();
		txn.commit();
		System.out.println("Record Deleted Successfully...!");
	}
	
	private static void getDataByHQL(Session session) {
		String hql = "from User";
		
		Query query = session.createQuery(hql);
		List<User> uList = query.getResultList();
		System.out.println(uList);
	}
	
//	private static void getRecordBySQL (Session session) {
//		String sql = "select * from user_data";
//		
//		Query query = session.createSQLQuery(sql).addEntity(User.class);
//		List<User> uList= query.getResultList();
//		System.out.println(uList);
//	}
}
