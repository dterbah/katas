package com.terbah;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata {

    public static String[] splitTextAndNumber(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        Pattern pattern = Pattern.compile("^(.*?)(\\d+)$");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new String[] { matcher.group(1), matcher.group(2) };
        }
        return null;
    }

    public static String incrementString(String str) {
        var parts = splitTextAndNumber(str);
        if (parts == null) parts = new String[] { str, "0" };

        // compute new number
        var p = parts[1];
        boolean carry = false;
        String res = "";
        for (var i = p.length() - 1; i >= 0; i--) {
            int nbr = Integer.parseInt(String.valueOf(p.charAt(i)));
            if (i == p.length() - 1) {
                // add 1
                nbr += 1;
            }

            if (carry) nbr++;
            if (nbr == 10) carry = true;
            nbr %= 10;

            res = nbr + res;
        }

        if (carry && Integer.parseInt(res) < Integer.parseInt(p)) res = 1 + res;
        return parts[0] + res;
    }
}
