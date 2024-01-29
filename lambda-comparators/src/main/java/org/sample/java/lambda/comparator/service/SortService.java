package org.sample.java.lambda.comparator.service;

import org.sample.java.lambda.comparator.domain.Developer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortService {

    public static void sortListBySalaryReversed(List<Developer> developerList) {
        //Comparator<Developer> salaryComparator = (o1, o2) -> o1.getSalary().compareTo(o2.getSalary());
        Comparator<Developer> salaryComparator = Comparator.comparing(Developer::getSalary);
        developerList.sort(salaryComparator.reversed());
    }

    public static void sortListByAge(List<Developer> developerList) {
        //developerList.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
        developerList.sort(Comparator.comparing(Developer::getAge));
    }

    public static void sortListBySalary(List<Developer> developerList) {
        //developerList.sort((o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
        developerList.sort(Comparator.comparing(Developer::getSalary));
    }

    public static void sortListByName(List<Developer> developerList) {
        //developerList.sort((Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName()));
        developerList.sort(Comparator.comparing(Developer::getName));
    }

    public static void sortListByAgeOldStyle(List<Developer> developerList) {
        Collections.sort(developerList, new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

}
