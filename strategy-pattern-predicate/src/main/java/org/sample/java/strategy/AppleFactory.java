package org.sample.java.strategy;


import org.sample.java.strategy.domain.Apple;

import java.util.ArrayList;
import java.util.List;

public class AppleFactory {

    public static List<Apple> createAppleList(){

        List<Apple> result = new ArrayList<>();

        result.add(new Apple(100,"red"));
        result.add(new Apple(200,"yellow"));
        result.add(new Apple(200,"green"));

        return result;
    }
}
