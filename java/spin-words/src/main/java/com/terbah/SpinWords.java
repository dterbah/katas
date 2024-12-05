package com.terbah;

public class SpinWords {

    public String spinWords(String sentence) {
        var parts = sentence.split(" ");
        StringBuilder builder = new StringBuilder();

        for (var i = 0; i < parts.length; i++) {
            var part = parts[i];
            var computedPart = part.length() >= 5 ? new StringBuilder(part).reverse().toString() : part;
            builder.append(computedPart);
            if (i != parts.length - 1) builder.append(" ");
        }

        return builder.toString();
    }
}
