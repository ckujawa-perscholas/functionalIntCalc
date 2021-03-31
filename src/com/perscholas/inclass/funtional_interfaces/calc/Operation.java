package com.perscholas.inclass.funtional_interfaces.calc;

/**
 * An enum defining our calculation options...
 */
public enum Operation {
	//define values for each element in our enum so we can use them to retrieve the associated Operation.
	// we do this because if we rely on Operation.getValues() and use the index, we get the wrong Operation
	// when someone adds or removes an Operation...
	ADD(1),
	SUBTRACT(2),
	MULTIPLY(3),
	DIVIDE(4);
	
	private int value;

	/**
	 * Constructor...
	 * @param value
	 */
	private Operation(int value) {
		this.value = value;
	}

	/**
	 * Retrieve the Operation associated with the enum
	 * note that this is not efficient. If I had a large enum, I'd probably want
	 * to define a Map<Integer, Operation> and use the value as the key for its Operation.
	 * @param searchVal
	 * @return
	 */
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

	/**
	 * simple getter...since we don't want anyone changing our values, we don't give
	 * anyone the option...
	 * @return
	 */
	public int getValue() {
		return this.value;
	}
}
