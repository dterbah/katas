package com.terbah;

import java.util.HashMap;

public class DuplicateEncoder {
    public String encode(String word) {
        var occurences = new HashMap<String, Integer>();
        var builder = new StringBuilder();
        var parts = word.split("");

        for (var part : parts) {
            if (occurences.containsKey(part.toLowerCase())) {
                occurences.put(part.toLowerCase(), occurences.get(part) + 1);
            } else {
                occurences.put(part.toLowerCase(), 1);
            }
        }

        // now, time to encode !
        for (var part : parts) {
            var count = occurences.get(part.toLowerCase());
            var charToAdd = count == 1 ? '(' : ')';
            builder.append(charToAdd);
        }

        return builder.toString();
    }
}
