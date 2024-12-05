package com.terbah;

public class PigLatin {

    public String pigIt(String str) {
        var builder = new StringBuilder();
        var parts = str.split(" ");

        for (var i = 0; i < parts.length; i++) {
            var part = parts[i];
            char firstChar = part.charAt(0);
            var newPart =  Character.isLetter(firstChar) ? part.substring(1) + firstChar + "ay" : firstChar;
            builder.append(newPart);
            if (i != (parts.length - 1)) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }
}
