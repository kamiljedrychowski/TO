package com.calculator;

public interface ICalculatorApi {

    double add(double a, double b);
    double substract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b) throws IllegalArgumentException;
    double plugins(int n, double a, double... b) throws Exception;
}
