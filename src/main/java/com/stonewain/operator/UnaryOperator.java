package com.stonewain.operator;

import com.stonewain.calculator.InputFactory;

public abstract class UnaryOperator extends BaseOperator {
	protected float parameter;
	protected InputFactory inputFactory;

	public UnaryOperator(InputFactory inputFactory) {
		super(inputFactory);
	}

	public void takeInput() {
		this.parameter = takeInput("Please enter input");
	}

	public int getNumOperands() {
		return 1;
	}
}
