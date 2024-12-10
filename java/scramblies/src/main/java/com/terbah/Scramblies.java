package com.terbah;

import java.util.HashMap;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        var lettersCount = new HashMap<Character, Integer>();

        for (char c : str1.toCharArray()) {
            var occurrences = lettersCount.getOrDefault(c, 0);
            lettersCount.put(c, occurrences + 1);
        }

        for (char c : str2.toCharArray()) {
            var occurrences = lettersCount.getOrDefault(c, 0);
            if (occurrences == 0) return false;
            lettersCount.put(c, occurrences - 1);
        }

        return true;
    }
}
