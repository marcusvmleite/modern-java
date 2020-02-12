package com.marcusvmleite.fundamentals;

import com.marcusvmleite.model.Apple;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionSample {

    private static Map<String, BiFunction<String, Boolean, Apple>> map = new HashMap<>();

    static {
        map.put("apple-id-1", Apple::new);
        map.put("apple-id-2", Apple::new);
        map.put("apple-id-3", Apple::new);
    }

    private Apple buildApple(String id, String color, boolean rotten) {
        return map.get(id).apply(color, rotten);
    }

    public static void main(String[] args) {
        BiFunction<String, Boolean, Apple> f1 = Apple::new;
        Apple apple = f1.apply("red", false);

        Function<Integer, Integer> f2 = a1 -> a1 * 2;
        Function<Integer, Integer> f3 = f2.andThen(a1 -> a1 * 3);
        System.out.println(f3.apply(1));

        IntFunction<Apple> apple2 = a1 -> a1 >= 0 ? new Apple() : null;
        System.out.println(apple2.apply(2));
    }

}
