/*
 * ICSI 201 Project 3: Pizza Shop
 * State University of New York, University at Albany
 * Developed by Ayan Cooper, CS Major, Class of 2026
 * 
 * This program provides several menus for a user to order a custom pizza, a pizza from the specials menu, display their receipt, and then 
 * quit the program once their done. The program will then quit once the user chooses to quit the program.
 * 
 * The Driver class runs the entire program, running all the functions mentioned above via other classes.
 */

import java.util.Scanner; // Imports the scanner class.

public class Driver { // Driver class, which uses methods and other blocks of code to call from the various files in the project to 
					  // fulfill the functionality of the project.
	
	public static void main(String[] args) { // Main method to run the program.
		PizzaOrder PO = new PizzaOrder(); // Variable used to make a new pizza order.
		char choice, pizzaSize, specialPizza, topping; // Initializes all char variables
		int addToIndex = 0; // Holds the current amount of pizzas. Used to check which pizza the user is making.
		
		Scanner keyboard = new Scanner(System.in); // Scanner object to read user input.
		choice = 'c'; // Initializes choice char.
		
		/*
		 * This entire do/while loop uses a switch case to display all menus for the project, giving the user the option to order pizza, 
		 * order pizza from the specials menu, see their order receipt, or quit the program. Once the users chooses the quit, 
		 * the prohram will be terminated.
		 */
		do {
			printMainMenu(); // Used to display the main menu.
			choice = keyboard.nextLine().charAt(0); // User's input.
			
			/*
			 * This part of the switch case is for the user to order a pizza. The can choose the size and toppings.
			 */
			switch (choice) {
			case 'O':
			case 'o':
				pizzaSize = '0'; // This represents the size character for input
				
				/*
				 * This nested do/while loop uses a switch case to display the sizes of pizza the user can choose from. The user can choose 
				 * to order a small, mediumm, or large pizza. The loop will end after a size is chosen.
				 */
				do {
					selectSize(); //Used to display the size of pizza the user can choose from.
					pizzaSize = keyboard.nextLine().charAt(0); // User's input for the size of the pizza.
					switch(pizzaSize) {
					case 'S':
					case 's':
						PO.addPizza(new Pizza(Size.SMALL)); // Makes pizza small size.
						break;
					case 'M':
					case 'm':
						PO.addPizza(new Pizza(Size.MEDIUM)); // Makes pizza medium size.
						break;
					case 'L':
					case 'l':
						PO.addPizza(new Pizza(Size.LARGE)); // Makes pizza large size.
						break;
					default:
						System.out.println("Invalid Selection - Please select a valid menu option"); // Displayed if user input is incorrect.
					}
				} while (!(pizzaSize == 'S' || pizzaSize == 's' || pizzaSize == 'M' || pizzaSize == 'm' || pizzaSize == 'L' || pizzaSize == 'l'));
				
				topping = '0'; // This represents the topping character for input
				
				/*
				 * This nested do/while loop uses a switch case to display the toppings of pizza the user can choose from. The user can choose 
				 * to add a pepperoni, sausage, bell peppers, or onions on their pizza. The loop will end once the user is done adding 
				 * toppings.
				 */
				do {
					selectToppings(); // Used to display toppings that can be added to the pizza.
					topping = keyboard.nextLine().charAt(0); // User's input for the toppings to be added on the pizza.
					switch(topping) {
					case 'P':
					case 'p':
						PO.pizza.get(addToIndex).addTopping(Toppings.PEPPERONI); // Adds pepperoni.
						break;
					case 'S':
					case 's':
						PO.pizza.get(addToIndex).addTopping(Toppings.SAUSAGE); // Adds sausage.
						break;
					case 'O':
					case 'o':
						PO.pizza.get(addToIndex).addTopping(Toppings.ONIONS); // Adds onion.
						break;
					case 'B':
					case 'b':
						PO.pizza.get(addToIndex).addTopping(Toppings.PEPPERS); // Adds bell peppers.
						break;
					case 'D':
					case 'd':
						break;
					default:
						System.out.println("Invalid Selection - Please select a valid menu option"); // Displayed if user input is incorrect.
					}
				} while (!(topping == 'D' || topping == 'd'));
				
				addToIndex++; // Adds orderd pizza to the receipt. 
				break;
			
			/*
			 * This nested do/while loop uses a switch case to display the special pizzas the user can order. The user can choose 
			 * to order a veggie lover's or a meat lover's pizza. The loop after a special is chosen, or if the user chooses to return 
			 * to the main menu.
			 */
			case 'S':
			case 's':
				specialPizza = '0'; // This represents the special character for input
				do {
					specials(); // Used to display toppings that can be added to the pizza.
					specialPizza = keyboard.nextLine().charAt(0); // User's input for special pizza they choose either add or not add.
					switch(specialPizza) {
					case 'V':
					case 'v':
						PO.addPizza(new VeggieLoversPizza());
						break;
					case 'M':
					case 'm':
						PO.addPizza(new MeatLoversPizza());
						break;
					case 'B':
					case 'b':
						break;
					default:
						System.out.println("Invalid Selection - Please select a valid menu option"); // Displayed if user input is incorrect.
					}
				} while (!(specialPizza == 'V' || specialPizza == 'v' || specialPizza == 'M' || specialPizza == 'm' || specialPizza == 'B' || specialPizza == 'b'));
				break;
			
			/*
			 * This will display the entire receipt of the user's order. The program will return the to main menu afterwards.
			 */
			case 'R':
			case 'r':
				PO.display(); // Displays order receipt.
				break;
			
			/*
			 * This will quit the program
			 */
			case 'Q':
			case 'q':
				System.out.println("Exiting Program...");
				break;
			default:
				System.out.println("Invalid Selection - Please select a valid menu option"); // Displayed if user input is incorrect.
			}
		} while (!(choice == 'Q' || choice == 'q'));
	}
	
	// Method used to display the main menu
	public static void printMainMenu() {
		System.out.println("------------------------");
		System.out.println("MAIN MENU:");
		System.out.println(" (O)rder a pizza");
		System.out.println(" (S)pecials list");
		System.out.println(" (R)eceipt display");
		System.out.println(" (Q)uit");
		System.out.print("Enter your choice: ");
	}
	
	//Method used to display the size of pizza the user can choose from.
	public static void selectSize() {
		System.out.println("------------------------");
		System.out.println("SELECT PIZZA SIZE");
		System.out.println(" (S)mall");
		System.out.println(" (M)edium");
		System.out.println(" (L)arge");
		System.out.print("Enter your choice: ");
	}
	
	// Method used to display toppings that can be added to the pizza.
	public static void selectToppings() {
		System.out.println("------------------------");
		System.out.println("SELECT TOPPINGS:");
		System.out.println(" (P)epperoni");
		System.out.println(" (S)ausage");
		System.out.println(" (O)nions");
		System.out.println(" (B)ell peppers");
		System.out.println(" (D)one - no more toppings");
		System.out.print("Enter your choice: ");
	}
	
	// Displays the special pizza menu.
	public static void specials() {
		System.out.println("------------------------");
		System.out.println("SELECT SPECIAL");
		System.out.println(" (V)eggie Lovers Pizza");
		System.out.println(" (M)eat Lovers Pizza");
		System.out.println(" (B)ack to Main Menu");
		System.out.print("Enter your choice: ");
	}
	
}
