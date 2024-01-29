package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.function.NumericFunction;
import org.sample.java.lambda.service.NumericService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumericFunctionTest {

    @Test
    public void isFactorTest() {

        NumericFunction isFactor = (n, d) -> (n % d) == 0;

        assertTrue(isFactor.test(10, 5));
        assertFalse(isFactor.test(10,7));
    }

    @Test
    public void numericServiceTest() {

        assertTrue(NumericService.isFactor(10,2));
        assertFalse(NumericService.isFactor(10,3));

    }

    @Test
    public void isGreaterThanTest() {

        // Block Function
        NumericFunction isGreaterThan = (n, d) -> {

            boolean result = false;

            if (n > d ){
                result=true;
            }
            return result;
        };

        assertTrue(isGreaterThan.test(10, 5));
        assertFalse(isGreaterThan.test(10,17));
    }


}
