package org.sample.java.lambda.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenericFunctionTest {

    @Test
    public void stringTest() {
        // String-based
        GenericFunction<String> reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        assertEquals("naJ", reverse.func("Jan"));
        assertNotEquals("XXX", reverse.func("Jan"));
    }

    @Test
    public void integerTest() {
        // Integer-based
        GenericFunction<Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++)
                result = i * result;
            return result;
        };

        assertTrue(6 == factorial.func(3));
        assertFalse(7 == factorial.func(3));
        assertTrue(120 == factorial.func(5));
    }

}
