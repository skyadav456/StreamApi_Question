package collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Rahul", "Amit", "Priya", "Rahul",
                "Amit", "Neha", "Vikas", "Priya"
        );

        // Find duplicate elements in a list.
        Set<String> nameset= new HashSet<>();
        Set<String> duplicateElement = names.stream()
                .filter(e -> !nameset.add(e))
                .collect(Collectors.toSet());
        System.out.println("Duplicate element: " + duplicateElement);

        System.out.println("========================================");

        //method -2 using the collector.groupingBy()
        Set<String> duplicateEle = names.stream().collect(Collectors.groupingBy(
                        e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("Duplicate element: " + duplicateEle);

        System.out.println("=======================================");

        // Find elements that occur only once.

        Set<String> singleaccourance = names.stream().collect(Collectors.groupingBy(
                        e -> e, Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println("Single accurance" +  singleaccourance);


        System.out.println("===============================");

        // Count the frequency of every element using groupingBy().

        Map<String, Long> frequency = names.stream().collect(
                Collectors.groupingBy(
                        e -> e, Collectors.counting()
                ));

        System.out.println("Frequent accourance: " + frequency);

        System.out.println("==============================");

        // Find the first non-repeating character in a String
        String s= "sharad";
        Character character= s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry->
                        entry.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First non-repeating character: " + character);

        System.out.println(" =====================================");

        // Find the first repeating character in a String
        Character character1= s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry->
                        entry.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First repeating character: " + character1);


        System.out.println(" ==================================");

        //Count the frequency of each character in a String
        String str= "allahabad";
        Map<Character, Long> charCounting=str.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap:: new,
                        Collectors.counting()
                ));
        System.out.println("Char counting: " + charCounting);

        System.out.println("=========================");

        // Find duplicate characters in a String.

        Set<Character> duplicateChar=str.chars().mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry->
                        entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println("Duplicate char: " + duplicateChar);

        System.out.println( "========================");

        // Remove duplicate characters from a String while preserving order.


        // Reverse a String using Stream API.



        //Check whether a String is a palindrome.



        // Count vowels in a String



        //Find the longest word in a sentence.
}
    }
