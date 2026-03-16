package org.yhc.programming.logic;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateListElements {
    public static void main(String[] args) {
        List<String> strings = List.of("abc", "xyz", "test", "abc", "TEST", "abc");

        System.out.println("Duplicate string :" + duplicateElementsUsingHashSet(strings));
        System.out.println("Duplicate strings with occurrence:" + duplicateElementsWithOccurrence(strings));
        System.out.println("Duplicate strings with occurrence using Stream API:" + duplicateElementsWithOccurrenceUsingStream(strings));
        System.out.println("Duplicate string keeping insertion order:" + duplicateElementsKeepingInsertionOrder(strings));
    }

    private static List<String> duplicateElementsUsingHashSet(List<String> list){
        Set<String> seen = new HashSet<>();

        return list.stream()
                .map(String::toLowerCase)
                .filter(s -> !seen.add(s))
                .distinct()
                .toList();
    }

    private static Map<String, Integer> duplicateElementsWithOccurrence(List<String> list){
        Map<String, Integer> frequencyMap = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (String str: list) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            if(entry.getValue() > 1){
                map.put(entry.getKey(), entry.getValue());
            }
        }

        return map;
    }

    private static Map<String, Long> duplicateElementsWithOccurrenceUsingStream(List<String> list){
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue)
                );
    }

    private static Map<String, Integer> duplicateElementsKeepingInsertionOrder(List<String> list){
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String s: list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        map.entrySet().removeIf(entry -> entry.getValue() == 1);

        return map;
    }
}
