package com.stonewain.parser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.stonewain.calculator.AppConfig;
import com.stonewain.operator.OperatorFactory;

@Component
public class StringToListParser {
	private OperatorFactory operatorFactory;

	public StringToListParser(OperatorFactory operatorFactory) {
		this.operatorFactory = operatorFactory;
	}

	public LinkedList<Object> convert(String expressionString) throws Exception {
		Pattern pattern = Pattern.compile("([0-9]+\\.[0-9]+)|([0-9]+)|[\\+\\-\\*\\/\\^]|\\(|\\)|log");
		Matcher matcher = pattern.matcher(expressionString);

		LinkedList<String> matches = new LinkedList<String>();

		while (matcher.find()) {
			String group = matcher.group();
			matches.addLast(group);
		}
		return convertToAssortedList(matches);
	}

	private LinkedList<Object> convertToAssortedList(LinkedList<String> expressionList) throws Exception {
		LinkedList<Object> output = new LinkedList<Object>();

		for (String token : expressionList) {
			try {
				output.addLast(Float.parseFloat(token));
				continue;
			} catch (NumberFormatException e) {
			}
			try {
				output.addLast(operatorFactory.getOperatorInstance(token));
				continue;
			} catch (Exception e) {
				// then it's just a string - for example left right brackets
			}
			output.addLast((String) token);
		}
		return output;
	}

	public static void main(String[] args) throws Exception {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			StringToListParser parser = ctx.getBean(StringToListParser.class);
			LinkedList<Object> output = parser.convert("3+ 4*   2/   (1-5)^ 2 ^3");
			System.out.println(output);
		}
	}

}
