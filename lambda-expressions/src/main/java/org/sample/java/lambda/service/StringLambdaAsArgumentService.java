package org.sample.java.lambda.service;

import org.sample.java.lambda.function.StringFunction;

public class StringLambdaAsArgumentService {

    public static String stringOperation(StringFunction stringFunction, String string) {
        return stringFunction.func(string);
    }

    public static String changeToUppercase(String in) {

        // return stringOperation((str) -> str.toUpperCase(), in);
        // use Method-Reference
        return stringOperation(String::toUpperCase, in);
    }

    public static String removeSpaces(String in) {

        String result;

        result = stringOperation((str) -> {
            String out = "";
            int i;
            for (i = 0; i < str.length(); i++)
                if (str.charAt(i) != ' ')
                    out += str.charAt(i);
            return out;
        }, in);
        return result;
    }

    public static String reverseStringStatic(String in) {

        StringFunction reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        return stringOperation(reverse, in);
    }

    public String reverseString(String in) {

        StringFunction reverse = (str) -> {
            String result = "";
            int i;
            for (i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);
            return result;
        };

        return stringOperation(reverse, in);
    }

}
