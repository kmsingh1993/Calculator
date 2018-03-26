package com.stonewain.calculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) throws Exception {
		
		System.out.println(Constants.WELCOME_MESSAGE);
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
			Calculator calcBean = ctx.getBean(Calculator.class); 
			calcBean.performCalculations();
		}
	}
}
