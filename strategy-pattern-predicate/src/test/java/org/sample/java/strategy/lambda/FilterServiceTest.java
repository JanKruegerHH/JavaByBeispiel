package org.sample.java.strategy.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.strategy.AppleFactory;
import org.sample.java.strategy.domain.Apple;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterServiceTest {

    @Test
    void testFilterAppleGreen() {

        List<Apple> appleList = AppleFactory.createAppleList();
        assertEquals(appleList.size(), 3);

        List<Apple> greenAppleList =
                FilterService.filter(appleList, (Apple apple) -> "green".equals(apple.getColor()));

        assertEquals(greenAppleList.size(), 1);
        assertEquals("green", greenAppleList.get(0).getColor());
    }

    @Test
    void sortList() {

        List<Apple> appleList = AppleFactory.createAppleList();

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }

        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        for (Apple apple : appleList) {
            System.out.println(apple.toString());
        }
    }
}
