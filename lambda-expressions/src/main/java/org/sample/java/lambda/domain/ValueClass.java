package org.sample.java.lambda.domain;

public class ValueClass {

    private int value;

    public ValueClass(int value) {
        this.value = value;
    }

    // The default constructor. This constructor is NOT used by this program.
//    public ValueClass() {
//        value = 0;
//    }

    public int getValue() {
        return value;
    }
}
