package org.sample.java.lambda.comparator.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.sample.java.lambda.comparator.domain.Developer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SortServiceTest {

    @Test
    public void sortListBySalaryReversed() {

        List<Developer> developerList = getDeveloperList();

        log.info("List unsorted:");
        developerList.forEach(developer -> log.info(developer.toString()));

        SortService.sortListBySalaryReversed(developerList);
        Assertions.assertTrue(developerList.get(0).getSalary().compareTo(new BigDecimal("170000")) == 0);
        Assertions.assertTrue(developerList.get(1).getSalary().compareTo(new BigDecimal("100000")) == 0);
        Assertions.assertTrue(developerList.get(2).getSalary().compareTo(new BigDecimal("80000")) == 0);
        Assertions.assertTrue(developerList.get(3).getSalary().compareTo(new BigDecimal("70000")) == 0);

        log.info("List sorted by Salary reversed:");
        developerList.forEach(developer -> log.info(developer.toString()));
    }

    @Test
    public void sortListByAge() {

        List<Developer> developerList = getDeveloperList();

        log.info("List unsorted:");
        developerList.forEach(developer -> log.info(developer.toString()));

        SortService.sortListByAge(developerList);
        Assertions.assertTrue(developerList.get(0).getAge() == 10);
        Assertions.assertTrue(developerList.get(1).getAge() == 20);
        Assertions.assertTrue(developerList.get(2).getAge() == 33);
        Assertions.assertTrue(developerList.get(3).getAge() == 55);

        log.info("List sorted by Age:");
        developerList.forEach(developer -> log.info(developer.toString()));
    }

    @Test
    public void sortListByName() {

        List<Developer> developerList = getDeveloperList();

        log.info("List unsorted:");
        developerList.forEach(developer -> log.info(developer.toString()));

        SortService.sortListByName(developerList);
        Assertions.assertTrue(developerList.get(0).getName().equals("alvin"));
        Assertions.assertTrue(developerList.get(1).getName().equals("iris"));
        Assertions.assertTrue(developerList.get(2).getName().equals("jason"));
        Assertions.assertTrue(developerList.get(3).getName().equals("mkyong"));

        log.info("List sorted by Name:");
        developerList.forEach(developer -> log.info(developer.toString()));
    }

    @Test
    public void sortListBySalary() {

        List<Developer> developerList = getDeveloperList();

        log.info("List unsorted:");
        developerList.forEach(developer -> log.info(developer.toString()));

        SortService.sortListBySalary(developerList);
        Assertions.assertTrue(developerList.get(0).getSalary().compareTo(new BigDecimal("70000")) == 0);
        Assertions.assertTrue(developerList.get(1).getSalary().compareTo(new BigDecimal("80000")) == 0);
        Assertions.assertTrue(developerList.get(2).getSalary().compareTo(new BigDecimal("100000")) == 0);
        Assertions.assertTrue(developerList.get(3).getSalary().compareTo(new BigDecimal("170000")) == 0);

        log.info("List sorted by Salary:");
        developerList.forEach(developer -> log.info(developer.toString()));
    }

    @Test
    public void sortListOldStyleTest() {

        List<Developer> developerList = getDeveloperList();

        log.info("List unsorted:");
        developerList.forEach(developer -> log.info(developer.toString()));

        SortService.sortListByAgeOldStyle(developerList);
        Assertions.assertTrue(developerList.get(0).getAge() == 10);

        log.info("List sorted by Age (old style):");
        developerList.forEach(developer -> log.info(developer.toString()));
    }

    private static List<Developer> getDeveloperList() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;
    }

}
