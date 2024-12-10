package com.terbah;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ObservedPin {

    private static final Map<String, List<String>> combinations = Map.of(
            "1", List.of("1", "2", "4"),
            "2", List.of("1", "2", "3", "5"),
            "3", List.of("3", "6", "2"),
            "4", List.of("1", "5", "7", "4"),
            "5", List.of("2", "5", "4", "6", "8"),
            "6", List.of("3", "6", "5", "9"),
            "7", List.of("4", "7", "8"),
            "8", List.of("5", "8", "7", "9", "0"),
            "9", List.of("6", "9", "8"),
            "0", List.of("0", "8")
    );

    private static List<String> computeCombinations(List<List<String>> possibilities) {
        if (possibilities.size() == 1) return possibilities.get(0);
        var combinations = new ArrayList<String>();
        var first = possibilities.get(0);

        for (var p : first) {
            var nextPossibilities = computeCombinations(possibilities.subList(1, possibilities.size()));

            for (var nextPossibility : nextPossibilities) {
                combinations.add(p + nextPossibility);
            }
        }

        return combinations;
    }

    public static List<String> getPINs(String observed) {
        var possibilities = new ArrayList<List<String>>();

        for (char c : observed.toCharArray()) {
            var numbers = new ArrayList<>(combinations.get(String.valueOf(c)));
            possibilities.add(numbers);
        }

        return computeCombinations(possibilities);
    }
}
