package com.marcusvmleite.streams;

import java.util.stream.Stream;

public class InfiniteStreamSample {

    public static void main(String[] args) {
        Stream.iterate(0, i -> i + 1).limit(100).forEach(System.out::println);

        //Fibonacci
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
