package com.perscholas.inclass.funtional_interfaces;

public class Tester {

	public static void main(String[] args) {
		TestFunctionalInterface tif = new TestFunctionalInterface() {
			@Override
			public void doSomething() {
				System.out.println("something is done...");
			}
		};
		
		tif.doSomething();
	}

}
