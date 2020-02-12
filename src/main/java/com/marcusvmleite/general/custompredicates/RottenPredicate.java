package com.marcusvmleite.general.custompredicates;

import com.marcusvmleite.general.Apple;

public class RottenPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.isRotten();
    }

}
