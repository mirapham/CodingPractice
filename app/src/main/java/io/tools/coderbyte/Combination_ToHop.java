package io.tools.coderbyte;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Combination_ToHop {

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    private static void combinationUtil(int arr[], int data[], int start,
                                        int end, int index, int r) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(data[j] + " ");
                Log.d("Muoi", data[j] + " ");
            }
            Log.d("Muoi", "\n\n-------------------");
            System.out.println("");
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    private static void printCombination(int arr[], int arrLength, int numOfItemToCom) {
        // A temporary array to store all combination one by one
        int data[] = new int[numOfItemToCom];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, arrLength - 1, 0, numOfItemToCom);
    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public static List<int[]> generateCombination(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    public static List<int[]> generateCombinationIndexArray(int[] arr) {
        List<int[]> combinationsList = new ArrayList<int[]>();
        for (int i = 1; i <= arr.length; i++) {
            List<int[]> combinations = generateCombination(arr.length, i);
            combinationsList.addAll(combinations);
        }

        return combinationsList;
    }

    /**
     * Using the Java language, have the function CoinDeterminer(num) take the input, which will be an integer ranging
     * from 1 to 250, and return an integer output that will specify the least number of coins, that when added,
     * equal the input integer. Coins are based on a system as follows: there are coins representing the integers
     * 1, 5, 7, 9, and 11. So for example: if num is 16, then the output should be 2 because you can achieve the
     * number 16 with the coins 9 and 7. If num is 25, then the output should be 3 because you can achieve 25 with
     * either 11, 9, and 5 coins or with 9, 9, and 7 coins.
     *
     * @author Nick Livens
     */

    public static int coinDeterminer(int[] coins, int total) {

        //final int[] coins = new int[] {1, 5, 7, 9, 11};

        for (int i = 1; i <= coins.length; i++) {
            List<int[]> combinations = generateCombination(coins.length, i);
            for (int[] combination : combinations) {
                int sum = 0;
                for (int j : combination) {
                    sum += coins[j];
                }

                if (total == sum) {
                    return i;
                }
            }
        }

        return 0;
    }

    //////////////////////////////
    // using demo code

    public static int coinDeterminer2(int[] coins, int num) {
        int minCount = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int count = getCoinCount(coins, num, i, j);
                if (count < minCount) {
                    minCount = count;
                }
            }
        }

        return minCount;

    }

    private static int getCoinCount(int[] coins, int num, int maxCoinIndex, int startCoinIndex) {
        int count = 0;

        if (num >= coins[maxCoinIndex]) {
            num -= coins[maxCoinIndex];
            count++;
        }

        for (int i = startCoinIndex; i >= 0; i--) {
            while (num >= coins[i]) {
                num -= coins[i];
                count++;
            }
        }
        return count;
    }

    /**
     * Have the function ArrayAdditionI(arr) take the array of numbers stored in arr and return the string true if any
     * combination of numbers in the array can be added up to equal the largest number in the array, otherwise return the
     * string false. For example: if arr contains [4, 6, 23, 10, 1, 3] the output should return true because
     * 4 + 6 + 10 + 3 = 23. The array will not be empty, will not contain all the same elements,
     * and may contain negative numbers.
     * <p>
     * This will need to do in backtracking alg
     */
    public static boolean checkArrayAddition(int[] arr) {
        List<int[]> combinations = Combination_ToHop.generateCombinationIndexArray(arr);

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        for (int[] array : combinations) {
            // not count the maxIndex case
            if (array.length == 1 && array[0] == maxIndex) {
                continue;
            }

            int sum = 0;
            for (int item : array) {
                sum += arr[item];
            }

            if (sum == max) {
                return true;
            }
        }

        return false;

    }
}
