package com.terbah;

import java.util.HashMap;

public class Greed {

    private static int computeScoreFor(int nbr, int count) {
        return switch (nbr) {
            case 1 -> count < 3 ? count * 100 : 1000 + (count - 3) * 100;
            case 2 -> count >= 3 ? 200 : 0;
            case 3 -> count >= 3 ? 300 : 0;
            case 4 -> count >= 3 ? 400 : 0;
            case 5 -> count < 3 ? count * 50 : 500 + (count - 3) * 50;
            case 6 -> count >= 3 ? 600 : 0;
            default -> 0;
        };
    }

    public static int greedy(int[] dice){
        int score = 0;
        var counters = new HashMap<Integer, Integer>();

        for (var nbr : dice) {
            var count = counters.getOrDefault(nbr, 0);
            counters.put(nbr, count + 1);
        }

        for (var entry : counters.entrySet()) {
            score += computeScoreFor(entry.getKey(), entry.getValue());
        }

        return score;
    }
}
