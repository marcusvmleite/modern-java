package com.marcusvmleite.fundamentals.custompredicates;

import com.marcusvmleite.model.Apple;

public class ColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor());
    }

}
