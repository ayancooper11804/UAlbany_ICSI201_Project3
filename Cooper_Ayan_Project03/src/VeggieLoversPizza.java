/*
 * ICSI 201 Project 3: Pizza Shop
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program provides several menus for a user to order a custom pizza, a pizza from the specials menu, display their receipt, and then 
 * quit the program once their done. The program will then quit once the user chooses to quit the program.
 * 
 * The VeggieLoversPizza class inherits from the Pizza class to make a veggie lover's pizza. It is set to be a pizza of large size, have onions 
 * and peppers as toppings, and have total price of $17, all of which will be displayed in the receipt if chosen.
 */

public class VeggieLoversPizza  extends Pizza{ // VeggieLoversPizza class inherited from Pizza class.
	
	/**
	 * Constructor method for VeggieLoversPizza class.
	 */
	public VeggieLoversPizza() { 
		super(Size.LARGE); // Calls the super class (Pizza) to get the pizza size of large.
		addToppings(); // Calls method from Pizza class to add toppings.
	}
	
	/**
	 * Method to set the size of the veggie lover's pizza to large.
	 */
	public void setSize(Size sizeS) {
		this.size = Size.LARGE; // Sets veggie lover's pizza to a large pizza.
	}
	
	/**
	 * Method to add toppings to the veggie lover's pizza, which overrides the addToppings method from the Pizza class.
	 */
	public void addToppings() {
		super.addTopping(Toppings.ONIONS); // Adds onions as a topping.
		super.addTopping(Toppings.PEPPERS); // Adds bell peppers as a topping.
	}
	
	/**
	 * Method to get the price of the veggie lover's pizza, which overrides the getPrice method from the Pizza class.
	 */
	public int getPrice() {
		return 17; // Sets the price of the veggie lover's pizza to $17.
	}
	
	/**
	 * Method to display the info of the veggie lover's pizza.
	 */
	public void display() {
		System.out.println("Veggie Lovers Special"); // Message displayed in the receipt when a veggie lover's pizza is ordered.
		super.display(); // Calls from the super class (Pizza) to display the contents of the veggie lover's pizza.
	}
}
