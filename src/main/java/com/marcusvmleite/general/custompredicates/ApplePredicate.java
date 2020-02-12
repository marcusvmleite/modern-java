package com.marcusvmleite.general.custompredicates;

import com.marcusvmleite.general.Apple;

@FunctionalInterface
public interface ApplePredicate {

    boolean test(Apple apple);

    default int test() {
        return 0;
    }

}
