import java.util.ArrayList;
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
//@Table(name="product", schema="public")
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;	
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="order_detail",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="order_id")
			)
	private List<Order> orders;
	
	public Product() {

	}
	
	public Product(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrder() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrders(Order theOrder) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
		orders.add(theOrder);
	}	
	
	@Override
	public String toString() {
		return "instructor [id=" + id + ", name=" + name + "]";
	}
	
}
