
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		org.hibernate.Transaction txn = session.beginTransaction();
		
		Student stu = session.get(Student.class, 101);
		session.delete(stu);
		txn.commit();
		System.out.println("Record Deleted....!");
		
	}
}