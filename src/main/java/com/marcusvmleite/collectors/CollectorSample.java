package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;
import com.marcusvmleite.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorSample {

    public static void main(String[] args) {

        List<Transaction> transactions = ObjectUtil.getTransactions();
        List<Dish> dishes = ObjectUtil.getDishes();

        Map<Integer, List<Transaction>> map = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getValue));
        System.out.println(map);

        long count1 = transactions.stream().filter(t -> t.getValue() > 10).count();
        long count2 = transactions.stream().filter(t -> t.getValue() > 10).collect(Collectors.counting());
        System.out.println(count1 + " " + count2);

        Optional<Dish> optDish1 = dishes.stream().max(Comparator.comparing(Dish::getCalories));
        Optional<Dish> optDish2 = dishes.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        System.out.println(optDish1 + " " + optDish2);

        int totalCalories1 = dishes.stream().mapToInt(Dish::getCalories).sum();
        int totalCalories2 = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories1 + " " + totalCalories2);

        OptionalDouble avgCalories1 = dishes.stream().mapToDouble(Dish::getCalories).average();
        double avgCalories2 = dishes.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println(avgCalories1 + " " + avgCalories2);
    }

}
