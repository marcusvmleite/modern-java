package com.marcusvmleite.parallelstreams;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class BasicParallelSample {

    static {
        //Manually setting the thread pool size used by parallelism.
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
    }

    private static long iterateOver(int n) {
        return Stream.iterate(1, i -> i + 1)
                .limit(n)
                .reduce(0, Integer::sum);
    }

    //ATTENTION!
    //iterate() is not a good approach for parallelism because the numbers have
    //to be unboxed before being added, what causes an overhead.
    //In that case the better choice is to use specialized streams!
    private static long iterateOverParallel(int n) {
        return Stream.iterate(1, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0, Integer::sum);
    }

    //rangeClosed() uses primitive types.
    private static long betterApproach(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(iterateOver(5));
        System.out.println(iterateOverParallel(5));
        System.out.println(betterApproach(5));
    }

}
