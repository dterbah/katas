package com.terbah;

public class RgbToHex {

    private static String toHex(int a) {
        if (a > 255) return "FF";
        if (a < 0) return "00";

        return String.format("%02X", (byte) a);
    }

    public static String rgb(int r, int g, int b) {

        return toHex(r) +
                toHex(g) +
                toHex(b);
    }
}
