package org.example;

import org.javamoney.moneta.Money;


public class Percentage {

    public static final Percentage ZERO = new Percentage(0);
    public static final Percentage ONE_HUNDRED = new Percentage(100);

    private final double value;

    private Percentage(double value) {
        this.value = value;
    }

    public Percentage getInstanceOf (double value) {
        return new Percentage(value);
    }

    public boolean isLessThan(Percentage other) {
        return this.value < other.value;
    }

    public boolean isGreaterThan(Percentage other) {
        return this.value > other.value;
    }


}
