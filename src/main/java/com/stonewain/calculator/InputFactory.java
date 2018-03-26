package com.stonewain.calculator;

import java.util.Objects;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InputFactory implements AutoCloseable {
	private Scanner myScanner;

	InputFactory(Scanner scanner) {
		myScanner = Objects.requireNonNull(scanner);
	}

	public String getInput(String displayMsg) {
		if (displayMsg == null) {
			throw new NullPointerException("displayMsg reference is null");
		}
		System.out.println(displayMsg);
		String output = myScanner.nextLine();
		return output;
	}

	@Override
	public void close() throws Exception {
		myScanner.close();
	}
}
