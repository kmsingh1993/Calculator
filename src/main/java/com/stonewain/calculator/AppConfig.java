package com.stonewain.calculator;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.stonewain.calculator", "com.stonewain.operator"})
public class AppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in); //This should only be called once
	}
//	@Bean
//	public InputFactory inputFactory() {
//		return new InputFactory(scanner());
//	}
//	@Bean
//	public AddOperator addOp() {
//		return new AddOperator(inputFactory());
//	}
//	@Bean
//	public SubtractOperator subOp() {
//		return new SubtractOperator(inputFactory());
//	}
//	@Bean
//	public DivideOperator divOp() {
//		return new DivideOperator(inputFactory());
//	}
//	@Bean
//	public MultiplyOperator multOp() {
//		return new MultiplyOperator(inputFactory());
//	}
//	@Bean
//	public SquareOperator squOp() {
//		return new SquareOperator(inputFactory());
//	}
//	@Bean
//	public OperatorFactory operatorFactory() {
//		return new OperatorFactory(addOp(), subOp(), divOp(), multOp(), squOp());
//	}
//	
//	@Bean
//	public Calculator calculator(InputFactory inputFactory, OperatorFactory operatorFactory) {
//		return new Calculator(inputFactory, operatorFactory);
//	}
}
