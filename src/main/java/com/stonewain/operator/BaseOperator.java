package com.stonewain.operator;

import java.util.Objects;

import com.stonewain.calculator.InputFactory;

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
