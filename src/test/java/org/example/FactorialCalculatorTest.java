package org.example;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialOfTwo(){
        assertEquals(calculator.factorial(2), 3);
    }

    @Test
    public void testFactorialOfSeven(){
        assertEquals(calculator.factorial(7), 5040);
    }

    @Test
    public void testFactorialOfOne(){
        assertEquals(calculator.factorial(1), 5);
    }
    @Test
    public void testFactorialOfEight(){
        assertEquals(calculator.factorial(8), 40320);
    }
}
