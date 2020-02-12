package com.marcusvmleite.fundamentals;

import com.marcusvmleite.model.Apple;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class Operators {

    public static void main(String[] args) {

        IntUnaryOperator iuo = a -> a * 2;
        IntBinaryOperator ibo1 = Integer::sum;
        IntBinaryOperator ibo2 = (a, b) -> a * b;

        IntPredicate ip = a -> a >= 0;
        IntPredicate ipAnd = ip.and((a) -> a <= 100);

        IntFunction<Apple> intFunc = a -> a >= 0 ? new Apple("red", true) :
                new Apple("green", false);
    }

}
