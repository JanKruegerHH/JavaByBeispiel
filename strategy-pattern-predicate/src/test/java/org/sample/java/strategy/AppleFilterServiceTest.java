package org.sample.java.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sample.java.strategy.domain.Apple;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppleFilterServiceTest {

    @Test
    void testFilter() {

        List<Apple> appleList = AppleFactory.createAppleList();
        assertEquals(appleList.size(), 3);

        List<Apple> greenAppleList =
                AppleFilterService.filterAppleList(appleList, new AppleGreenColorPredicate());
        assertEquals(greenAppleList.size(), 1);

        assertEquals(greenAppleList.get(0).getColor(),"green");

    }

}
