package com.terbah;

import java.util.*;

public class Kata {

    public static String firstNonRepeatingLetter(String s) {
        Map<Character, Integer> mapping = new LinkedHashMap<>();
        String lowerInput = s.toLowerCase();

        for (char c : lowerInput.toCharArray()) {
            mapping.put(c, mapping.getOrDefault(c, 0) + 1);
        }

        for (var i = 0; i < s.length(); i++) {
            char originalChar = s.charAt(i);
            char lowerChar = lowerInput.charAt(i);

            if (mapping.get(lowerChar) == 1) {
                return String.valueOf(originalChar);
            }
        }

        return "";
    }
}
