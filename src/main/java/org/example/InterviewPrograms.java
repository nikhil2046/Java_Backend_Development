package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewPrograms {
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(12, 32, 43, 6, 78, 46, 34, 778, 97, 57, 6, 9, 54, 33, 54, 97);
        String testString = "JavaLProgrammingByNikhil";

        System.out.println("1. Given a list of integers, write a Java 8 program to separate the odd and even numbers into two separate lists.");
        Map<Boolean, List<Integer>> oddEvenNumbers = listOfInteger.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("Odd Numbers : " + oddEvenNumbers.get(false));
        System.out.println("Even Numbers : " + oddEvenNumbers.get(true));
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("2. Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions..");
        HashSet uniqueNum = new LinkedHashSet();
        List duplicates = listOfInteger.stream()
                .filter(num -> !uniqueNum.add(num)).toList();
        System.out.println("Duplicates : " + duplicates);
        System.out.println("After Removing duplicates : " + uniqueNum);

        List usingDistinct = listOfInteger.stream().distinct().toList();
        System.out.println("Using Distinct Functions : " + usingDistinct);
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("3. Write a Java 8 program to find the frequency of each character in a given string using the stream API and collectors..");

        Map<Character, Long> charFrequency = testString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        charFrequency.forEach((k, v) -> {
            System.out.println("Character : " + k + " - Count : " + v);
        });
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("4. Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.");
        Map<Integer, Long> elementFrequency = listOfInteger.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        elementFrequency.forEach((k, v) -> {
            System.out.println("Element : " + k + " - Count : " + v);
        });

    }
}
