package org.sample.java.strategy;

import org.sample.java.strategy.domain.Apple;

import java.util.function.Predicate;

public class AppleGreenColorPredicate implements Predicate<Apple> {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }

}
