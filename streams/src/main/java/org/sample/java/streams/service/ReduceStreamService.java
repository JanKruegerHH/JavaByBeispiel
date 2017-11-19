package org.sample.java.streams.service;

import java.util.List;
import java.util.Optional;

public class ReduceStreamService {

    public static Integer multiplyValuesOptional(List<Integer> list) {

        Integer result = null;
        Optional<Integer> productVal = list.stream().reduce((a, b) -> a * b);
        if (productVal.isPresent()) {
            result = productVal.get();
        }
        return result;

    }

    public static Integer multiplyValuesInt(List<Integer> list) {
        return list.stream().reduce(1, (a, b) -> a * b);
    }

    public static Integer multiplyValuesOnlyEven(List<Integer> list) {
        return list.stream().reduce(1, (a, b) -> {
                    if (b % 2 == 0) return a * b;
                    else return a;
                }
        );
    }
}
