package com.marcusvmleite.fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderSample {

    public static void main(String[] args) throws IOException {
        BufferedReaderSample sample = new BufferedReaderSample();
        BufferedReaderProcessor bpr = (BufferedReader br) -> br.readLine() + " " + br.readLine();
        System.out.println(sample.processFile());
        System.out.println(sample.processFile(bpr));
    }

    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            return br.readLine();
        }
    }

    public String processFile(BufferedReaderProcessor brp) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            return brp.process(br);
        }
    }

    interface BufferedReaderProcessor {

        String process(BufferedReader br) throws IOException;

    }

}
