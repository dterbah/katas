package com.terbah;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StripCommentsTest {

    @Test
    public void stripComments() throws Exception {
        /*assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );*/

        // https://www.codewars.com/kata/51c8e37cee245da6b40000bd/discuss#label-issue
        assertEquals("apples, plums\\npears\\noranges", StripComments.stripComments("apples, plums\\npears % and bananas\\noranges", new String[] { "%", "!"}));

    }
}
