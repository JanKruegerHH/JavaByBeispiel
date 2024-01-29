package org.sample.java.strategy;

import org.sample.java.strategy.domain.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface AppleFilterService {

    static List<Apple> filterAppleList(List<Apple> appleList, Predicate<Apple> predicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
