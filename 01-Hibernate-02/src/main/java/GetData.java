import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class GetData {
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Student stu = session.get(Student.class, 101);
		
		System.out.println(stu);
	}

}
