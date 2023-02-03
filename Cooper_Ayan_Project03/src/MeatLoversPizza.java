/*
 * ICSI 201 Project 3: Pizza Shop
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program provides several menus for a user to order a custom pizza, a pizza from the specials menu, display their receipt, and then 
 * quit the program once their done. The program will then quit once the user chooses to quit the program.
 * 
 * The MeatLoversPizza class inherits from the Pizza class to make a meat lover's pizza. It is set to be a pizza of large size, have pepperoni 
 * and sausage as toppings, and have total price of $18, all of which will be displayed in the receipt if chosen.
 */

public class MeatLoversPizza extends Pizza{ // MeatLoversPizza class inherited from Pizza class.
	
	/**
	 * Constructor method for MeatLoversPizza class.
	 */
	public MeatLoversPizza() {
		super(Size.LARGE); // Calls the super class (Pizza) to get the pizza size of large.
		addToppings(); // Calls method from Pizza class to add toppings.
	}
	
	/**
	 * Method to set the size of the meat lover's pizza to large.
	 */
	public void setSize() {
		this.size = Size.LARGE; // Sets meat lover's pizza to a large pizza.
	}
	
	/**
	 * Method to add toppings to the meat lover's pizza, which overrides the addToppings method from the Pizza class.
	 */
	public void addToppings() {
		super.addTopping(Toppings.PEPPERONI); // Adds pepperoni as a topping.
		super.addTopping(Toppings.SAUSAGE); // Adds sausage as a topping.
	}
	
	/**
	 * Method to get the price of the meat lover's pizza, which overrides the getPrice method from the Pizza class.
	 */
	public int getPrice() {
		return 18; // Sets the price of the meat lover's pizza to $18.
	}
	
	/**
	 * Method to display the info of the meat lover's pizza.
	 */
	public void display() {
		System.out.println("Meat Lovers Special"); // Message displayed in the receipt when a meat lover's pizza is ordered.
		super.display(); // Calls from the super class (Pizza) to display the contents of the meat lover's pizza.
	}
}
