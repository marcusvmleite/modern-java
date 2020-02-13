package com.marcusvmleite.collectors;

import com.marcusvmleite.model.Dish;
import com.marcusvmleite.model.ObjectUtil;
import com.marcusvmleite.model.Transaction;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsSample {

    public static void main(String[] args) {

        List<Transaction> transactions = ObjectUtil.getTransactions();
        List<Dish> dishes = ObjectUtil.getDishes();

        IntSummaryStatistics iss = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(iss);

        IntSummaryStatistics isst = transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue));
        System.out.println(isst);
    }

}
