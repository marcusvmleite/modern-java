package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class PartitioningSample {

    public static void main(String[] args) {

        List<Dish> dishes = ObjectUtil.getDishes();

        Map<Boolean, List<Dish>> dishesVeg = dishes.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(dishesVeg);
    }

}
