package org.sample.java.lambda.service;

import org.sample.java.lambda.function.NumericFunction;

public class NumericService {

    public static boolean isFactor(int number, int divisor) {

        NumericFunction isFactor = (n, d) -> (n % d) == 0;

        return isFactor.test(number,divisor);
    }

}
