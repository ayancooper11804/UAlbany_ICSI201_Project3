/*
 * ICSI 201 Project 3: Pizza Shop
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program provides several menus for a user to order a custom pizza, a pizza from the specials menu, display their receipt, and then 
 * quit the program once their done. The program will then quit once the user chooses to quit the program.
 * 
 * The Pizza class acts as the general pizza that will be created in the user's order. The methods in this class will display the ordered 
 * pizza's size, toppings, and the price of the pizza.
 */

import java.util.ArrayList; // Imports the Java ArrayList library

public class Pizza { // Pizza class, used to display the size, toppings, and price of the ordered pizza.
	public Size size; // Enumeration of pizza sizes from the Size file.
	public Toppings[] toppings = new Toppings[4]; // An array of toppings from the Toppings file. This is used to account for the 4 
												  // toppings the user may add to their pizza.
	public static int pizzaPrice = 0; // The price of the pizza, which can be changed depending on the various pizzas that can be created.
	private static final double taxRate = 0.08; // A constant variable for the tax which itself shall never change.
	
	/**
	 * Constructor method for the Pizza class.
	 * @param size: The size of the ordered pizza.
	 */
	public Pizza(Size size) {
		setSize(size); // Calls the setSize method in this class to set the size of the pizza ordered.
	}
	
	/**
	 * The getSize method gets the size of the ordered pizza.
	 * @return Returns the size of the ordered pizza.
	 */
	public Size getSize() {
		return size; // Returns the size of the pizza.
	}
	 /**
	  * The setSize method sets the size of the ordered pizza.
	  * @param size: The size of the ordered pizza.
	  */
	public void setSize(Size size) {
		this.size = size; // Sets the size of the pizza.
	}
	
	/**
	 * The addTopping method is used to add all of the toppings the user wishes to order on their pizza.
	 * @param Topping: The topping to be added.
	 */
	public void addTopping(Toppings Topping) {
		for (int i = 0; i < toppings.length; i++) { // For loop used to add toppings to the ordered pizza.
			if (Topping.ordinal() == i) { // Checks the position of the requested topping the user chooses from the enumeration.
				
				/*
				 * Adds topping if it has not been added to the ordered pizza.
				 */
				if (toppings[i] == null) {
					toppings[i] = Topping;
				}
				/*
				 * Error message displayed if the user tries to add a duplicate of a topping to their pizza.
				 */
				else {
					System.out.println("This topping has already been added. Please select another topping.");
				}
			}
		}
	}
	
	/**
	 * The getPrice method gets the price of ordered pizza.
	 * @return: Returns the price of the ordered pizza.
	 */
	public int getPrice() {
		pizzaPrice = 0; // The price of the pizza, which can be changed depending on the various pizzas that can be created.
		
		/*
		 * This set of if-else-if statements sets the size of a small, medium, and large pizza to $10, $15, and $20 respectively.
		 */
		if (size == Size.SMALL) {
			pizzaPrice += 10;
		}
		else if (size == Size.MEDIUM) {
			pizzaPrice += 15;
		}
		else if (size == Size.LARGE) {
			pizzaPrice += 20;
		}
		
		int toppingCount = 0; // Int variable used to count the amount of toppings added to the pizza. One topping = $1. 
		for(int i = 0; i < toppings.length; i++) { // For loop used to add the amount of toppings on the ordered pizza.
			if(toppings[i] != null) { // Adds total amount of toppings if any toppings have been added. Otherwise, the amount will be 0.
				toppingCount++; // Adds up the amount of toppings.
			}
		}
		
		pizzaPrice += toppingCount; // Adds amount of toppings to the price of the pizza.
		return pizzaPrice; // The total price of the pizza.
	}
	
	/**
	 * The getTax method is made to be used in the PizzaOrder class. Here, it simply returns the tax rate of $0.08.
	 * @return
	 */
	public static double getTax() {
		return taxRate; // Returns the tax rate of $0.08.
	}
	
	/**
	 * The display method displays the information of the ordered pizza.
	 */
	public void display() {
		System.out.println("Size: " + size); // Displays the size of the ordered pizza.	
		
		/*
		 * This block of code displays the toppings added on the pizza.
		 */
		System.out.println("TOPPING:");
		for (int i = 0; i < toppings.length; i++) { // For loop used to display all toppings added on the ordered pizza.
			
			/*
			 * If there are toppins, they will be displayed.
			 */
			if(toppings[i] != null ) { 
				System.out.println(" " + toppings[i]);
			}
		}
		
		System.out.println("Item Price: $" + getPrice()); //Displays the total price of the ordered pizza.
	}
}
