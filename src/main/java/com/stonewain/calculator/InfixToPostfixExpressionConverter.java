package com.stonewain.calculator;

import java.util.LinkedList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.stonewain.operator.Operator;

@Component
public class InfixToPostfixExpressionConverter {
	StringToListParser stringToListParser;
	LinkedList<Object> outputList;
	LinkedList<Object> operatorList;

	public InfixToPostfixExpressionConverter(StringToListParser stringToListParser) {
		this.stringToListParser = stringToListParser;
	}

	private void parseRightBracket() throws Exception {
		while (!operatorList.isEmpty()) {
			Object topOfOperatorStack = operatorList.removeFirst();
			if (topOfOperatorStack instanceof String && topOfOperatorStack.equals("(")) {
				return;
			}
			outputList.addLast((Operator) topOfOperatorStack);
		}
		throw new Exception("Unopened ( bracket");
	}

	private void parseOperator(Operator token) {
		while (!operatorList.isEmpty()) {
			Object topOfOperatorStack = operatorList.peekFirst();
			if (topOfOperatorStack instanceof String && topOfOperatorStack.equals("(")) {
				break;
			}
			Operator topOperator = (Operator) topOfOperatorStack;
			if ((topOperator.getPrecedenceLevel() > token.getPrecedenceLevel())
					|| (topOperator.getPrecedenceLevel() == token.getPrecedenceLevel()
							&& topOperator.getAssociativity().equals("left"))) {
				outputList.addLast(operatorList.removeFirst());
				continue;
			}
			break;
		}
		operatorList.addFirst(token);
	}

	public LinkedList<Object> convertToPostfixString(String infixString) throws Exception {
		LinkedList<Object> infixList = stringToListParser.convert(infixString);
		outputList = new LinkedList<Object>();
		operatorList = new LinkedList<Object>();

		for (int i = 0; i < infixList.size(); i++) {
			Object token = infixList.get(i);

			if (token instanceof Float) {
				outputList.addLast(token);
			} else if (token instanceof String) {
				if (token.equals("(")) {
					operatorList.addFirst(token);
				} else if (token.equals(")")) {
					parseRightBracket();
				} else {
					throw new Exception("Unkown string passed");
				}
			} else if (token instanceof Operator) {
				parseOperator((Operator) token);
			} else {
				throw new Exception("Unknown object passed");
			}
		}

		for (Object binaryOperator : operatorList) {
			outputList.addLast(binaryOperator);
		}
		return outputList;
	}

	public static void main(String[] args) throws Exception {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			InfixToPostfixExpressionConverter converter = ctx.getBean(InfixToPostfixExpressionConverter.class);
			LinkedList<Object> output = converter.convertToPostfixString(" 3+4 * 2/ (1    - 5) ^2^3");
			System.out.println(output);
		}
	}
}
