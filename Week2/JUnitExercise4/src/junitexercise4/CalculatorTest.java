package junitexercise4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup Complete");
    }

    @After
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown Complete");
    }

    @Test
    public void testAddition() {
        int a = 7;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        int a = 10;
        int b = 3;
        int result = calculator.subtract(a, b);
        assertEquals(7, result);
    }

    @Test
    public void testMultiplication() {
        int a = 4;
        int b = 6;
        int result = calculator.multiply(a, b);
        assertEquals(24, result);
    }

    @Test
    public void testDivision() {
        int a = 20;
        int b = 5;
        int result = calculator.divide(a, b);
        assertEquals(4, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZero() {
        int a = 10;
        int b = 0;
        calculator.divide(a, b);
    }
}
