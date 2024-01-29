package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.function.CollectionFunction;
import org.sample.java.lambda.service.CollectionService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionFunctionTest {

    static <T> int doCount(CollectionFunction<T> f, Collection<T> collection, T type) {
        return f.func(collection, type);
    }

    @Test
    public void arrayFunctionTest() {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 4);
        List<String> stringList = Arrays.asList("One", "Two", "Three", "Two");

        int count;

        count = doCount(CollectionService::<Integer>countMatching, intList, 4);
        System.out.println("intList contains " + count + " 4s");

        count = doCount(CollectionService::<String>countMatching, stringList, "Two");
        System.out.println("stringList contains " + count + " Twos");
    }

}
