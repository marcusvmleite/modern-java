package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class MultiLevelGroupingSample {

    public static void main(String[] args) {

        List<Dish> dishes = ObjectUtil.getDishes();

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> multiLevel = dishes.stream()
                .collect(groupingBy(Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 300) {
                        return CaloricLevel.LOW;
                    } else if (dish.getCalories() <= 600) {
                        return CaloricLevel.MEDIUM;
                    }
                    return CaloricLevel.HIGH;
                })));
        System.out.println(multiLevel);
    }

    private enum CaloricLevel {
        LOW, MEDIUM, HIGH
    }

}
