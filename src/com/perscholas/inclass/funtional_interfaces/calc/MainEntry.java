package com.perscholas.inclass.funtional_interfaces.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * These are Javadoc comments...it's a good practice to include them
 * throughout your code to document it. It's what is used by the javadoc command
 * to generate documentation.
 *
 * Class: MainEntry
 * Description: the entry point for an example applications that demonstrates the use
 * of functional interfaces.
 */
public class MainEntry {

	/**
	 * our add implementation..
	 */
	public Calc add = new Calc() {
		@Override
		public int compute(int[] vals) {
			int sum = 0;
			for (int i : vals) {
				sum += i;
			}
			return sum;
		}
	};

	/**
	 * A function to print our menu
	 */
	public void printMenu() {
		System.out.println("Enter your operation...");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Quit");
	}

	/**
	 * Calls the appropriate operator based on the Operation received, passing values to the operation
	 * then printing the result to the console.
	 *
	 * @param oper
	 * @param values
	 */
	public void callOper(Operation oper, int[] values) {
		switch(oper) {
		case ADD:
			System.out.println(this.add.compute(values));
			break;
		default:
			throw new UnsupportedOperationException("Where did you learn math??? Pick a real operation!");
		}
	}

	/**
	 * Convert String[] to int[]
	 * @param strings
	 * @return
	 */
	public int[] getInts(String[] strings) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.valueOf(strings[i]);
		}
		return ints;
	}

	/**
	 * Exactly what it says :)
	 * @param args
	 */
	public static void main(String[] args) {
		
		Operation oper = null;
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		MainEntry me = new MainEntry();
		
		do {
			me.printMenu();
			int choice = scan.nextInt();
			//if we have a valid menu choice, set oper as appropriate
			if ( 1 <= choice && choice <= 4) {
				oper = Operation.getByInt(choice);
				//if choice = 5, we exit...
			} else if (choice == 5) {
				System.out.println("See you next time...");
				quit = true;
				//it's not a valid choice
			} else {
				System.out.println("Seriously...pick a number from 1-5.");
			}
			
			scan.nextLine(); //advance the scanner
			//we have a valid Operation...get the data and execute it.
			if (oper != null) {
				System.out.println("Please print a space separated list of numbers. If you chose Divide, only enter 2");
				String vals =  scan.nextLine();
				int[] values = me.getInts(vals.split(" "));
				me.callOper(oper, values);
				oper = null; //reset to null for next operation
			}
			
		} while (!quit);
	}

}
