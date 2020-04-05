package io.tools.coderbyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionUtil {

    // find longest word without any special characters
    public static String LongestWord(String sen) {
        String[] strArray = sen.split(" ");

        int maxLength = 0;
        String result = "";
        for (String str : strArray) {
            String strWithoutSpecialChar = getPlainStringByRemoveSpecialChar(str);

            if (maxLength < strWithoutSpecialChar.length()) {
                maxLength = strWithoutSpecialChar.length();
                result = strWithoutSpecialChar;
            }
        }

        return result;
    }

    // change the letter by moving each char to the next char, regardless the special character and number
    public static String LetterChanges(String str) {
        char[] arr = str.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char c : arr) {
            char d = c;
            boolean isSpecialChar = checkPlainStringContainSpecialChar(String.valueOf(c));
            boolean isNumbeer = checkStringContainNumber(String.valueOf(c));
            if (c != ' ' && !isSpecialChar && !isNumbeer) {
                d = (char) (c + 2);
            }

//            if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
//                String x = String.valueOf(d).toUpperCase();
//                builder.append(x);
//            } else {
                builder.append(d + "");
//            }
        }

        return builder.toString();
    }

    // use Regular expression to remove all special character from str
    public static String getPlainStringByRemoveSpecialChar(String str) {
        String pattern = "\\W";
        String result = str.replaceAll(pattern, "");

        return result;
    }

    // use Regular expression to remove all special character from str
    public static String getPlainStringWithoutNumber(String str) {
        String patternSpecialChar = "\\W";
        String result1 = str.replaceAll(patternSpecialChar, "");

        String patternNumber = "\\d";
        String result2 = result1.replaceAll(patternNumber, "");

        return result2;
    }

    // use Regular expression to check that there is special character from str or not
    public static boolean checkPlainStringContainSpecialChar(String str) {
        String specialChar = "\\W";
        Pattern pattern = Pattern.compile(specialChar);

        Matcher m = pattern.matcher(str);

        return m.find();
    }

    // use Regular expression to check that there is number from str or not
    public static boolean checkStringContainNumber(String str) {
        String specialChar = "\\d";
        Pattern pattern = Pattern.compile(specialChar);

        Matcher m = pattern.matcher(str);

        return m.find();
    }


}
