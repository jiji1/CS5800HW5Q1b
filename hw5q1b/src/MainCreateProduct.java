import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
	
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
			
			Product p1 = new Product("ppp");						
			
			Order o1 = new Order(formatter.parse("03/03/1933"), "o1");
			Order o2 = new Order(formatter.parse("04/04/1944"), "o2");
			
			System.out.println(p1.toString());
			session.save(p1);		
			
			System.out.println(o1.toString());
			System.out.println(o2.toString());
			
			p1.addOrders(o1);
			p1.addOrders(o2);
			
			session.save(o1);	
			session.save(o2);	
			
			//session.save(p1);			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			factory.close();
		}		
		
		
	}

}
