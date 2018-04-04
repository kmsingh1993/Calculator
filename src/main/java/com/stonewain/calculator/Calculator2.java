package com.stonewain.calculator;

import java.util.Objects;

import com.stonewain.parser.Parser;

public class Calculator2 {
    private Parser expressionParser;

    public void setExpressionParser(Parser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public float performCalculations(String expression) throws Exception {
        float result = 0;
        result = expressionParser.executeCalculation(expression);
        System.out.println("Your result " + result);
        return result;
    }
}
