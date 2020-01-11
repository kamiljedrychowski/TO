package com.main;

import lombok.Getter;

class Result {
    @Getter
    private final int id;
    @Getter
    private final String functionName;
    @Getter
    private final double result;

    Result(int id, String functionName, double result) {
        this.id = id;
        this.functionName = functionName;
        this.result = result;
    }
}
