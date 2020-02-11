package com.marcusvmleite.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SimplePredicate {

    public static void main(String[] args) {

        SimplePredicate sp = new SimplePredicate();

        Apple red = new Apple("red");
        Apple green = new Apple("green");
        List<Apple> apples = Arrays.asList(red, green);

        List<Apple> result = sp.apply(apples, SimplePredicate::isRed);

        System.out.println(result);
    }

    public List<Apple> apply(List<Apple> apples,
                      Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    private static boolean isRed(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor());
    }

}
