package org.sample.java.lambda;

import org.junit.jupiter.api.Test;
import org.sample.java.lambda.domain.HighTemperature;
import org.sample.java.lambda.function.HighTemperatureFunction;

public class HighTemperatureFunctionTest {

    // A method that returns the number of occurrences
    // of an object for which some criteria, as specified by
    // the MyFunc parameter, is true.
    private <T> int counter(T[] vals, HighTemperatureFunction<T> f, T v) {

        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (f.func(vals[i], v)) count++;
        }
        return count;
    }

    @Test
    public void highTemperaturTest() {
        int count;
        // Create an array of HighTemp objects.
        HighTemperature[] weekDayHighs = {new HighTemperature(89), new HighTemperature(82),
                new HighTemperature(90), new HighTemperature(89),
                new HighTemperature(89), new HighTemperature(91),
                new HighTemperature(84), new HighTemperature(83)};

        // Use counter() with arrays of the class HighTemp.
        // Notice that a reference to the instance method
        // sameTemp() is passed as the second argument.
        count = counter(weekDayHighs, HighTemperature::sameTemp, new HighTemperature(89));
        System.out.println(count + " days had a high of 89");

        // Now, create and use another array of HighTemp objects.
        HighTemperature[] weekDayHighs2 = {new HighTemperature(32), new HighTemperature(12),
                new HighTemperature(24), new HighTemperature(19),
                new HighTemperature(18), new HighTemperature(12),
                new HighTemperature(-1), new HighTemperature(13)};
        count = counter(weekDayHighs2, HighTemperature::sameTemp, new HighTemperature(12));
        System.out.println(count + " days had a high of 12");

        // Now, use lessThanTemp() to find days when temperature was less than a specified value.
        count = counter(weekDayHighs, HighTemperature::lessThanTemp, new HighTemperature(89));
        System.out.println(count + " days had a high less than 89");
        count = counter(weekDayHighs2, HighTemperature::lessThanTemp, new HighTemperature(19));
        System.out.println(count + " days had a high of less than 19");
    }
}
