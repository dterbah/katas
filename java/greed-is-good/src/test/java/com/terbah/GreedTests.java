package com.terbah;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreedTests {

    @Test
    public void testExample() {
        assertEquals(250, Greed.greedy(new int[]{5,1,3,4,1}), "Score for [5,1,3,4,1] must be 250:");
        assertEquals(1100, Greed.greedy(new int[]{1,1,1,3,1}), "Score for [1,1,1,3,1] must be 1100:");
        assertEquals(450, Greed.greedy(new int[]{2,4,4,5,4}), "Score for [2,4,4,5,4] must be 450:");
    }
}
