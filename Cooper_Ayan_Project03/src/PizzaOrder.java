/*
 * ICSI 201 Project 3: Pizza Shop
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program provides several menus for a user to order a custom pizza, a pizza from the specials menu, display their receipt, and then 
 * quit the program once their done. The program will then quit once the user chooses to quit the program.
 * 
 * The PizzaOrder class stores and displays all of the pizzas ordered by the user in their receipt. Included in the receipt is the 
 * subtotal, the tax from the total order, and the final price of the order.
 */

import java.util.ArrayList; // Imports the Java ArrayList library

public class PizzaOrder { // PizzaOrder class, which calls various methods from the Pizza class to display the enire order in a receipt.
	public ArrayList<Pizza> pizza = new ArrayList<Pizza>(); // ArrayList to store all the pizzas ordered by the user.
	
	/**
	 * The addPizza method adds one additional pizza into the ArrayList.
	 * @param Pizza: A pizza to be added, which is ordered by the user.
	 */
	public void addPizza(Pizza Pizza) {
		pizza.add(Pizza); // Adds a pizza to the ArrayList
	}
	
	/**
	 * The getPrice method gets the subtotal of the order.
	 * @return Returns the added price of all pizzas the user ordered (not including taxes).
	 */
	public int getPrice() {
		int totalPrice = 0; // Int variable used to display the subtotal of the order.
		
		for (int i = 0; i < pizza.size(); i++) { // For loop used to add all pizza prices in the order for the subtotal.
			totalPrice += pizza.get(i).getPrice(); // Adds all pizza prices for the subtotal.
		}
		return totalPrice; // Returns the subtotal.
	}
	 
	/**
	 * The display method displays the entire receipt of the user's order. Along with each pizza ordered, the subtotal, tax amount, and 
	 * total of the order is included.
	 */
	public void display() {
		
		/*
		 * Tax value of the order, gained by multiplying the tax rate of $0.08 to the subtotal.
		 */
		double tax = 0;
		tax = Pizza.getTax() * getPrice();
		
		/*
		 * Information displayed in the receipt.
		 */
		System.out.println("------------------------");
		System.out.println("   ORDER RECEIPT");
		System.out.println("------------------------");
		
		for (int i = 0; i < pizza.size(); i++) { // For loop used to display all pizzas in the order.
			pizza.get(i).display(); // Calls from the Pizza class's display method to display all pizzas in the order.
			System.out.println("------------------------");
		}
		
		System.out.println("SUBTOTAL: $" + getPrice()); // Displays the subtotal of the order.
		System.out.printf("TAX $%.2f\n", tax); // Displays the tax of the order.
		System.out.printf("TOTAL: $%.2f\n", (getPrice() + tax)); // Displays the total of the order.
		
	}
}
