package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.function.ArrayFunction;
import org.sample.java.lambda.service.ArrayService;

public class ArrayFunctionTest {

    // This method has the ArrayFunction functional interface as the
    // type of its first parameter. The other two parameters
    // receive an array and a value, both of type T.
    static <T> int doCount(ArrayFunction<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    @Test
    public void arrayFunctionTest() {
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};
        int count;

        count = doCount(ArrayService::<Integer>countMatching, vals, 4);
        System.out.println("vals contains " + count + " 4s");

        count = doCount(ArrayService::<String>countMatching, strs, "Two");
        System.out.println("strs contains " + count + " Twos");
    }
}
