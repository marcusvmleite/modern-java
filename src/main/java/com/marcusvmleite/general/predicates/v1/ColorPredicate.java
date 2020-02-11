package com.marcusvmleite.general.predicates.v1;

import com.marcusvmleite.general.Apple;

public class ColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "red".equalsIgnoreCase(apple.getColor());
    }

}
