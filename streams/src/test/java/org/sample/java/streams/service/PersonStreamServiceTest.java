package org.sample.java.streams.service;

import org.junit.jupiter.api.Test;
import org.sample.java.streams.domain.Person;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonStreamServiceTest {

    private List<Person> createList() {
        return Arrays.asList(
                new Person("Dan", 23),
                new Person("Laura", 22),
                new Person("Billy", 50),
                new Person("George", 21));
    }

    @Test
    public void namesSortedByAgeTest() {

        List<String> nameList = PersonStreamService.namesSortedByAge(createList());

        assertTrue(2 == nameList.size());
        assertTrue("Billy".equals(nameList.get(0)));
        assertTrue("Dan".equals(nameList.get(1)));
    }

    @Test
    public void sumAgesTest() {
        int sum = PersonStreamService.sumAges(createList());
        assertTrue(116 == sum);
    }

    @Test
    public void allMatchTest() {
        boolean allMatchGreater20 = PersonStreamService.allMatch(createList(), 20);
        assertTrue(allMatchGreater20);

        boolean allMatchGreater21 = PersonStreamService.allMatch(createList(), 21);
        assertFalse(allMatchGreater21);
    }

    @Test
    public void noneMatchTest() {
        boolean noneMatchGreater50 = PersonStreamService.noneMatch(createList(), 50);
        assertTrue(noneMatchGreater50);

        boolean noneMatchGreater49 = PersonStreamService.noneMatch(createList(), 49);
        assertFalse(noneMatchGreater49);
    }

    @Test
    public void anyMatchTest() {
        boolean anyMatchGreater20 = PersonStreamService.anyMatch(createList(), 20);
        assertTrue(anyMatchGreater20);

        boolean anyMatchGreater50 = PersonStreamService.anyMatch(createList(), 50);
        assertFalse(anyMatchGreater50);
    }
}
