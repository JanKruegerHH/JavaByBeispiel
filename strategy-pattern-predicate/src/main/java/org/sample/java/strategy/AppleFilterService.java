package org.sample.java.strategy;

import org.sample.java.strategy.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFilterService {

    public static List<Apple> filterAppleList(List<Apple> appleList, ApplePredicate applePredicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : appleList) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }
}
