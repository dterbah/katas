package com.terbah;

public class Kata {

    public static String incrementString(String str) {
        int index = str.length() - 1;
        boolean carry = false;
        StringBuilder builder = new StringBuilder();


        while (index >= 0) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }

            int nbr = Integer.parseInt(String.valueOf(c));
            if (index == str.length() - 1) nbr++;

            int res = carry ? ((nbr + 1) % 10) : nbr % 10;

            // carry should be true if res == 10
            carry = res == 0 && nbr != 0;

            builder.insert(0, res);

            index--;
        }

        if (index == str.length() - 1) {
            // case where input has no number at the end
            builder.append("1");
        }

        if (carry) {
            builder.insert(0, "1");
        }

        return str.substring(0, index + 1) + builder;
    }
}
