import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Product.class).
				                 addAnnotatedClass(Order.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Product p = session.get(Product.class, 1);
			
			session.delete(p);
			
			//session.createQuery("delete from product where id=6").executeUpdate();
			
			session.getTransaction().commit();					
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}
		
	}
	
}
