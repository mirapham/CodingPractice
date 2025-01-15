package mira.algo.dynamicprogramming

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * */

fun main() {
    val arr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val maxSum = maxSubArray(arr)
    println(maxSum)
}

fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxSoFar = nums[0]
    var maxAtIndex = nums[0]

    for (i in 1 until nums.size) {
        maxAtIndex = maxOf(nums[i], maxAtIndex + nums[i])
        maxSoFar = maxOf(maxSoFar, maxAtIndex)
    }

    return maxSoFar
}

