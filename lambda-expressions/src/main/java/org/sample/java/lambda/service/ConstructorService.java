package org.sample.java.lambda.service;

import org.sample.java.lambda.function.ConstructorFunction;

public class ConstructorService {

    // A factory method for class objects. The class must
    // have a constructor that takes one parameter of type T.
    // R specifies the type of object being created.
    public static <R, T> R create(ConstructorFunction<R, T> constructorFunction, T type) {
        return constructorFunction.func(type);
    }

}
