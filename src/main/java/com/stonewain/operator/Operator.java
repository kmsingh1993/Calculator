package com.stonewain.operator;

public interface Operator {	
	public String getAssociativity();
	public int getNumOperands();
	public int getPrecedenceLevel();
	public float performCalc();
	
	public void takeInput();
	
	public float performCalc(float[] operands) throws Exception;
	
}
