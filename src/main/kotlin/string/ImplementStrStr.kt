package mira.algo.string

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 * */
fun main() {
    val index = strStr2("sadbutsad", "sad")
    println(index)
}

// Similar to contain function in String
fun strStr(haystack: String, needle: String): Int {
    val len1 = haystack.length
    val len2 = needle.length

    if(len1 == len2 && haystack == needle) return 0

    for(i in 0..len1){
        if(i+len2 <= len1) {
            val subStr = haystack.subSequence(i, i + len2)
            println(subStr)
            if (subStr == needle) return i
        }
    }

    return -1

}

// * Input: haystack = "abc", needle = "c"
// iterate index on both strings and compare
fun strStr2(haystack: String, needle: String): Int {
    val len1 = haystack.length
    val len2 = needle.length

    var index1 = 0
    var index2 = 0

    while(index1 < len1 && index2 < len2 && index1+index2<len1){

        if(index2 == len2) return index1

        if(haystack[index1+index2] == needle[index2]){
            index2++
        } else {
            index1++
            index2 = 0
        }
    }

    if(index2 == len2) return index1

    return -1

}