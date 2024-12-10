package com.terbah;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    public static List<String> singlePermutations(String s) {
        if (s.length() == 1) return List.of(s);
        var permutations = new HashSet<String>();

        for (var i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            String newS = s.substring(0, i) + s.substring(i + 1);
            var perms = singlePermutations(newS);

            for (var perm : perms) {
                permutations.add(currentChar + perm);
            }
        }

        return new ArrayList<>(permutations);
    }
}
