package com.terbah;

import java.util.*;

public class Kata {

    private static List<String> getAllPossibilitiesOf(List<String> digits, String prefix) {
        List<String> res = new ArrayList<>();
        var size = digits.size();
        if (digits.isEmpty()) return List.of(prefix);
        for (var i = 0; i < size; i++) {
            var newPrefix = prefix + digits.get(i);
            List<String> remaining = new ArrayList<>(digits.subList(0, i));
            remaining.addAll(digits.subList(i + 1, size));
            res.addAll(getAllPossibilitiesOf(remaining, newPrefix));
        }

        return res;
    }

    public static long nextBiggerNumber(long n) {
        String input = Long.toString(n);
        var digits = input.split("");
        List<String> possibilities = getAllPossibilitiesOf(Arrays.asList(digits), "");
        var parsedPossibilities = possibilities.stream().mapToLong(Long::parseLong).boxed().toList();
        var res = parsedPossibilities.stream().filter(v -> v > n).min(Long::compare);

        return res.isEmpty() ? -1 : res.get();
    }
}
