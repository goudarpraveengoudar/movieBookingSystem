package com.vishwa.movieBookingSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Name of test class :<ClassName>Test
 */
public class CalculatorTest {
    /**
     * Test Add
     * test <methodName>
     */
    @Test
    public void testAdd() {
        //Expected result : 2,3 -> 5
        int expectedResult = 5;


        //Actual result
        int actualResult = new Calculator().add(2, 3);

        /**
         * If Actual is matching with expected
         * yes -> Pass
         * No -> Fail
         */
        Assertions.assertEquals(actualResult, expectedResult);
    }

    /**
     * Test Sub
     */
    @Test
    public void testSub() {
        int exceptedResult = 1;

        //Actual result
        int actualResult = new Calculator().sub(3, 2);

        Assertions.assertEquals(actualResult, exceptedResult);
    }

    /**
     * Test Division
     */
    @Test
    public void testDev() {
        int exceptedResult = 1;

        int actualResult = new Calculator().division(3, 3);

        Assertions.assertEquals(actualResult, exceptedResult);

    }


    /**
     * Test Multiplication
     */
    @Test
    public void testMul() {
        int exceptedResult = 6;
        int actualResult = new Calculator().multiplication(3, 2);

        Assertions.assertEquals(actualResult, exceptedResult);
    }


}
