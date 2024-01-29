package org.sample.java.lambda.function;

@FunctionalInterface
public interface ArrayFunction<T> {

    int func(T[] vals, T v);

}
