package org.example.programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewPrograms {
    public static void main(String[] args) {
        List<Integer> listOfInteger = Arrays.asList(12, 32, 43, 6, 78, 46, 34, 778, 97, 57, 6, 9, 54, 33, 54, 97);
        List<Integer> listOfInteger2 = Arrays.asList(13 ,53,65,75,33,7,89,00,44,24,55);
        int[] array1=new int[]{12, 32, 43, 6, 78, 46, 34, 778, 97, 57, 6, 9, 54, 33, 54, 97};
        int[] array2=new int[]{13 ,53,65,75,33,7,89,00,44,24,55};
        Integer[] arr3 =new Integer[]{12,21,43};
        List<Double> listOfDecimal = Arrays.asList(1.2, 3.2, 4.3, 6.99, 79.8, 46.7, 34.56, 7.78, 0.97, 5.97, 0.86, 9.777, 5.4, 3.3, 5.4, 97.0);
        String testString = "JavaLProgrammingByNikhil";
        List<String> listOfString = Arrays.asList("Mother's","Love","and","care","is","essential","for","babies");

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
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("5. Write a Java 8 program to sort a given list of decimal numbers in reverse order.");
        System.out.println("Sorted decimal numbers in reverse order : \n"+listOfDecimal.stream()
                .sorted(Comparator.reverseOrder()).toList());
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("6. Given a list of strings, write a Java 8 program to join the strings with '[' as a prefix, ']' as a suffix, and ',' as a delimiter..");
        String newJoinString = listOfString.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(newJoinString);
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("7. Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.");
        System.out.println("OriginalNumber : "+listOfInteger);
        System.out.println("Multiple by 5 : "+ listOfInteger.stream()
                .map(num -> num * 5)
                .toList());
        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("8. Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.");
        Optional<Integer> minValue = listOfInteger.stream()
                .min(Integer::compareTo);
        Optional<Integer> maxValue = listOfInteger.stream()
                .max(Integer::compareTo);
        System.out.println("Max Value : "+(maxValue.isPresent() ? maxValue.get() : "No Max Number Present")+" Min Value : "+(minValue.isPresent() ? minValue.get() : "No Min Value Present"));

        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("9. Write a Java 8 program to merge two unsorted arrays into a single sorted array using the stream API.");
        System.out.println("merge two unsorted arrays : "+Stream.concat(Arrays.stream(array1).boxed(), Arrays.stream(array2).boxed())
                .sorted().toList());

        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("10. Write a Java 8 program to merge two unsorted arrays into a single sorted array without duplicates.");
        System.out.println("merge two unsorted arrays without duplicates : "+Stream.concat(Arrays.stream(array1).boxed(), Arrays.stream(array2).boxed())
                .sorted().distinct().toList());

        System.out.println("-----------------------------------------------------------------------------------");

        System.out.println("11. Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers..");
        System.out.println("List of three maximus number : "+listOfInteger.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(3)
                .toList());
        System.out.println("List of three Minimum number : "+listOfInteger.stream()
                .sorted()
                .distinct()
                .limit(3)
                .toList());


        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("12. Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.");
        isAnagram("silent","");

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("13. Write a Java 8 program to find the sum of all digits of a given number.");
        System.out.println("Sum of all digit : "+listOfInteger.stream().reduce(0, Integer::sum)
                .intValue());


        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("14. Write a Java 8 program to find the second-largest number in an integer array..");
        System.out.println("Second largest number : "+listOfInteger
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .get());

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("15. Write a Java 8 program to sort a given list of strings according to the increasing order of their length.");
        System.out.println(listOfString.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList());


        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("16. Write a Java 8 program to find the sum and average of all elements in an integer array.");
        int sumOfInteger = Arrays.stream(arr3).reduce(0,Integer::sum);
        double avgOfInteger = Arrays.stream(array2).average().getAsDouble();
        System.out.println("SUm of Integer object : "+sumOfInteger + "\n Average : "+avgOfInteger);

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("17. Write a Java 8 program to find the common elements between two arrays using streams.");
        List<Integer> list1 = Arrays.stream(array1).boxed().toList();
        List<Integer> list2 = Arrays.stream(array2).boxed().toList();

        Set commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toSet());
        System.out.println(commonElements);
    }




















    static boolean isAnagram(String str1, String str2){
        if (str1.isEmpty() || str2.isEmpty()){
            System.out.println("String is Empty, Please provide non-empty String");
            return false;
        }
        if (str1.length()!=str2.length()){
            System.out.println("Both String is not valid in length..!");
            return false;
        }
        List<Character> ch1 = str1.chars().mapToObj(c->(char)c).sorted().toList();
        List<Character> ch2 = str2.chars().mapToObj(c->(char)c).sorted().toList();
        if (ch1.equals(ch2)){
            System.out.println("Yes, it is anagram.!");
            return true;
        }
        System.out.println("No anagram found");
        return false;
    }
}
