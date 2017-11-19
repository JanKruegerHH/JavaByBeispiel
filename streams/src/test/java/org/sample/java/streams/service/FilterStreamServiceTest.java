package org.sample.java.streams.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterStreamServiceTest {

    private List<Integer> createList() {
        // Create a list of Integer values.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(18);
        list.add(10);
        list.add(24);
        list.add(17);
        list.add(5);

        return list;
    }

    @Test
    public void getMinValueTest() {

        List<Integer> list = createList();
        Integer min = FilterStreamService.getMinValue(list.stream());

        assertTrue(5 == min);
    }

    @Test
    public void getMaxValueTest() {

        List<Integer> list = createList();
        Integer max = FilterStreamService.getMaxValue(list.stream());

        assertTrue(24 == max);
    }

    @Test
    public void getSortedListTest() {

        List<Integer> list = createList();

        List<Integer> sortedList = FilterStreamService.getSortedList(list);

        assertTrue(5 == sortedList.get(0));
        assertTrue(24 == sortedList.get(5));
    }

    @Test
    public void getOddValueListTest() {

        List<Integer> list = createList();

        List<Integer> sortedList = FilterStreamService.getOddValueList(list);

        assertTrue(5 == sortedList.get(0));
        assertTrue(17 == sortedList.get(2));
        assertTrue(3 == sortedList.size());
    }

    @Test
    public void getOddValueGreaterFiveListTest() {

        List<Integer> list = createList();

        List<Integer> sortedList = FilterStreamService.getOddValueGreaterList(list, 5);

        assertTrue(7 == sortedList.get(0));
        assertTrue(17 == sortedList.get(1));
        assertTrue(2 == sortedList.size());
    }

    @Test
    public void getOddValueGreaterFourListTest() {

        List<Integer> list = createList();

        List<Integer> sortedList = FilterStreamService.getOddValueGreaterList(list, 4);

        assertTrue(5 == sortedList.get(0));
        assertTrue(17 == sortedList.get(2));
        assertTrue(3 == sortedList.size());
    }
}
