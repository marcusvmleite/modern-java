package com.marcusvmleite.streams;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;

import java.util.List;

public class StreamReduceSample {

    public static void main(String[] args) {
        List<Dish> dishes = ObjectUtil.getDishes();

        int result = dishes.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);

        System.out.println(result);
    }

}
