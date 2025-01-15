package mira.algo.array

import mira.algo.string.strStr2

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 * */

fun main() {
    val digits = intArrayOf(1,2,9)
    val result = plusOne2(digits)
//    println("Rsult = $result")
}

fun plusOne(digits: IntArray): IntArray {
    val len = digits.size

    val result = recursive(len - 1, digits)

    for (i in result) print("$i  ")

    return result

}

fun recursive(index: Int, digits: IntArray): IntArray {
    val lastDigit = digits[index]

    val len = digits.size

    if (lastDigit < 9) {
        digits[index] = lastDigit + 1
        return digits
    } else {
        digits[index] = 0

        // 999 -> 1000
        if (index == 0) {
            val newArr = IntArray(len + 1) { 0 }
            newArr[0] = 1
            return newArr
        } else {
            return recursive(index - 1, digits)
        }
    }
}

// 1,2,3
fun plusOne2(digits: IntArray): IntArray {
    val size = digits.size
    var cur = 10
    var i = size - 1
    do {
        if (cur > 9) cur = 1 else cur = 0
        cur = cur + digits[i]
        digits[i] = if (cur > 9) 0 else cur
        i--
    } while (i >= 0)
    if (cur > 9) return IntArray(size + 1) { if (it == 0) 1 else digits[it - 1] }
    return digits
}