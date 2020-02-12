package com.marcusvmleite.fundamentals.custompredicates;

import com.marcusvmleite.fundamentals.Apple;

public class RottenPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.isRotten();
    }

}
