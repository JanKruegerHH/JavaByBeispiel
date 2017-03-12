package org.sample.java.strategy.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilterService {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
