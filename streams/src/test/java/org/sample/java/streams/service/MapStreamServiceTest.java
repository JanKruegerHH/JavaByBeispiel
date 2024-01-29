package org.sample.java.streams.service;

import org.junit.jupiter.api.Test;
import org.sample.java.streams.domain.NamePhone;
import org.sample.java.streams.domain.NamePhoneEmail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapStreamServiceTest {

    private List<NamePhoneEmail> createList() {

        ArrayList<NamePhoneEmail> list = new ArrayList<>();
        list.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
        list.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
        list.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));

        return list;
    }

    @Test
    public void mapTest() {

        MapStreamService mapStreamService = new MapStreamService();

        mapStreamService.logoutStreamNamePhoneEmail(createList().stream());
        Stream<NamePhone> namePhoneStream = mapStreamService.map(createList().stream());
        mapStreamService.logoutStreamNamePhone(namePhoneStream);
    }

    @Test
    public void mapAndFilterTest() {

        MapStreamService mapStreamService = new MapStreamService();

        mapStreamService.logoutStreamNamePhoneEmail(createList().stream());
        Stream<NamePhone> namePhoneStream = mapStreamService.mapAndFilter(createList().stream());
        mapStreamService.logoutStreamNamePhone(namePhoneStream);
    }
}
