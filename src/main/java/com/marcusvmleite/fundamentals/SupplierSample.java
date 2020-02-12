package com.marcusvmleite.fundamentals;

import com.marcusvmleite.model.Apple;

import java.util.function.Supplier;

public class SupplierSample {

    public static void main(String[] args) {
        Supplier<Apple> sup1 = () -> new Apple("sa", false);
        Supplier<Apple> sup2 = Apple::new;
        Apple apple1 = sup1.get();
        Apple apple2 = sup2.get();
        System.out.println(apple1);
        System.out.println(apple2);
    }

}
