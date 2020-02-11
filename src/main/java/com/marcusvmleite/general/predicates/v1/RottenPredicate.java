package com.marcusvmleite.general.predicates.v1;

import com.marcusvmleite.general.Apple;

public class RottenPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.isRotten();
    }

}
