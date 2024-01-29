package org.sample.java.lambda.domain;

/**
 * Class which holds the temperature high for a day.
 */
public class HighTemperature {

    private int value;

    public HighTemperature(int ht) {
        value = ht;
    }

    // Return true if the invoking HighTemp object has the same temperature as ht2.
    public boolean sameTemp(HighTemperature ht2) {
        return value == ht2.value;
    }

    // Return true if the invoking HighTemp object has a temperature that is less than ht2.
    public boolean lessThanTemp(HighTemperature ht2) {
        return value < ht2.value;
    }
}
