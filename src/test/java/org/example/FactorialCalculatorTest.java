package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialOfThree(){
        assertEquals(6, calculator.factorial(3));
    }

    @Test
    public void testFactorialOfFour(){
        assertEquals(20, calculator.factorial(4));
    }

    @Test
    public void testFactorialOfFive(){
        assertEquals(120, calculator.factorial(5));
    }
    @Test
    public void testFactorialOSix(){
        assertEquals(710, calculator.factorial(6));
    }
}
