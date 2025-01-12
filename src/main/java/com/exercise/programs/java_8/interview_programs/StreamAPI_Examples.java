package com.exercise.programs.java_8.interview_programs;

import com.exercise.programs.datahub.EmployeeDataHub;
import com.exercise.programs.java_8.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI_Examples {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataHub.getEmployees();
        List<Integer> listOfInteger = Arrays.asList(12, 32, 43, 6, 78, 46, 34, 778, 97, 57, 6, 9, 54, 33, 54, 97, 13, 119, 155, 16, 175, 617, 111);
        List<String> stringList = Arrays.asList("Hello", "This", "Is", "Nikhil", "Raut", "here.!");

        System.out.println("Q1. How many male and female employees are there in the organization ?\n");
        test_HowManyMaleFemaleEmployeeInTheOrganization(employees);
        System.out.println("------------------------------------------------");

        System.out.println("Q2. What is the average salary of male or female employee\n");
        test_FindaverageSalaryOfMaleFemaleEployee(employees);
        System.out.println("------------------------------------------------");

        System.out.println("Q3. Find sum of even numbers and sum of odd numbers in a given list ?\n");
        test_FindSumOfEvenNumberAndOddNumber(listOfInteger);
        System.out.println("------------------------------------------------");

        System.out.println("Q4. Find duplicate elements in a given integers list ?\n");
        test_FindDuplicatesFromGivenIntegerList(listOfInteger);
        System.out.println("------------------------------------------------");

        System.out.println("Q5. Remove all occourance from given string\n");
        test_removeAllOccourenceFromGivenString("Java Interview amar", 'a');
        System.out.println("------------------------------------------------");

        System.out.println("Q6. Find special character from given string\n");
        test_findSpecialCharactersFromGivenString("Hello@123#FromTetig$*enen%");
        System.out.println("------------------------------------------------");

        System.out.println("Q7. Find out all the numbers starting with 1 from a integer list ?\n");
        test_findAllNumberWhosestartWith_1(listOfInteger);
        System.out.println("------------------------------------------------");

        System.out.println("Q7. Find out all the numbers starting with 1 from a integer list ?\n");
        test_findAllNumberWhosestartWith_1(listOfInteger);
        System.out.println("------------------------------------------------");
        System.out.println("Q7. Find the employee with the highest salary from a list of employee objects ?n");
        test_findHighestSalariedEmployee(employees);
        System.out.println("------------------------------------------------");
        System.out.println("Q8. Concatenate a list of strings into a single string, separated by commas ?");
        test_concatListOfString(stringList);
        System.out.println("------------------------------------------------");
        System.out.println("Q9. Find the first non-repeating character in a string ?");
        test_findFirstNonRepeatingCharacters("JavaLearningWithNikhil");
        System.out.println("------------------------------------------------");
        System.out.println("Q10. Find frequency of characters of a given string ?");
        test_findFrequencyOfCharacterOfGivenString("frquncyofgivenstring");



    }

    private static void test_findFrequencyOfCharacterOfGivenString(String str) {
        System.out.println(str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


    }

    private static void test_findFirstNonRepeatingCharacters(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        str.chars()
                .mapToObj(c -> (char) c)
                .forEach(
                        cc -> map.put(cc, map.getOrDefault(cc, 0) + 1));
        Character firstNnRptStr = map.entrySet().stream()
                .filter(k -> k.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(firstNnRptStr);

        //by using grouping

        Character character = str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(k->k.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(character);
    }

    private static void test_concatListOfString(List<String> stringList) {
        String finalStr = stringList.stream()
                .collect(Collectors.joining(","));
        System.out.println(finalStr);
    }

    private static void test_findHighestSalariedEmployee(List<Employee> employees) {
        System.out.println("Highest Salaried Employee  : \n" + employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(1)
                .findFirst()
                .get());
        System.out.println("Highest Salaried Employee of each department");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).forEach((k, v) -> {
                    System.out.println(k + " : " + v);
                });
    }

    private static void test_findAllNumberWhosestartWith_1(List<Integer> listOfInteger) {
        List<Integer> numStartWith1 = listOfInteger.stream()
                .map(num -> "" + num)
                .filter(s -> s.startsWith("1"))
                .map(Integer::parseInt)
                .toList();
        System.out.println(numStartWith1);

        System.out.println(listOfInteger
                .stream()
                .map(num -> String.valueOf(num))
                .filter(num -> num.startsWith("1"))
                .map(Integer::parseInt)
                .toList());
    }

    private static void test_findSpecialCharactersFromGivenString(String str) {
        String specChars = str.chars().filter(ch -> !Character.isLetterOrDigit(ch)).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println(specChars);
    }

    private static void test_removeAllOccourenceFromGivenString(String str, char givenChar) {
        if (str == null || str.isEmpty()) {
            System.out.println("Please provide valid data");
        }
        String finalStr = str.chars().filter(c -> c != givenChar).mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
        System.out.println(finalStr);
    }


    private static void test_FindDuplicatesFromGivenIntegerList(List<Integer> listOfInteger) {
        //using set
        Set set = new HashSet();
        List duplicates = listOfInteger.stream().filter(n -> !set.add(n)).toList();
        System.out.print("Duplicates using hashset : " + duplicates + " ");
        System.out.println();
        //using hashmap
        List duplicates2 = listOfInteger.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println("Duplicates using Hashmap : " + duplicates2 + " ");

        //old way
        HashMap<Integer, Integer> hashMap = new HashMap();
        int count = 1;
        for (Integer num : listOfInteger) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Old way");
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            if (map.getValue() > 1) {
                System.out.print(map.getKey() + " ");
            }

        }
    }

    private static void test_FindaverageSalaryOfMaleFemaleEployee(List<Employee> employees) {
        Map<String, Double> avgMaleFemale = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        avgMaleFemale.forEach((k, v) -> {
            System.out.println("Average Salary of " + k + " : " + v);
        });
    }

    private static void test_FindSumOfEvenNumberAndOddNumber(List<Integer> integers) {
        Map<Boolean, List<Integer>> list = integers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.print("Even nums :" + list.get(true) + " ");
        System.out.println();
        System.out.println("Sum of Even numbers : " + list.get(true).stream().reduce(0, Integer::sum));
        System.out.print("Odd nums :" + list.get(false) + " ");
        System.out.println();
        System.out.println("Sum of Odd numbers : " + list.get(false).stream().reduce(0, Integer::sum));

    }

    static void test_HowManyMaleFemaleEmployeeInTheOrganization(List<Employee> employees) {

        //by using partitions
        Map<Boolean, List<Employee>> maleFemale = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getGender().equalsIgnoreCase("Male")));
        System.out.println("Male Employee Count is : " + maleFemale.get(true).stream().count());
        System.out.println("FeMale Employee Count is : " + maleFemale.get(false).stream().count());
        //by using group by functions
        Map<String, Long> empMaleFemale = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(empMaleFemale);
    }
}
