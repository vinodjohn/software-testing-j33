package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  Example for TDD
 *
 * @author Vinod John
 * @Date 04.08.2024
 */
class FibonacciTest {

    @Test
    public void whenGetValueCalled_WithZeroInput_shouldReturnZero() {
        Assertions.assertEquals(0, Fibonacci.getValue(0));
    }

    @Test
    public void whenGetValueCalled_WithOneInput_shouldReturnOne() {
        Assertions.assertEquals(1, Fibonacci.getValue(1));
    }

    @Test
    public void whenGetValueCalled_WithAnyInput_shouldReturnValue() {
        Assertions.assertEquals(8, Fibonacci.getValue(6));
        Assertions.assertEquals(987, Fibonacci.getValue(16));
        Assertions.assertEquals(144, Fibonacci.getValue(12));
    }
}