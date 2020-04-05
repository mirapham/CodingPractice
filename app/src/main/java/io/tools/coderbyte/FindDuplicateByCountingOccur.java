package io.tools.coderbyte;

public class FindDuplicateByCountingOccur {

    public static String FindIntersection() {
        String[] strArr = new String[]{"11, 12, 14, 16, 20", "11, 12, 13, 18, 21"};
        StringUtils.print(strArr);

        String[] array1 = strArr[0].split(", ");
        String[] array2 = strArr[1].split(", ");
        int len1 = array1.length;
        int len2 = array2.length;

        int len = (len1 > len2) ? len1 : len2;

        String max1 = array1[len1 - 1];
        String max2 = array2[len2 - 1];
        int max = Integer.valueOf(max2);

        if (Integer.valueOf(max1) > Integer.valueOf(max2)) {
            max = Integer.valueOf(max1);
        }

        max++;

        int[] mark = new int[max];

        //
        for (int i = 0; i < len; i++) {
            if (i < len1) {
                int value1 = Integer.valueOf(array1[i]);
                mark[value1]++;
            }
            if (i < len2) {
                int value2 = Integer.valueOf(array2[i]);
                mark[value2]++;
            }
        }
        //

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < max; i++) {
            if (mark[i] > 1) {
                result.append(i);
                result.append(",");
            }
        }

        if (result.toString().length() == 0) {
            return "false";
        }

        String res = result.toString().substring(0, result.toString().length() - 1);

        return res;
    }

    // convert an array of integers into array of count number
    // in order to check the duplicate value item in the original array
    public static int[] convertListToCountArray(int[] arrayValue) {
        int[] arrayCount;

        // find the maximum int value in the origin array
        int arrayCountLength = 0;
        for (int item : arrayValue) {
            if (arrayCountLength < item) {
                arrayCountLength = item;
            }
        }

        // init the arrayCount
        arrayCount = new int[arrayCountLength];

        // assign value for item in arrayCount
        int len = arrayValue.length;
        for (int i = 0; i < len; i++) {
            int value = arrayValue[i];
            arrayCount[value]++;
        }

        return arrayCount;
    }

    /**
     * Have the function SimpleMode(arr) take the array of numbers stored in arr and return the number that appears
     * most frequently (the mode). For example: if arr contains [10, 4, 5, 2, 4] the output should be 4.
     * If there is more than one mode return the one that appeared in the array first (ie. [5, 10, 10, 6, 5]
     * should return 5 because it appeared first). If there is no mode return -1. The array will not be empty.
     */
    public static int simpleMode(int[] arr) {

        // get the counting item occurs array
        int[] countingArr = ArrayUtil.getCountingArray(arr);

        // get the indexes of max value in the counting array
        int[] indexes = ArrayUtil.getIndexesOfMaxItemInList(countingArr);

        // get the item that has most frequent occurs and appear first in the origin list
        for (int i : arr) {
            for (int j : indexes) {
                if (i == j) {
                    return i;
                }
            }
        }

        return -1;

    }


}
