package com.calculator;

class Product implements IProduct{
    public double add(double a, double b){ return a + b; }
    public double subs(double a, double b){ return a - b; }
    public double mult(double a, double b){ return a * b; }
    public double div(double a, double b)  throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        return a / b;
    }
}
