package mira.algo.string

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * */

fun main() {
    val s = " "
    val result = lengthOfLongestSubstring(s)
    println(result)
}

//* Input: s = "bbbb"
//* Output: 3
fun lengthOfLongestSubstring(s: String): Int {
    val len = s.length - 1
    val map = HashMap<Char, Int>()
    var max = 0

    if(len == 0) return 1

    for (i in 0..len - 1) {
        map.clear()
        map[s[i]] = i
        var count = 1
        for (j in i + 1..len) {
            if (map.contains(s[j])) {
                break
            } else {
                map[s[j]] = j
                count++
            }

        }
        max = maxOf(max, count)
    }


    return max
}