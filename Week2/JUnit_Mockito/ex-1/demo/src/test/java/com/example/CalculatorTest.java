package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(8, calc.add(5, 3));
    }
}