package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;
import com.marcusvmleite.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningSample {

    public static void main(String[] args) {
        List<Transaction> transactions = ObjectUtil.getTransactions();
        List<Dish> dishes = ObjectUtil.getDishes();

        String result1 = dishes.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(result1);

        String result2 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println(result2);
    }

}
