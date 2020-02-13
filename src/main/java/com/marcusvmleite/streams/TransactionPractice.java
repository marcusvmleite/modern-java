package com.marcusvmleite.streams;

import com.marcusvmleite.model.ObjectUtil;
import com.marcusvmleite.model.Trader;
import com.marcusvmleite.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionPractice {

    public static void main(String[] args) {

        List<Transaction> transactions = ObjectUtil.getTransactions();

        List<Transaction> ex1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(ex1);

        List<String> ex2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ex2);

        List<Trader> ex3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(a -> a.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(ex3);

        String ex4 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));
                //.reduce("", (n1, n2) -> n1 + " " + n2);
        System.out.println(ex4);

        boolean ex5 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println(ex5);

        //ex6
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .forEach(System.out::println);

        Optional<Integer> ex7 = transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder());
        System.out.println(ex7);

        Optional<Transaction> ex8 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(ex8);
    }

}
