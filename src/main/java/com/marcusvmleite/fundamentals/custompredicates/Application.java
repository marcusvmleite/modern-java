package com.marcusvmleite.fundamentals.custompredicates;

import com.marcusvmleite.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Application {

    public static void main(String[] args) {
        Apple apple1 = new Apple("red", true);
        Apple apple2 = new Apple("green", true);
        Apple apple3 = new Apple("red", false);
        Apple apple4 = new Apple("green", false);

        List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);

        Application application = new Application();

        List<Apple> resultRotten = application.filter(apples, new RottenPredicate());
        List<Apple> resultColor = application.filter(apples, new ColorPredicate());
        List<Apple> resultAnonymous = application.filter(apples, apple -> apple.isRotten() &&
                "red".equalsIgnoreCase(apple.getColor()));

        System.out.println(resultRotten);
        System.out.println(resultColor);
        System.out.println(resultAnonymous);
    }

    private List<Apple> filter(List<Apple> apples,
                               ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filterGeneric(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

}
