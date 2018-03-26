package com.stonewain.calculator;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.stonewain.parser.Parser;

@Component
public class Calculator {

	private InputFactory inputFactory;
	private Parser expressionParser;

	public Calculator(InputFactory inputFactory, Parser expressionParser) {
		this.inputFactory = Objects.requireNonNull(inputFactory, "inputFactory reference was null");
		this.expressionParser = Objects.requireNonNull(expressionParser, "operatorFactory reference was null");
	}

	public float performCalculations() throws Exception {
		float result = 0;
		String operation = inputFactory.getInput("Please enter an Arithmetic expression to evaluate:");
		result = expressionParser.executeCalculation(operation);
		System.out.println("Your result " + result);
		return result;
	}
}
