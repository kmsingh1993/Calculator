package com.stonewain.calculator;

import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.stonewain.calculator", "com.stonewain.operator", "com.stonewain.parser" })
public class AppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in); // This should only be called once
	}
}
