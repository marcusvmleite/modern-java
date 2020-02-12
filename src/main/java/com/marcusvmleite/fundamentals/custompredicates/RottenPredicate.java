package com.marcusvmleite.fundamentals.custompredicates;

import com.marcusvmleite.model.Apple;

public class RottenPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.isRotten();
    }

}
