package com.terbah;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateEncoderTest {

    @Test
    public void test() {
        var encoder = new DuplicateEncoder();
        assertEquals(")()())()(()()(",
                encoder.encode("Prespecialized"));
        assertEquals("))))())))",encoder.encode("   ()(   "));
    }
}
