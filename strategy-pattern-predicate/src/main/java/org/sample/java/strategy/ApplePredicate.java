package org.sample.java.strategy;

import org.sample.java.strategy.domain.Apple;

public interface ApplePredicate {

    boolean test(Apple apple);

}
