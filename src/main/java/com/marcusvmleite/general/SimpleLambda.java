package com.marcusvmleite.general;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleLambda {

    public static void main(String[] args) {

        SimplePredicate sp = new SimplePredicate();

        Apple red = new Apple("red");
        Apple green = new Apple("green");
        List<Apple> apples = Arrays.asList(red, green);

        List<Apple> result1 = sp.apply(apples, apple -> "red".equalsIgnoreCase(apple.getColor()));

        List<Apple> result2 = apples.stream().filter(apple -> "green".equalsIgnoreCase(apple.getColor()))
                .collect(Collectors.toList());

        Map<String, List<Apple>> result3 = apples.stream().filter(apple -> "green".equalsIgnoreCase(apple.getColor()))
                .collect(Collectors.groupingBy(Apple::getColor));

        Map<String, List<Apple>> result4 = apples.parallelStream().filter(apple -> "green".equalsIgnoreCase(apple.getColor()))
                .collect(Collectors.groupingBy(Apple::getColor));

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

}
