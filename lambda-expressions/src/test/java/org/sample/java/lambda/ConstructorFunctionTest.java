package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.domain.GenericValueClass;
import org.sample.java.lambda.domain.ValueClass;
import org.sample.java.lambda.function.ConstructorFunction;
import org.sample.java.lambda.service.ConstructorService;

public class ConstructorFunctionTest {

    // this test shows the constructor reference of lambda
    @Test
    public void constructorFunctionTest() {

        // Create a reference to a GenericValueClass constructor.
        // In this case, new refers to the constructor that takes an argument.
        ConstructorFunction<GenericValueClass<Double>, Double> genericValueClassConstructor = GenericValueClass<Double>::new;

        // Create an instance of GenericValueClass by use of the factory method.
        GenericValueClass<Double> genericValueClass = ConstructorService.create(genericValueClassConstructor, 100.1);
        // Use the instance of MyClass just created.
        System.out.println("Double in genericValueClass is " + genericValueClass.getValue());

        // Now, create a different class.
        ConstructorFunction<ValueClass, Integer> valueClassConstructor = ValueClass::new;
        // Create an instance of ValueClass by use of the factory method.
        ValueClass valueClass = ConstructorService.create(valueClassConstructor, 2);

        // Use the instance of MyClass just created.
        System.out.println("Int in valueClass is " + valueClass.getValue());

    }
}