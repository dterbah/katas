package com.terbah;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {

    @Test
    public void sampleTests() {
        assertEquals("a", Kata.firstNonRepeatingLetter("a"), "For input \"a\"");
        assertEquals("t", Kata.firstNonRepeatingLetter("streSS"), "For input \"streSS\"");
        assertEquals("-", Kata.firstNonRepeatingLetter("moon-men"), "For input \"moon-men\"");
        assertEquals("", Kata.firstNonRepeatingLetter("moonmoon"), "For input \"moonmoon\"");
    }
}
