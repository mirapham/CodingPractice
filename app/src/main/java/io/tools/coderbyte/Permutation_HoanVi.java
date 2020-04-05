package io.tools.coderbyte;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutation_HoanVi {

    //////////////////////// generate all permutations of a string ////////////////////////

    /**
     * permutation function: print all permutations of a given string.
     *
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    public static void permuteString(String str, int l, int r) {
        if (l == r) {
            Log.d("Muoi", str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swapString(str, l, i);
                permuteString(str, l + 1, r);
                str = swapString(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    private static String swapString(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    //////////////////////// generate all distinct permutations of a string ////////////////////////
    public static ArrayList<String> distinctPermuteString(String str) {
        // If string is empty
        if (str.length() == 0) {

            // Return an empty arraylist
            ArrayList<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }

        // Take first character of str
        char ch = str.charAt(0);

        // Rest of the string after excluding
        // the first character
        String restStr = str.substring(1);

        // Recurvise call
        ArrayList<String> prevRes = distinctPermuteString(restStr);

        // Store the generated sequence into
        // the resultant Arraylist
        ArrayList<String> Res = new ArrayList<>();
        for (String s : prevRes) {
            for (int i = 0; i <= s.length(); i++) {
                String f = s.substring(0, i) + ch + s.substring(i);

                // If the generated string is not
                // already present in the Arraylist
                if (!isPresent(f, Res))

                    // Add the generated string to the Arraylist
                    Res.add(f);
            }
        }

        // Return the resultant arraylist
        return Res;
    }

    // Function that returns true if string s
    // is present in the Arraylist
    private static boolean isPresent(String s, ArrayList<String> Res) {

        // If present then return true
        for (String str : Res) {

            if (str.equals(s))
                return true;
        }

        // Not present
        return false;
    }

    //////////////////// create all permutation by Java Solution 1 - Iteration//////////////////////
    public static ArrayList<ArrayList<Integer>> permuteIntegerInArray(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }

    public static ArrayList<ArrayList<String>> permuteStringInArray(String[] num) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        //start from an empty list
        result.add(new ArrayList<String>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<String>> current = new ArrayList<ArrayList<String>>();

            for (ArrayList<String> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<String> temp = new ArrayList<String>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<String>>(current);
        }

        return result;
    }

    public static ArrayList<ArrayList<Character>> permuteCharInArray(Character[] num) {
        ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();

        //start from an empty list
        result.add(new ArrayList<Character>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Character>> current = new ArrayList<ArrayList<Character>>();

            for (ArrayList<Character> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Character> temp = new ArrayList<Character>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Character>>(current);
        }

        return result;
    }

    public static List<Integer> permuteIntegerNumber(int num) {
        List<Integer> result = new ArrayList<Integer>();

        if (num < 10) {
            result.add(num);
            return result;
        }

        String numStr = String.valueOf(num);
        char[] charArr = numStr.toCharArray();
        String[] strArr = new String[charArr.length];

        int count = 0;
        for (char c : charArr) {
            strArr[count++] = String.valueOf(c);
        }

        ArrayList<ArrayList<String>> permutedList = permuteStringInArray(strArr);

        for (ArrayList<String> list : permutedList) {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s);
            }

            int value = Integer.parseInt(builder.toString());

            result.add(value);

        }

        return result;
    }

    public static List<String> permuteStringValue(String value) {
        List<String> result = new ArrayList<String>();

        if (value.length() < 2) {
            result.add(value);
            return result;
        }

        char[] charArr = value.toCharArray();
        String[] strArr = new String[charArr.length];

        int count = 0;
        for (char c : charArr) {
            strArr[count++] = String.valueOf(c);
        }

        ArrayList<ArrayList<String>> permutedList = permuteStringInArray(strArr);

        for (ArrayList<String> list : permutedList) {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s);
            }

            result.add(builder.toString());

        }

        return result;
    }


    // by Java Solution 2 - Recursion
    public static List<List<Integer>> permuteIntegerInArray2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private static void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Have the function PrimeChecker(num) take num and return 1 if any arrangement of num comes out to be a prime number,
     * otherwise return 0. For example: if num is 910, the output should be 1 because 910 can be
     * arranged into 109 or 019, both of which are primes.
     */
    public static int primeCheckByPermutation(int num) {
        if (isPrimeNumber(num)) {
            return 1;
        }

        String numStr = String.valueOf(num);
        char[] charArr = numStr.toCharArray();
        String[] strArr = new String[charArr.length];

        int count = 0;
        for (char c : charArr) {
            strArr[count++] = String.valueOf(c);
        }

        ArrayList<ArrayList<String>> permutedList = permuteStringInArray(strArr);

        for (ArrayList<String> list : permutedList) {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s);
            }

            int value = Integer.parseInt(builder.toString());
            if (isPrimeNumber(value)) {
                return 1;
            }
        }

        return 0;

    }

    private static boolean isPrimeNumber(int num) {
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    /**
     * Have the function PermutationStep(num) take the num parameter being passed and return the next number greater than
     * num using the same digits. For example: if num is 123 return 132, if it's 12453 return 12534.
     * If a number has no greater permutations, return -1 (ie. 999).
     */
    public static int permutationStep(int num) {
        List<Integer> list = permuteIntegerNumber(num);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i) == num) && (i + 1 < list.size()) && (list.get(i + 1) != num)) {
                return list.get(i + 1);
            }
        }

        return -1;
    }

}
