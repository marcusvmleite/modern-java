package com.marcusvmleite.streams;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecializedStreamSample {

    public static void main(String[] args) {

        List<Dish> dishes = ObjectUtil.getDishes();

        int totalCalories = dishes.stream().mapToInt(Dish::getCalories).sum();
        OptionalDouble avgCalories = dishes.stream().mapToDouble(Dish::getCalories).average();
        double avgCalories2 = dishes.stream().mapToDouble(Dish::getCalories).average().orElse(1D);

        System.out.println(totalCalories);
        System.out.println(avgCalories);
        System.out.println(avgCalories2);

        List<Integer> ints = IntStream.rangeClosed(1, 100)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);
    }

}
