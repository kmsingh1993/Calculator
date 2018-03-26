package com.stonewain.calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PostfixExpressionEvaluator {

	public float executeCalculation(LinkedList<Object> postfixString) throws Exception {
		if (postfixString.size() == 1) {
			return (float) postfixString.get(0);
		}
		for (int i = 0; i < postfixString.size(); i++) {
			Object token = postfixString.get(i);
			if (token instanceof Operator) {
				Operator operator = (Operator) token;
				int resultIndex = i - operator.getNumOperands();
				float[] operandArray = new float[operator.getNumOperands()];
				try {
					for (int j = 1; j <= operator.getNumOperands(); j++) {
						operandArray[operator.getNumOperands()-j] = ((float) postfixString.remove(i - j));
					}
				}
				// Specifically catch out of bounds exception
				// and casting to float exception, if you encounter any non number
				catch (NoSuchElementException e) {
					throw new Exception("Operator " + operator + " does not have sufficient operands!");
				}
				float result = operator.performCalc(operandArray);
				postfixString.set(resultIndex, result);
				break;
			}
		}
		return executeCalculation(postfixString);
	}

	public static void main(String[] args) throws Exception {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)){
			InfixToPostfixExpressionConverter converter = ctx.getBean(InfixToPostfixExpressionConverter.class);
			PostfixExpressionEvaluator evaluator = ctx.getBean(PostfixExpressionEvaluator.class);
			LinkedList<Object> output = converter.convertToPostfixString(" 10-4 * 2/ (1    / 5) ^(2)");
			float result = evaluator.executeCalculation(output);
			System.out.println(result);
		}
	}

}
