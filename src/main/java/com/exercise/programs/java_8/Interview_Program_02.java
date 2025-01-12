package com.exercise.programs.java_8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Interview_Program_02 {
    public static void main(String[] args) {
        List<String> lists = Arrays.asList("ajay", "aman", "sweet", "banana", "apple", "cat", "mat", "rat", "akshay", "nikh");
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : lists) {
            int len = s.length();
            if (map.containsKey(len)) {
                map.put(len, map.get(len) + 1);
            } else {
                map.put(len, 1);
            }
        }
        for (Integer i : map.keySet()){
            System.out.println("String by Length : "+ i + " Count : "+ map.get(i));
        }
        System.out.println("--------------------------------------------------");
        //java8
        Map<Integer, Long> countingByLength = lists.stream()
                //.peek(s -> {System.out.println(s);})
                .collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
        countingByLength.forEach((k, v) -> {
            System.out.println("String by length : " + k + " : Count : " + v);
        });
    }
}
