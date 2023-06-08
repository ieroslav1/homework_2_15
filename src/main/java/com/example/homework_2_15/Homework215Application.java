package com.example.homework_2_15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Homework215Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework215Application.class, args);

            IntegerListImpl list = new IntegerListImpl();
            for (int i = 0; i < 100000; i++) {
                list.add((int) (Math.random() * 100000));
            }

            Integer[] arr1 = list.toArray();
            Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
            Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

            long start1 = System.currentTimeMillis();
            Arrays.sort(arr1);
            System.out.println("Arrays.sort() Time: " + (System.currentTimeMillis() - start1) + " ms");

            long start2 = System.currentTimeMillis();
            list.quickSort(arr2, 0, arr2.length - 1);
            System.out.println("QuickSort Time: " + (System.currentTimeMillis() - start2) + " ms");

            long start3 = System.currentTimeMillis();
            Arrays.parallelSort(arr3);
            System.out.println("Arrays.parallelSort() Time: " + (System.currentTimeMillis() - start3) + " ms");
        }
    }

