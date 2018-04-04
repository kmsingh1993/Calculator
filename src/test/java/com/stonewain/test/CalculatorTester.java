package com.stonewain.test;

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.stonewain.calculator.Calculator2;
import com.stonewain.parser.Parser;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTester {

    @Mock
    Parser parser;

    @InjectMocks
    Calculator2 calculator = new Calculator2();

    @Test
    public void testAdd() throws Exception {
        when(parser.executeCalculation("2+2")).thenReturn((float) 4);
        System.out.println(calculator.performCalculations("2+2"));
        Assert.assertEquals(calculator.performCalculations("2+2"), 4, 0);
    }
}
