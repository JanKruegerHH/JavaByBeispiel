package org.sample.java.strategy.lambda;

import java.util.ArrayList;
import java.util.List;

public class FilterService {


auch ansehen:    https://dzone.com/articles/design-patterns-the-strategy-and-factory-patterns?edition=256684&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=dd%202016-12-20

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
