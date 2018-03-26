package com.stonewain.operator;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class OperatorFactory {

	private final HashMap<String, Operator> mapOfOperators = new HashMap<String, Operator>();

	public OperatorFactory(List<Operator> listOfOperators) {
		for (Operator operator : listOfOperators) {
			mapOfOperators.put(operator.getSymbol(), operator);
		}
	}

	public Operator getOperatorInstance(String operation) throws Exception {
		if (operation == null) {
			System.out.println("Null operation string");
			throw new NullPointerException("operation reference is null");
		}
		Operator operator = mapOfOperators.get(operation);
		return operator;
	}
}
