package org.sample.java.lambda.comparator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Developer {

    private String name;
    private BigDecimal salary;
    private int age;

}
