package org.sample.java.streams.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReduceStreamServiceTest {

    private List<Integer> createList() {
        // Create a list of Integer values.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        return list;
    }

    @Test
    public void multiplyValuesOptionalTest() {

        int product = ReduceStreamService.multiplyValuesOptional(createList());

        assertTrue(24 == product);
    }

    @Test
    public void multiplyValuesIntTest() {

        int product = ReduceStreamService.multiplyValuesInt(createList());

        assertTrue(24 == product);
    }

    @Test
    public void multiplyValuesOnlyEvenTest() {

        int product = ReduceStreamService.multiplyValuesOnlyEven(createList());

        assertTrue(8 == product);
    }

}