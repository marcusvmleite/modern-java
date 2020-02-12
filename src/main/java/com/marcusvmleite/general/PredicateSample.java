package com.marcusvmleite.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateSample {

    public static void main(String[] args) {

        PredicateSample sp = new PredicateSample();

        Apple red = new Apple("red", false);
        Apple green = new Apple("green", false);
        List<Apple> apples = Arrays.asList(red, green);

        List<Apple> result = sp.apply(apples, PredicateSample::isRed);

        System.out.println(result);

        Predicate<Apple> predicate = Apple::isRotten;
        Predicate<Apple> composedNegate = predicate.negate();
        Predicate<Apple> composed2 = predicate.and(a -> "red".equalsIgnoreCase(a.getColor()));
        System.out.println(composed2.test(red));
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
