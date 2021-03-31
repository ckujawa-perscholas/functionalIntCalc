package com.perscholas.inclass.funtional_interfaces.calc;

public enum Operation {
	ADD(1),
	SUBTRACT(2),
	MULTIPLY(3),
	DIVIDE(4);
	
	private int value;
	
	private Operation(int value) {
		this.value = value;
	}
	
	public static Operation getByInt(int searchVal) {
		Operation res = null;
		
		for (int i = 0; i < Operation.values().length; i++) {
			if (Operation.values()[i].getValue() == searchVal) {
				res = Operation.values()[i];
				break;
			}
		}
		
		return res;
	}
	
	public int getValue() {
		return this.value;
	}
}
