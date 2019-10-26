package com.lib.calculator;

import com.lib.i.calculator.ICalculator;

public class Calculator implements ICalculator {
    public double add(double a, double b) {
        return a+b;
    }

    public double subtract(double a, double b) {
        return a-b;
    }

    public double multiply(double a, double b) {
        return a*b;
    }

    public double divide(double a, double b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.err.println(e.toString());
            return 0;
        }
    }
}
