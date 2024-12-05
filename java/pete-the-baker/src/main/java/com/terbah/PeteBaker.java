package com.terbah;

import java.util.HashMap;
import java.util.Map;

public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int bakedCakes = 0;
        var availableIngredients = new HashMap<>(available);

        while (true) {
            boolean canBake = true;
            // check if pete can bake
            for (var entry : recipe.entrySet()) {
                var ingredient = entry.getKey();
                var amount = entry.getValue();

                var newAmount = availableIngredients.getOrDefault(ingredient, 0) - amount;
                availableIngredients.put(ingredient, newAmount);
                canBake = canBake && newAmount >= 0;
            }

            if (!canBake) break;
            bakedCakes++;
        }

        return bakedCakes;
    }
}
