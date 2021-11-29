import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateOrder {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				                 configure("hibernate.cfg.xml").
				                 addAnnotatedClass(Order.class).
				                 addAnnotatedClass(Product.class).
				                 buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			session.beginTransaction();
			
			//Product p = session.get(Product.class, 1);
			
			Order o1 = new Order(formatter.parse("12/12/1980"), "zik");
			//Order o2 = new Order(formatter.parse("01/01/1912"), "kee");			
			
			System.out.println(o1.toString());
			session.save(o1);	
			
			Product p1 = new Product("yy");
			Product p2 = new Product("qq");
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			
			o1.addProducts(p1);
			o1.addProducts(p2);
			
			//session.save(o1);					
			session.save(p1);
			session.save(p2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
		
	}

}
