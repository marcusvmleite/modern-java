package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupingSample {

    public static void main(String[] args) {

        List<Dish> dishes = ObjectUtil.getDishes();

        Map<Dish.Type, List<Dish>> dishesByType = dishes.stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCal = dishes.stream()
                .collect(groupingBy(dish -> {
                    if (dish.getCalories() <= 300) {
                        return CaloricLevel.LOW;
                    } else if (dish.getCalories() <= 600) {
                        return CaloricLevel.MEDIUM;
                    }
                    return CaloricLevel.HIGH;
                }));
        System.out.println(dishesByCal);

        //2 approaches for filtering a grouping; the first one will
        //ignore keys that has no results. Second approach is Java 9.
        Map<Dish.Type, List<Dish>> dishesByTypeFiltered1 = dishes.stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        /*Map<Dish.Type, List<Dish>> caloricDishesByType = dishes.stream()
                        .collect(groupingBy(Dish::getType,
                                Collectors.filtering(dish -> dish.getCalories() > 500, toList())));*/
        System.out.println(dishesByTypeFiltered1);

        //We can manipulate the grouping result
        Map<Dish.Type, List<String>> dishesTypeName = dishes.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        System.out.println(dishesTypeName);

        /*Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));*/

        //Java 9 flatMapping
        /*Map<Dish.Type, Set<String>> dishNamesByType = dishes.stream()
                        .collect(groupingBy(Dish::getType,
                                flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));*/

        Map<Dish.Type, Long> countingGroups = dishes.stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(countingGroups);

        Map<Dish.Type, Optional<Dish>> opt = dishes.stream()
            .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println(opt);

        Map<Dish.Type, Dish> mostCaloricByType = dishes.stream()
                        .collect(groupingBy(Dish::getType, collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        Map<Dish.Type, Integer> totalCaloriesByType = dishes.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = dishes.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.LOW;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.MEDIUM;
                                    else return CaloricLevel.HIGH; },
                                toSet() )));

        System.out.println(mostCaloricByType);
        System.out.println(totalCaloriesByType);
        System.out.println(caloricLevelsByType);
    }

    private enum CaloricLevel {
        LOW, MEDIUM, HIGH
    }

}
