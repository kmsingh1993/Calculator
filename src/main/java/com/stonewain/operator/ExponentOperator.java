package com.stonewain.operator;

import org.springframework.stereotype.Component;

import com.stonewain.calculator.InputFactory;

@Component
public class ExponentOperator extends BinaryOperator {

	public ExponentOperator(InputFactory inputFactory) {
		super(inputFactory);
	}

	@Override
	public float performCalc() {
		return (float) Math.pow(firstParameter, secondParameter);
	}

	@Override
	public float performCalc(float[] operands) throws Exception {
		if (operands.length != getNumOperands()) {
			throw new Exception ("Wrong number of operands provided");
		}
		return (float) Math.pow(operands[0], operands[1]);
	}

	@Override
	public String getAssociativity() {
		return "right";
	}

	@Override
	public int getPrecedenceLevel() {
		return 2;
	}
}
