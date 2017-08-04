package org.sample.java.lambda.service;

import org.sample.java.lambda.domain.ValueClass;

public class ComparatorService {

    // A compare() method compatible with the one defined by Comparator<T>.
    public static int doCompare(ValueClass a, ValueClass b) {
        return a.getValue() - b.getValue();
    }

}
