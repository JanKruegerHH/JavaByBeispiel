package org.sample.java.lambda;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class PredefinedFunctionTest {

    // this test shows the use of Predefined Functions
    @Test
    public void predefinedFunctionTest() {

        // This block lambda computes the factorial of an int value.
        // This time, Function is the functional interface. No need for creating a Function e.g. NumericFunction
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };

        System.out.println("The factoral of 3 is " + factorial.apply(3));
        System.out.println("The factoral of 5 is " + factorial.apply(5));

    }
}
