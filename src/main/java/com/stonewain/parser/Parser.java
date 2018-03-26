package com.stonewain.parser;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

@Component
public class Parser {

	private InfixToPostfixExpressionConverter infixToPostfixExpressionConverter;
	private PostfixExpressionEvaluator postfixExpressionEvaluator;

	public Parser(InfixToPostfixExpressionConverter infixToPostfixExpressionConverter,
			PostfixExpressionEvaluator postfixExpressionEvaluator) {
		this.infixToPostfixExpressionConverter = infixToPostfixExpressionConverter;
		this.postfixExpressionEvaluator = postfixExpressionEvaluator;
	}

	/*
	 * Currently requires input string to always be of format: appropriate number of
	 * single digit numbers or parentheses or operations
	 */
	public float executeCalculation(String expressionString) throws Exception {
		LinkedList<Object> postfixString = infixToPostfixExpressionConverter.convertToPostfixString(expressionString);
		return postfixExpressionEvaluator.executeCalculation(postfixString);
	}
}
