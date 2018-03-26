package com.stonewain.calculator;

import java.util.Objects;

public abstract class BaseOperator implements Operator {
	InputFactory inputFactory;

	public BaseOperator(InputFactory inputFactory) {
		this.inputFactory = Objects.requireNonNull(inputFactory, "inputFactory reference is null");
	}
	
	protected float takeInput(String displayMsg) {
		String inputString = inputFactory.getInput(displayMsg);
		return Float.valueOf(inputString);
	}
}
