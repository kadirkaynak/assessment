package com.cern;

import java.util.*;

public class DuplicateFinder {

    public static <T> List<T> findDuplicates(List<T> list) {
        List<T> duplicates = new ArrayList<>();
        LinkedHashMap<T, Integer> frequencyMap = new LinkedHashMap<>();
        for (T number : list) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        for (T number : frequencyMap.keySet()) {
            if (frequencyMap.get(number) != 1) {
                duplicates.add(number);
            }
        }
        return duplicates;
    }
}
