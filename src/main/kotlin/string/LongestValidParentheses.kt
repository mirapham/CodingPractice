package mira.algo.string

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 * .
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 * */

fun main(){
    val s = "()()"
    println(longestValidParenthesesSubString(s))
}

//* Input: s = "()(()"
//* Output: 2 #4
fun longestValidParenthesesSubString(s: String): Int {
    val len = s.length - 1

    var count = 0
    val list = mutableListOf<Char>()
    var max = 0

    // find the first '('
    val firstIndexToStart = firstIndexToStart(s)

    if(firstIndexToStart < 0) return 0

    for(i in firstIndexToStart..len){
        val c = s[i]

        if(list.contains(c.pair())) {
            list.remove(c.pair())
            count += 2

            max = maxOf(max, count)
        } else {
            count = 0
            list.add(c)
        }
    }

    // list : [(]
    if(list.size < 2) {
        return max
    } else { // [(()]

    }

    return max
}

fun Char.pair(): Char {
    return if(this == '(') ')' else '('
}

fun firstIndexToStart(s: String): Int {
    for(i in 0..s.length-1){
        if(s[i] == '(') return i
    }

    return -1
}