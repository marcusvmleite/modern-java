package com.marcusvmleite.streams;

import com.marcusvmleite.model.Apple;
import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamSample {

    public static void main(String[] args) {

        List<Apple> apples = ObjectUtil.getApples();
        List<Dish> dishes = ObjectUtil.getDishes();

        List<String> coloursList = apples.stream()
                .filter(Apple::isRotten)
                .map(Apple::getColor)
                .limit(10)
                .skip(2)
                .collect(Collectors.toList());

        //Let's print step-by-step to understand what is happening
        List<String> dishesPrinted = dishes.stream()
                .filter(dish -> {
                        System.out.println("filtering: " + dish.getName());
                        return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(2)
                .collect(Collectors.toList());

        Map<String, List<Apple>> coloursMap = apples.stream()
                .collect(Collectors.groupingBy(Apple::getColor));

        System.out.println(coloursList);
        System.out.println(coloursMap);

        //We can create our standalone predicates and apply then later too
        Predicate<Dish> predicate = dish -> dish.isVegetarian() && dish.getCalories() > 300;
        List<Dish> dishesFromPredicate = dishes.stream()
                .filter(predicate)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(dishesFromPredicate);

        //Now with forEach as Terminal operation
        dishes.stream().filter(predicate).distinct().forEach(System.out::println);

        //Now some flatMap
        List<String> words = Arrays.asList("hello", "world");
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueCharacters);

        System.out.println(dishes.stream().anyMatch(Dish::isVegetarian));
        System.out.println(dishes.stream().allMatch(Dish::isVegetarian));
        System.out.println(dishes.stream().noneMatch(Dish::isVegetarian));

        dishes.stream().filter(Dish::isVegetarian).findAny().orElseThrow(() -> new RuntimeException("vish!"));
    }

}
