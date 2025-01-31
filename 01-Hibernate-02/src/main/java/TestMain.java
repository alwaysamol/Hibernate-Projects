
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMain {
	public static void main(String[] args) {
	
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Student stu = new Student();
		stu.setRno(112);
		stu.setName("ram");
		stu.setMarks(44);
		
		session.save(stu);
		txn.commit();
		System.out.println("Record Inserted....!");
	}

}
