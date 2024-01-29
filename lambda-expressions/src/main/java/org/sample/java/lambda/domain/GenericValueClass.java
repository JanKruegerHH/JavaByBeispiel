package org.sample.java.lambda.domain;

public class GenericValueClass<T> {

    private T value;

    // A constructor that takes an argument.
    public GenericValueClass(T v) {
        value = v;
    }

    // The default constructor. This constructor is NOT used by this program.
//    public GenericValueClass() {
//        value = null;
//    }

    public T getValue() {
        return value;
    }

}
