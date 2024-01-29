package org.sample.java.streams.service;

import org.sample.java.streams.domain.Person;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * see https://dzone.com/articles/dipping-into-java-8-streams?edition=265888&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=dd%202017-01-29
 */
public class PersonStreamService {

    public static List<String> namesSortedByAge(List<Person> personList) {
        return personList.stream()
                .filter(p -> p.getAge() > 22)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                //.sorted((p1, p2) -> p1.getAge().compareTo(p2.getAge()))
                .map(Person::getName)
                .collect(toList());
    }

    public static int sumAges(List<Person> personList) {
        return personList.stream().mapToInt(Person::getAge).sum();
    }

    public static boolean allMatch(List<Person> personList, int matchValue) {
        return personList.parallelStream().allMatch(p -> p.getAge() > matchValue);
    }

    public static boolean noneMatch(List<Person> personList, int matchValue) {
        return personList.parallelStream().noneMatch(p -> p.getAge() > matchValue);
    }

    public static boolean anyMatch(List<Person> personList, int matchValue) {
        return personList.parallelStream().anyMatch(p -> p.getAge() > matchValue);
    }
}
