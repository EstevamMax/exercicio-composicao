package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Formatando a forma desejada na instanciação e exibição de datas
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		sc.nextLine();
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderData = sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(orderData)); //Instanciando um novo pedido 
		Client client = new Client(clientName, email, birthDate, order); //Instanciando um novo cliente
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) { //For para registrar os 'n' itens desejados
			sc.nextLine();
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double prodPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity, prodPrice, new Product(prodName, prodPrice)));
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(client.toString());
		System.out.println();
		System.out.println("ORDER ITEMS");
		System.out.println(order.toString());
		
		
		
		sc.close();
		
	}

}
