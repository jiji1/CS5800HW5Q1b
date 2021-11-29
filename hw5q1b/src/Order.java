import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
//@Table(name="orderr", schema="public")
@Table(name="orderr")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="order_detail",
			joinColumns=@JoinColumn(name="order_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)
	private List<Product> products;	
	
	public Order() {
		
	}
	
	public Order(Date date, String customer_name) {
		this.date = date;
		this.customer_name = customer_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public List<Product> getProduct() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProducts(Product theProduct) {
		
		if (products == null) {
			products = new ArrayList<>();
		}
		
		products.add(theProduct);
	}	

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		return "Customer [id=" + id + ", date=" + formatter.format(date) + ", customer_name=" + customer_name + "]";
	}
	
}
