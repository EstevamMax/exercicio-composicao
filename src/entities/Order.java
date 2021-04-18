package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	List<OrderItem> OrderItems = new ArrayList<>(); //Instanciando uma lista de pedidos na compra
	
	public Order() {
		
	}
	
	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderItems() {
		return OrderItems;
	}
	
	public void addItem(OrderItem item) {
		OrderItems.add(item);
	}
	
	public void removeItem(OrderItem item) {
		OrderItems.remove(item);
	}
	
	public Double total() {
		Double sum = 0.0;
		for(OrderItem i : OrderItems) { //Para cada OrderItem 'i' da lista "OrderItems" fazer:
			sum += i.subTotal();
		}
		return sum;
	}
	
	public String toString() { //ToString de exibição usando "StringBuilder" junto de "append"
		StringBuilder sb = new StringBuilder();
		for (OrderItem i : OrderItems) {
			sb.append(i.getProduct().getName() + ", $");
			sb.append(i.getPrice() + ", Quantity: ");
			sb.append(i.getQuantity() + ", Subtotal: $");
			sb.append(i.subTotal() + "\n");
		}
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();
	}
	
}
