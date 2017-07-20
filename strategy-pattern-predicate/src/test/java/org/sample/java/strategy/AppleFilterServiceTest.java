package org.sample.java.strategy;

import org.junit.jupiter.api.Test;
import org.sample.java.strategy.domain.Apple;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppleFilterServiceTest {

    @Test
    void filterAppleGreenTest() {

        List<Apple> appleList = AppleFactory.createAppleList();
        assertEquals(appleList.size(), 3);

        List<Apple> greenAppleList =
                AppleFilterService.filterAppleList(appleList, new AppleGreenColorPredicate());

        assertEquals(greenAppleList.size(), 1);
        assertEquals("green", greenAppleList.get(0).getColor());

    }

    @Test
    void filterAppleHeavyTest() {

        List<Apple> appleList = AppleFactory.createAppleList();
        assertEquals(appleList.size(), 3);

        List<Apple> heavyWeightAppleList =
                AppleFilterService.filterAppleList(appleList, new AppleHeavyWeightPredicate());
        assertEquals(2, heavyWeightAppleList.size());

        assertTrue(heavyWeightAppleList.get(0).getWeight() > 150);

    }
}
