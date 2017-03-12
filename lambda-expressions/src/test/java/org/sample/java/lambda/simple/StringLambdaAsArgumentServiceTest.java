package org.sample.java.lambda.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StringLambdaAsArgumentServiceTest {

    @Test
    public void changeToUppercaseTest() {

        assertEquals("JAN", StringLambdaAsArgumentService.changeToUppercase("jan"));
        assertNotEquals("xxx", StringLambdaAsArgumentService.changeToUppercase("xxx"));
    }

    @Test
    public void removeSpacesTest() {

        assertEquals("JAN", StringLambdaAsArgumentService.removeSpaces("J A   N"));
        assertNotEquals("x  xx", StringLambdaAsArgumentService.removeSpaces("xx   x"));
    }

    @Test
    public void reverseStringTest() {

        assertEquals("NAJ", StringLambdaAsArgumentService.reverseStringStatic("JAN"));
        assertNotEquals("JAN", StringLambdaAsArgumentService.reverseStringStatic("JAN"));

        // Method-Reference to static method
        // This works because reverseString is compatible with the StringFunction functional interface.
        assertEquals("NAJ",
                StringLambdaAsArgumentService.stringOperation(StringLambdaAsArgumentService::reverseStringStatic, "JAN")
        );

        // Method-Reference to instant method
        StringLambdaAsArgumentService stringLambdaAsArgumentService = new StringLambdaAsArgumentService();
        assertEquals("NAJ",
                StringLambdaAsArgumentService.stringOperation(stringLambdaAsArgumentService::reverseString,"JAN"));
        assertNotEquals("JAN",
                StringLambdaAsArgumentService.stringOperation(stringLambdaAsArgumentService::reverseString,"JAN"));
    }

}
