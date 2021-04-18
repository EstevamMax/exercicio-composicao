package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Formatando a forma desejada na instanciação e exibição de datas
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private String email;
	private Date birthDate;
	
	private Order order; //Instanciando um pedido ao cliente
	
	public Client() {
		
	}
	
	public Client(String name, String email, Date birthDate, Order order) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String toString() { //ToString de exibição usando "StringBuilder" junto de "append"
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(order.getMoment()) + "\n");
		sb.append("Order status: ");
		sb.append(order.getStatus() + "\n");
		sb.append("Client: ");
		sb.append(name + " (" + sdf2.format(birthDate) + ") - " + email);
		
		return sb.toString();
	}
	
}
