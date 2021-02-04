package org.sean.proxy;

public class Caculator implements ICaculator {
    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }
}
