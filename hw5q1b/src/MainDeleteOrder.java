import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Order.class).
				                 addAnnotatedClass(Product.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Order o = session.get(Order.class, 1);
			
			session.delete(o);
			
			//session.createQuery("delete from order where id=6").executeUpdate();
			
			session.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
		
	}
	
}
