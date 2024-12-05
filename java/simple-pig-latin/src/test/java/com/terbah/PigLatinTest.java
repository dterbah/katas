package com.terbah;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinTest {
    @Test
    public void tests() {
        var pigLatin = new PigLatin();
        assertEquals("igPay atinlay siay oolcay", pigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", pigLatin.pigIt("This is my string"));
    }
}
