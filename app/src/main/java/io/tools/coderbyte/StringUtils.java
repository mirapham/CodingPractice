package io.tools.coderbyte;

import android.text.style.UpdateAppearance;
import android.util.Log;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class StringUtils {

    public static void print(String[] strArr) {
        Log.d("Muoi", strArr.toString() + " ");
        Log.d("Muoi", "-------------Array----------\n");
        for (String s : strArr) {
            Log.d("Muoi", s + " ");
        }
        Log.d("Muoi", "----------------------------------\n");
    }

    // reverse a String
    public static String reverseString(String str) {
//        char[] arr = str.toCharArray();
////
////        StringBuilder builder = new StringBuilder();
////        for (int i = arr.length - 1; i >= 0; i--) {
////            builder.append(arr[i] + "");
////        }
////
////        return builder.toString();

        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }

    // order every char in a string
    public static String orderString(String str) {
        char[] arr = str.toCharArray();

        // use API from Array to sort the arr
        Arrays.sort(arr);

        String res = new String(arr);

        return res;
    }

    // order every char in a string and remove the duplicated char
    public static String orderStringWithRemoveDuplicated(String str) {
        char[] arr = str.toCharArray();

        // put every char in the str into SortedSet
        // in order to make it sorted automatically
        SortedSet<String> sortedSet = new TreeSet<String>();

        for (char c : arr) {
            sortedSet.add(String.valueOf(c));
        }

        StringBuilder builder = new StringBuilder();
        for (String s : sortedSet) {
            builder.append(s);
        }

        return builder.toString();
    }

    // replace a first needChangeString with a replaceValue in an originalString
    private static String replaceString(String originalString, String needChangeString, String replaceValue) {
        return originalString.replaceFirst(needChangeString, replaceValue);
    }

    /**
     * Have the function SwapII(str) take the str parameter and swap the case of each character.
     * Then, if a letter is between two numbers (without separation), switch the places of the two numbers.
     * For example: if str is "6Hello4 -8World, 7 yes3" the output should be 4hELLO6 -8wORLD, 7 YES3.
     */
    public static String swapTwo(String originalString) {

        StringBuilder result = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        boolean hasNumberAlready = false;

        for (char c : originalString.toCharArray()) {
            if (RegularExpressionUtil.checkStringContainNumber(String.valueOf(c))) {
                builder.append(String.valueOf(c));
                if (hasNumberAlready) {
                    result.append(processChangeNumberPosition(builder.toString()));

                    builder = new StringBuilder();
                    hasNumberAlready = false;
                } else {
                    hasNumberAlready = true;
                }
            } else if (c == ' ') {
                builder.append(String.valueOf(c));
                hasNumberAlready = false;
                result.append(processReverseCaseString(builder.toString()));
                builder = new StringBuilder();

            } else if (RegularExpressionUtil.checkPlainStringContainSpecialChar(String.valueOf(c))) {
                builder.append(String.valueOf(c));
            } else {
                if (isUpperCaseString(String.valueOf(c))) {
                    builder.append(String.valueOf(c).toLowerCase());
                } else {
                    builder.append(String.valueOf(c).toUpperCase());
                }
            }
        }

        if (builder.toString().length() > 0) {
            result.append(processReverseCaseString(builder.toString()));
        }

        return result.toString();

    }

    private static String processReverseCaseString(String str) {

        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (RegularExpressionUtil.checkPlainStringContainSpecialChar(String.valueOf(c))) {
                builder.append(c);
            } else if (RegularExpressionUtil.checkStringContainNumber(String.valueOf(c))) {
                builder.append(c);
            } else {
                if (isUpperCaseString(String.valueOf(c))) {
                    builder.append(String.valueOf(c).toLowerCase());
                } else {
                    builder.append(String.valueOf(c).toUpperCase());
                }
            }
        }

        return builder.toString();
    }

    private static String processChangeNumberPosition(String str) {
        StringBuilder builder = new StringBuilder();

        String newStr = str.substring(1, str.length() - 1);
        newStr = newStr + str.substring(0, 1);

        String finalString = str.substring(str.length() - 1, str.length()) + newStr;

        return finalString;

    }

    // use Regular expression to check that str is uppercase or lowercase
    public static boolean isUpperCaseString(String str) {
        //convert String to char array
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            //if the character is a letter
            if (Character.isLetter(charArray[i])) {

                //if any character is not in upper case, return false
                if (!Character.isUpperCase(charArray[i]))
                    return false;
            }
        }

        return true;
    }

    /**
     * Have the function TripleDouble(num1,num2) take both parameters being passed, and return 1 if there is a straight
     * triple of a number at any place in num1 and also a straight double of the same number in num2.
     * For example: if num1 equals 451999277 and num2 equals 41177722899, then return 1 because in the first parameter
     * you have the straight triple 999 and you have a straight double, 99, of the same number in the second parameter.
     * If this isn't the case, return 0.
     */
    public static int trippleDouble(long value1, long value2) {
        String str1 = String.valueOf(value1);
        String str2 = String.valueOf(value2);

        // find the tripple value in value1
        String trippleValue = getTrippleValueFrom1(str1);

        if (trippleValue == null) {
            return 0;
        }

        // find the double of trippleValue in value2
        if (str2.contains(trippleValue.substring(0, 2))) {
            return 1;
        }

        return 0;

    }

    private static String getTrippleValueFrom1(String str) {
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (builder.length() == 0) {
                builder.append(c);
            } else if (builder.length() == 3) {
                return builder.toString();
            } else {
                char d = builder.charAt(0);
                if (c == d) {
                    builder.append(c);
                } else {
                    builder = new StringBuilder();
                    builder.append(c);
                }
            }
        }

        return null;

    }

    /**
     * Have the function PalindromeTwo(str) take the str parameter being passed and return the string true if the parameter
     * is a palindrome, (the string is the same forward as it is backward) otherwise return the string false.
     * The parameter entered may have punctuation and symbols but they should not affect whether the string is in fact
     * a palindrome. For example: "Anne, I vote more cars race Rome-to-Vienna" or "car race or race car" should return true.
     */
    public static boolean isPalindromeString(String str) {
        // First we need to remove any special character in the str
        String trimmedString1 = RegularExpressionUtil.getPlainStringByRemoveSpecialChar(str);
        String trimmedString2 = RegularExpressionUtil.getPlainStringWithoutNumber(trimmedString1);

        // then reverse the String
        String reverseStr = new StringBuilder(trimmedString2).reverse().toString();

        // compare the originString with the reverseStr
        if (reverseStr.equals(trimmedString2)) {
            return true;
        }

        return false;

    }

    /**
     * Have the function NumberSearch(str) take the str parameter, search for all the numbers in the string,
     * add them together, then return that final number divided by the total amount of letters in the string.
     * For example: if str is "Hello6 9World 2, Nic8e D7ay!" the output should be 2. First if you add up all the numbers,
     * 6 + 9 + 2 + 8 + 7 you get 32. Then there are 17 letters in the string. 32 / 17 = 1.882, and the final answer should
     * be rounded to the nearest whole number, so the answer is 2. Only single digit numbers separated by spaces will be
     * used throughout the whole string (So this won't ever be the case: hello44444 world).
     * Each string will also have at least one letter.
     */
    public static int NumberSearch(String str) {

        String[] strArray = str.split(" ");

        int sum = 0;
        int number = -1;
        for (String item : strArray) {
            number = getIntFromWord(item);
            if (number != -1) {
                sum += number;
            }
        }

        int result = 0;
        if (sum > 0) {
            int noOfCharInStr = getNumbersOfCharInString(str);
            result = (int) Math.round((double) sum / noOfCharInStr);
        }

        return result;
    }

    private static int getNumbersOfCharInString(String str) {
        String plainString = RegularExpressionUtil.getPlainStringByRemoveSpecialChar(str);
        String finalString = RegularExpressionUtil.getPlainStringWithoutNumber(plainString);
        return finalString.length();
    }

    private static int getIntFromWord(String item) {
        char[] charArr = item.toCharArray();

        boolean firstNumFound = false;
        int foundInt = -1;
        for (char c : charArr) {
            if (RegularExpressionUtil.checkStringContainNumber(String.valueOf(c))) {
                if (!firstNumFound) {
                    foundInt = Integer.parseInt(String.valueOf(c));
                    firstNumFound = true;
                } else {
                    return -1;
                }
            }
        }

        return foundInt;
    }

    /**
     * Have the function NumberEncoding(str) take the str parameter and encode the message according to the following rule:
     * encode every letter into its corresponding numbered position in the alphabet.
     * Symbols and spaces will also be used in the input.
     * For example: if str is "af5c a#!" then your program should return 1653 1#!.
     */
    public static String numberEncoding(String str) {
        final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder builder = new StringBuilder("");

        int indexOfC = -1;
        for (char c : str.toCharArray()) {
            indexOfC = LOWER.indexOf(c);
            if (indexOfC == -1) {
                indexOfC = UPPER.indexOf(c);
                if (indexOfC == -1) {
                    builder.append(c);
                } else {
                    builder.append(String.valueOf(indexOfC + 1));
                }
            } else {
                builder.append(String.valueOf(indexOfC + 1));
            }
        }

        return builder.toString();
    }

    /**
     * Have the function MultipleBrackets(str) take the str parameter being passed and return 1 #ofBrackets if the brackets
     * are correctly matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello [world])(!)",
     * then the output should be 1 3 because all the brackets are matched and there are 3 pairs of brackets,
     * but if str is "((hello [world])" the the output should be 0 because the brackets do not correctly match up.
     * Only "(", ")", "[", and "]" will be used as brackets. If str contains no brackets return 1.
     */
    public static String multipleBrackets(String str) {
        char[] charArray = str.toCharArray();

        List<String> bracketList = new ArrayList<String>();
        Map<String, Integer> result = new HashMap<String, Integer>();

        for (char c : charArray) {
            if (isBracketChar(String.valueOf(c)) && c != ' ') {
                String bracket = processBracketList(bracketList, String.valueOf(c));
                if (!bracket.equals("")) {
                    if (result.containsKey(bracket)) {
                        int value = result.get(bracket);
                        value++;
                        result.put(bracket, value);
                    } else {
                        result.put(bracket, 1);
                    }
                }
            }
        }

        if (bracketList.size() > 0) {
            return "0";
        }

        if (result.size() > 0) {
            int totalBracket = getTotalInMap(result);
            return "1 " + totalBracket;
        } else {
            return "1";
        }
    }

    private static int getTotalInMap(Map<String, Integer> result) {
        int sum = 0;
        for (String key : result.keySet()) {
            sum += result.get(key);
        }

        return sum;
    }

    private static boolean isBracketChar(String value) {
        if (value.equals("(") || value.equals(")")) {
            return true;
        }

        if (value.equals("[") || value.equals("]")) {
            return true;
        }

        return false;
    }

    // check the list if it has the partner of the value, remove the partner
    // if it do not, add to the list
    private static String processBracketList(List<String> bracketList, String value) {
        if (bracketList.size() == 0) {
            bracketList.add(value);
            return "";
        }

        boolean found = false;
        String bracketGroup = "";
        String bracketPartner = "";
        for (String item : bracketList) {
            if (value.equals("(") && item.equals(")")) {
                found = true;
                bracketPartner = ")";
                bracketGroup = "()";
                break;
            } else if (value.equals(")") && item.equals("(")) {
                found = true;
                bracketPartner = "(";
                bracketGroup = "()";
                break;
            } else if (value.equals("[") && item.equals("]")) {
                found = true;
                bracketPartner = "]";
                bracketGroup = "[]";
                break;
            } else if (value.equals("]") && item.equals("[")) {
                found = true;
                bracketPartner = "[";
                bracketGroup = "[]";
                break;
            }
        }

        if (found) {
            bracketList.remove(bracketPartner);
        } else {
            bracketList.add(value);
        }

        return bracketGroup;
    }

    private static String getSpecialCharGroup(String value) {
        if (value.equals("(") || value.equals(")")) {
            return "()";
        }

        if (value.equals("[") || value.equals("]")) {
            return "[]";
        }

        return "";
    }

    /**
     * Have the function MostFreeTime(strArr) read the strArr parameter being passed which will represent a full day and
     * will be filled with events that span from time X to time Y in the day. The format of each event will be
     * hh:mmAM/PM-hh:mmAM/PM. For example, strArr may be ["10:00AM-12:30PM","02:00PM-02:45PM","09:10AM-09:50AM"].
     * Your program will have to output the longest amount of free time available between the start of your first event
     * and the end of your last event in the format: hh:mm. The start event should be the earliest event in the day and
     * the latest event should be the latest event in the day. The output for the previous input would therefore be 01:30
     * (with the earliest event in the day starting at 09:10AM and the latest event ending at 02:45PM).
     * The input will contain at least 3 events and the events may be out of order.
     */
    public static String mostFreeTime(String[] arr) {

        // change time format for easy to do operation
        String[] formatTimes = new String[arr.length];
        int count = 0;
        for (String meeting : arr) {
            // change time to 10:00AM-12:30, 14:00-14:45, 09:10-09:50
            // change time to 600-750, 840-885, 550-590
            String formatedTime = changeTimeFormat(meeting);
            formatTimes[count++] = formatedTime;
        }

        // check the free time gap between meeting
        // sort the start time first
        Map<Integer, Integer> timeMap = new HashMap<>();
        int[] startTimeArr = new int[arr.length];
        int count2 = 0;
        for (String intTime : formatTimes) {
            String startTime = intTime.split("-")[0];
            String endTime = intTime.split("-")[1];
            int startTimeInt = Integer.parseInt(startTime);
            int endTimeInt = Integer.parseInt(endTime);

            timeMap.put(startTimeInt, endTimeInt);
            startTimeArr[count2++] = startTimeInt;
        }

        // get the max gap from the map
        Arrays.sort(startTimeArr);
        int maxGap = 0;
        for (int i = 0; i < startTimeArr.length - 1; i++) {
            int start = startTimeArr[i];
            int end = timeMap.get(start);

            int nextStart = startTimeArr[i + 1];
            int nextEnd = timeMap.get(nextStart);

            if (maxGap < nextStart - end) {
                maxGap = nextStart - end;
            }
        }

        // convert maxGap to format hh:MM
        String gap = getTimeFormatFromInt(maxGap);

        return gap;
    }

    private static String getTimeFormatFromInt(int maxGap) {
        int hour = maxGap / 60;
        int minutes = maxGap % 60;

        StringBuilder builder = new StringBuilder();
        if (hour < 10) {
            builder.append("0" + hour);
        } else {
            builder.append(hour);
        }
        builder.append(":");
        if (minutes < 10) {
            builder.append("0" + minutes);
        } else {
            builder.append(minutes);
        }

        return builder.toString();
    }

    // Change the time format from "02:00AM-02:45PM" to "02:00AM-14:45AM"
    // change "02:00AM-02:45PM" to "02:00-14:45"
    private static String changeTimeFormat(String meeting) {
        String[] times = meeting.split("-");

        String startTime = times[0];
        String endTime = times[1];

        int startTimeInt = 0;
        int endTimeInt = 0;

        // change for start time "02:00AM-02:45PM" to "02:00-14:45"
        String startTimeHour = getTimeInHour(startTime);
        String startTimeMinute = getTimeInMinute(startTime);

        if (startTime.toUpperCase().endsWith("PM")) {
            int hour = Integer.parseInt(startTimeHour);
            if (hour < 12) {
                hour += 12;
            }
            startTimeInt = hour * 60 + Integer.parseInt(startTimeMinute);
        } else if (startTime.toUpperCase().endsWith("AM")) {
            startTimeInt = Integer.parseInt(getTimeInHour(startTime)) * 60 + Integer.parseInt(startTimeMinute);
        }

        // change for end time "02:00AM-02:45PM" to "02:00-14:45"
        String endTimeHour = getTimeInHour(endTime);
        String endTimeMinute = getTimeInMinute(endTime);
        if (endTime.endsWith("PM")) {
            int hour = Integer.parseInt(endTimeHour);
            if (hour < 12) {
                hour += 12;
            }
            endTimeInt = hour * 60 + Integer.parseInt(endTimeMinute);
        } else if (endTime.endsWith("AM")) {
            endTimeInt = Integer.parseInt(getTimeInHour(endTime)) * 60 + Integer.parseInt(endTimeMinute);
        }

        return startTimeInt + "-" + endTimeInt;

    }

    // get hour time from 02:00AM, return 02
    private static String getTimeInHour(String time) {
        return time.split(":")[0];
    }

    // get hour time from 02:00AM, return 00
    private static String getTimeInMinute(String time) {
        return time.split(":")[1].substring(0, 2);
    }
}
