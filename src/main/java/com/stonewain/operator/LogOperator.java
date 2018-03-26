package com.stonewain.operator;

import org.springframework.stereotype.Component;

import com.stonewain.calculator.InputFactory;

@Component
public class LogOperator extends UnaryOperator{

	public LogOperator(InputFactory inputFactory) {
		super(inputFactory);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAssociativity() {
		return "left";
	}

	@Override
	public int getNumOperands() {
		return 1;
	}

	@Override
	public int getPrecedenceLevel() {
		return 4;
	}

	@Override
	public float performCalc() {
		return (float) Math.log10(parameter);
	}

	@Override
	public float performCalc(float[] operands) throws Exception {
		if (operands.length != getNumOperands()) {
			throw new Exception ("Wrong number of operands provided");
		}
		return (float) Math.log10(operands[0]);
	}

}
