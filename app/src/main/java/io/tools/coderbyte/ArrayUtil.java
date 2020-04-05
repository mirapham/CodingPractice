package io.tools.coderbyte;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    /**
     * Have the function ArithGeoII(arr) take the array of numbers stored in arr and return the string "Arithmetic"
     * if the sequence follows an arithmetic pattern or return "Geometric" if it follows a geometric pattern.
     * If the sequence doesn't follow either pattern return -1. An arithmetic sequence is one where the difference between
     * each of the numbers is consistent, where as in a geometric sequence, each term after the first is multiplied by
     * some constant or common ratio. Arithmetic example: [2, 4, 6, 8] and Geometric example: [2, 6, 18, 54].
     * Negative numbers may be entered as parameters, 0 will not be entered, and no array will contain all the same elements
     */
    public static String checkArithmeticOrGeometricArray(int[] arr) {
        if (isArithmeticArray(arr)) {
            return "Arithmetic";
        }

        if (isGeometricArray(arr)) {
            return "Geometric";
        }

        return "-1";
    }

    private static boolean isArithmeticArray(int[] arr) {
        int gap = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != gap) {
                return false;
            }
        }

        return true;
    }

    private static boolean isGeometricArray(int[] arr) {
        double gap = arr[1] / arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] / arr[i - 1] != gap) {
                return false;
            }
        }

        return true;
    }

    //////// Array utils methods//////

    public static int getMaxItemInList(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }

        return max;

//        sort the array then return the biggest item in the array, but change the array item order
//        int[] temp = arr;
//        Arrays.sort(temp);
//
//        return temp[temp.length - 1];
    }

    // get the index of the max item in the array
    // can be multiple indexes
    public static int[] getIndexesOfMaxItemInList(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int count = 0;
        for (int i : list) {
            result[count++] = i;
        }

        return result;
    }

    // reverse an array
    public static int[] reverseIntArray(int[] arr) {
        int[] reverseArr = new int[arr.length];
        int count = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArr[count++] = arr[i];
        }

        return reverseArr;
    }

    // get the counting array from an array
    // return an array representing the occur time of each item in the original array
    public static int[] getCountingArray(int[] arr) {

        int max = getMaxItemInList(arr);

        int[] countingArray = new int[max + 1];

        for (int i : arr) {
            countingArray[i]++;
        }

        return countingArray;

    }
}
