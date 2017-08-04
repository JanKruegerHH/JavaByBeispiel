package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.domain.ValueClass;
import org.sample.java.lambda.service.ComparatorService;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorFunctionTest {

    @Test
    public void compareTest() {

        ArrayList<ValueClass> al = new ArrayList<>();
        al.add(new ValueClass(1));
        al.add(new ValueClass(4));
        al.add(new ValueClass(2));
        al.add(new ValueClass(9));
        al.add(new ValueClass(3));
        al.add(new ValueClass(7));

        // Find the maximum value in al using the compareMC() method.
        ValueClass maxValObj = Collections.max(al, ComparatorService::doCompare);
        System.out.println("Maximum value is: " + maxValObj.getValue());

    }
}
