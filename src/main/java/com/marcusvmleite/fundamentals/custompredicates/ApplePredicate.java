package com.marcusvmleite.fundamentals.custompredicates;

import com.marcusvmleite.model.Apple;

@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple);

    default int test() {
        return 0;
    }

}
