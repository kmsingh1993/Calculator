package com.stonewain.calculator;

public abstract class UnaryOperator extends BaseOperator {
	protected float parameter;
	protected InputFactory inputFactory;
	
	public UnaryOperator(InputFactory inputFactory) {
		super(inputFactory);
	}
	
	public void takeInput() {
		this.parameter = takeInput("Please enter input");
	}
}
