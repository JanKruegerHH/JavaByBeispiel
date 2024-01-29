package org.sample.java.lambda.service;

import java.util.Collection;

public class CollectionService {

    public static <T> int countMatching(Collection<T> collection, T type) {
        int count = 0;

        for (T t : collection) {
            if (t == type) {
                count++;
            }
        }
        return count;
    }

}
