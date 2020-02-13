package com.marcusvmleite.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStreamSample {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world");
        stream.map(String::toUpperCase).forEach(System.out::println);
        Stream<Integer> empty = Stream.empty();

        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
    }

}
