package com.stonewain.operator;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class OperatorFactory {
	
	private final HashMap<String, Operator> mapOfOperators = new HashMap<String, Operator>();
	
	public OperatorFactory(AddOperator addOperator, SubtractOperator subtractOperator, DivideOperator divideOperator,
			MultiplyOperator multiplyOperator, ExponentOperator exponentOperator, LogOperator logOperator) {
		mapOfOperators.put("+", Objects.requireNonNull(addOperator, "addOperator reference was null"));
		mapOfOperators.put("-", subtractOperator = Objects.requireNonNull(subtractOperator, "subtractOperator reference was null"));
		mapOfOperators.put("/", Objects.requireNonNull(divideOperator, "divideOperator reference was null"));
		mapOfOperators.put("*", Objects.requireNonNull(multiplyOperator, "multiplyOperator reference was null"));
		mapOfOperators.put("^", Objects.requireNonNull(exponentOperator, "exponentOperator reference was null"));
		mapOfOperators.put("log", Objects.requireNonNull(logOperator, "logOperator reference was null"));
		
		
		
	}

	public Operator getOperatorInstance(String operation) throws Exception {
		if (operation == null) {
			System.out.println("Null operation string");
			throw new NullPointerException("operation reference is null");
		}
		Operator operator = mapOfOperators.get(operation);
		return operator;
	}

	//Data structure to hold mapping of operator types to associativity, precedence, numOperands
	//public static final
	

}
