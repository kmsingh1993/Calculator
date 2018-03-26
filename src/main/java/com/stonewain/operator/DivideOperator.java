package com.stonewain.operator;

import org.springframework.stereotype.Component;

import com.stonewain.calculator.InputFactory;

@Component
public class DivideOperator extends BinaryOperator{

	public DivideOperator(InputFactory inputFactory) {
		super(inputFactory);
	}

	@Override
	public float performCalc() {
		return firstParameter/secondParameter;
	}

	@Override
	public float performCalc(float[] operands) throws Exception {
		if (operands.length != getNumOperands()) {
			throw new Exception ("Wrong number of operands provided");
		}
		return operands[0] / operands[1];
	}

	@Override
	public String getAssociativity() {
		return "left";
	}
	
	@Override
	public int getPrecedenceLevel() {
		return 1;
	}
}
