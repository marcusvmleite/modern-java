package com.marcusvmleite.general;

import com.marcusvmleite.general.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorSample {

    public static void main(String[] args) {
        Apple apple1 = new Apple("red", true);
        Apple apple2 = new Apple("green", true);
        Apple apple3 = new Apple("red", false);
        Apple apple4 = new Apple("green", false);

        List<Apple> apples = Arrays.asList(apple1, apple2, apple3, apple4);

        //Phase 1
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        //Phase 2
        apples.sort((o1, o2) -> o1.getColor().compareTo(o2.getColor()));

        //Phase 3
        apples.sort(Comparator.comparing(Apple::getColor));
        apples.sort(Comparator.comparing(Apple::getColor).reversed().thenComparing(Apple::isRotten));
    }

}
