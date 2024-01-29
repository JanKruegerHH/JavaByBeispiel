package org.sample.java.streams.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FilterStreamService {


    public static Integer getMinValue(Stream<Integer> stream) {

        Integer result = null;
        Optional<Integer> minVal = stream.min(Integer::compare);
        if (minVal.isPresent()) {
            result = minVal.get();
            log.debug("Minimum value {}", minVal.get());
        }
        return result;
    }

    public static Integer getMaxValue(Stream<Integer> stream) {

        Integer result = null;
        Optional<Integer> maxVal = stream.max(Integer::compare);
        if (maxVal.isPresent()) {
            result = maxVal.get();
            log.debug("Maximum value {}", maxVal.get());
        }
        return result;
    }

    public static List<Integer> getSortedList(List<Integer> unsortedList) {
        return unsortedList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> getOddValueList(List<Integer> list) {
        return list.stream()
                .sorted()
                .filter((n) -> (n % 2) == 1)
                .collect(Collectors.toCollection(ArrayList::new));
        //.collect(Collectors.toList());
    }

    public static List<Integer> getOddValueGreaterList(List<Integer> list, int value) {
        return list.stream()
                .sorted()
                .filter((n) -> (n % 2) == 1)
                .filter((n) -> n > value)
                .collect(Collectors.toCollection(ArrayList::new));
        //.collect(Collectors.toList());
    }

}
