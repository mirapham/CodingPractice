package mira.algo.string

/**
 * Given a string s, return the longest
 * palindromic
 *
 * substring
 *  in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 * */

fun main(){
    val res = longestPalindrome("aa")
    println(res)
}

//* Input: s = "babad"
//* Output: "bab"
fun longestPalindrome(s: String): String {
    val len = s.length-1
    var longest = ""

    if(len == 0) return s

    val strBuilder = StringBuilder()

    for(i in 0..len-1) {
        strBuilder.clear()
        strBuilder.append(s[i])
        for(j in i+1..len) {
            strBuilder.append(s[j])
            if(isPalidrome(strBuilder.toString())){
                if(longest.length < strBuilder.toString().length){
                    longest = strBuilder.toString()
                }
            }
        }
    }

    if(longest.isEmpty()){
        longest = s[0].toString()
    }

    return longest

}

fun isPalidrome(str: String): Boolean{
    val len = str.length - 1
    for(i in 0..len){
        if(str[i] != str[len-i]) return false

        if(i > len/2) break
    }

    return true

}