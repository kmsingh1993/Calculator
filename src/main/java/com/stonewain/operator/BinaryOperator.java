package com.stonewain.operator;

import com.stonewain.calculator.InputFactory;

public abstract class BinaryOperator extends BaseOperator {
	protected float firstParameter;
	protected float secondParameter;
	
	public BinaryOperator(InputFactory inputFactory) {
		super(inputFactory);
	}
	
	public void takeInput() {
		firstParameter = takeInput("Please enter first parameter");
		secondParameter = takeInput("Please enter second parameter");
	}
	
	public int getNumOperands() {
		return 2;
	}
}
