package com.stonewain.calculator;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class OperatorFactory {
	AddOperator addOperator;
	SubtractOperator subtractOperator;
	DivideOperator divideOperator;
	MultiplyOperator multiplyOperator;
	SquareOperator squareOperator;
	LogOperator logOperator;
	
	public OperatorFactory(AddOperator addOperator, SubtractOperator subtractOperator, DivideOperator divideOperator,
			MultiplyOperator multiplyOperator, SquareOperator squareOperator, LogOperator logOperator) {
		this.addOperator = Objects.requireNonNull(addOperator, "addOperator reference was null");
		this.subtractOperator = Objects.requireNonNull(subtractOperator, "subtractOperator reference was null");
		this.divideOperator = Objects.requireNonNull(divideOperator, "divideOperator reference was null");
		this.multiplyOperator = Objects.requireNonNull(multiplyOperator, "multiplyOperator reference was null");
		this.squareOperator = Objects.requireNonNull(squareOperator, "squareOperator reference was null");
		this.logOperator = Objects.requireNonNull(logOperator, "logOperator reference was null");
	}

	public Operator getOperatorInstance(String operation) throws Exception {
		if (operation == null) {
			System.out.println("Null operation string");
			throw new NullPointerException("operation reference is null");
		}
		Operator operator;
		switch (operation) {
		case "+":
			operator = addOperator;
			break;
		case "-":
			operator = subtractOperator;
			break;
		case "/":
			operator = divideOperator;
			break;
		case "*":
			operator = multiplyOperator;
			break;
		case "^":
			operator = squareOperator;
			break;
		case "log":
			operator = logOperator;
			break;
		default:
			throw new Exception("Unkown Operator");
		}
		return operator;
	}
	
	//Data structure to hold mapping of operator types to associativity, precedence, numOperands
	//public static final
	

}
