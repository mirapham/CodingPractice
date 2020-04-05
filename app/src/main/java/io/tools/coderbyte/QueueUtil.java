package io.tools.coderbyte;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUtil {

    /**
     * Have the function StringReduction(str) take the str parameter being passed and return the smallest number you can
     * get through the following reduction method. The method is: Only the letters a, b, and c will be given in str and you
     * must take two different adjacent characters and replace it with the third. For example "ac" can be replaced with
     * "b" but "aa" cannot be replaced with anything. This method is done repeatedly until the string cannot be further
     * reduced, and the length of the resulting string is to be outputted. For example: if str is "cab", "ca" can be
     * reduced to "b" and you get "bb" (you can also reduce it to "cc"). The reduction is done so the output should be 2.
     * If str is "bcab", "bc" reduces to "a", so you have "aab", then "ab" reduces to "c", and the final string "ac" is
     * reduced to "b" so the output should be 1.
     */
    public static String reduceString(String originalString) {
        // use queue to process this

        Queue<String> queue = new LinkedList<String>();

        // put each item in to queue

        for (char c : originalString.toCharArray()) {
            queue.add(String.valueOf(c));

            changeQueue(queue);

        }

        if (canChangeQueue(queue)) {
            changeQueue(queue);
        }

        return String.valueOf(queue.size());

    }

    private static void changeQueue(Queue<String> queue) {
        if (queue.size() == 1) {
            return;
        }

        String value = (String) ((LinkedList) queue).get(queue.size() - 1) + (String) ((LinkedList) queue).get(queue.size() - 2);

        if (value.equals("ab") || value.equals("ba")) {
            ((LinkedList) queue).remove(queue.size() - 1);
            ((LinkedList) queue).remove(queue.size() - 1);
            queue.add("c");
        }

        if (value.equals("ac") || value.equals("ca")) {
            ((LinkedList) queue).remove(queue.size() - 1);
            ((LinkedList) queue).remove(queue.size() - 1);
            queue.add("b");
        }

        if (value.equals("bc") || value.equals("cb")) {
            ((LinkedList) queue).remove(queue.size() - 1);
            ((LinkedList) queue).remove(queue.size() - 1);
            queue.add("a");
        }

        if (canChangeQueue(queue)) {
            changeQueue(queue);
        }
    }

    private static boolean canChangeQueue(Queue<String> queue) {
        if (queue.size() == 1) {
            return false;
        }

        String value = (String) ((LinkedList) queue).get(queue.size() - 1) + (String) ((LinkedList) queue).get(queue.size() - 2);

        if (value.equals("ab") || value.equals("ba")) {
            return true;
        }

        if (value.equals("ac") || value.equals("ca")) {
            return true;
        }

        if (value.equals("bc") || value.equals("cb")) {
            return true;
        }

        return false;
    }
}
