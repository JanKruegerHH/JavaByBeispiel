package org.sample.java.lambda.function;

import java.util.Collection;

public interface CollectionFunction<T> {

    int func(Collection<T> list, T type);

}
