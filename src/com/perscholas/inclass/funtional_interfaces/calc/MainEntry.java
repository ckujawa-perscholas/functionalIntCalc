package com.perscholas.inclass.funtional_interfaces.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainEntry {
	
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
	
	public void printMenu() {
		System.out.println("Enter your operation...");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Quit");
	}
	
	public void callOper(Operation oper, int[] values) {
		switch(oper) {
		case ADD:
			System.out.println(this.add.compute(values));
			break;
		default:
			throw new UnsupportedOperationException("Where did you learn math??? Pick a real operation!");
		}
	}
	
	public int[] getInts(String[] strings) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.valueOf(strings[i]);
		}
		return ints;
	}

	public static void main(String[] args) {
		
		Operation oper = null;
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		MainEntry me = new MainEntry();
		
		do {
			me.printMenu();
			int choice = scan.nextInt();
			if ( 1 <= choice && choice <= 4) {
				oper = Operation.getByInt(choice);
			} else if (choice == 5) {
				System.out.println("See you next time...");
				quit = true;
			} else {
				System.out.println("Seriously...pick a number from 1-5.");
			}
			
			scan.nextLine();
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
