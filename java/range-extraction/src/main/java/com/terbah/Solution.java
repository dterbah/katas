package com.terbah;

import java.util.*;

public class Solution {

    private static List<String> getRange(int index, int[] array) {
        int currentNbr = array[index];
        var range = new ArrayList<String>();
        range.add(String.valueOf(currentNbr));

        for (int i = index + 1; i < array.length; i++) {
            var nbr = array[i];
            if (nbr != currentNbr + 1) break;
            currentNbr = nbr;
            range.add(String.valueOf(nbr));
        }

        return range.size() >= 3 ? range : List.of(String.valueOf(array[index]));
    }

    public static String rangeExtraction(int[] arr) {
        var ranges = new ArrayList<List<String>>();
        for (int i = 0; i < arr.length;) {
            var range = getRange(i, arr);
            ranges.add(range);

            i += range.size();
        }

        var parts = ranges.stream().map((range) -> {
            if (range.size() == 1) return String.valueOf(range.get(0));
            return range.get(0) + "-" + range.get(range.size() - 1);
        });

        return String.join(",", parts.toList());
    }
}
