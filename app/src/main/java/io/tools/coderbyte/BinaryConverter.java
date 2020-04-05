package io.tools.coderbyte;

public class BinaryConverter {

    /**
     *  For example: if str is "47" then the binary version of this integer is 101111 but we pad it to be 00101111.
     *  Your program should reverse this binary string which then becomes: 11110100 and
     *  then finally return the decimal version of this string, which is 244.
     * */
    public static String BinaryReversal(String str) {
        int intValue = Integer.parseInt(str);

        // parse the integer to binary representative String
        String bin = Integer.toBinaryString(intValue);

        char[] arr = bin.toCharArray();

        // reverse the String order
        StringBuilder builder = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            builder.append(arr[i]+"");
        }

        // check the lastest 8*N then add more 0 to the end of the String
        int builderLength = builder.toString().length();
        // need to care about this edge case that no sodu cho length of string
        int soDu = builderLength % 8;
        if(builderLength > 8 && soDu != 0) {
            for (int j = 8; j > soDu; j--) {
                builder.append("0");
            }
        } else {
            for (int j = builder.toString().length(); j < 8; j++) {
                builder.append("0");
            }
        }

        String reverseString = builder.toString();

        // change the string representative to integer
        int result = Integer.parseInt(reverseString,2);

        return String.valueOf(result);
    }

    // convert the integer value to the binary representative string
    public static String convertIntToBinaryString(int intValue) {
        String bin = Integer.toBinaryString(intValue);
        return bin;
    }

    // convert the binary representative String to integer value
    public static int convertBinaryStringToInt(String bin) {
        int result = Integer.parseInt(bin, 2);
        return result;
    }
}
