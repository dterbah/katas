package com.terbah;

import java.util.ArrayList;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        var sentences = new ArrayList<String>();

        for (var part : text.split("\n")) {
            // find index of comment
            int index = Integer.MAX_VALUE;

            for (String symbol : commentSymbols) {
                var i = part.indexOf(symbol);
                if (i != -1) {
                    index = Math.min(i, index);
                }
            }

            String sentence = index != Integer.MAX_VALUE ? part.substring(0, index - 1) : part.trim();
            sentences.add(sentence);
        }

        return String.join("\n", sentences);
    }
}
