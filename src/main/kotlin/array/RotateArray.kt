package mira.algo.array

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * */

fun main(){
    val nums = intArrayOf(1,2,3)
    val k = 2
    rotate(nums, k)
}

// [-1,-100,3,99] => [3,99,-1,-100]
fun rotate(nums: IntArray, k: Int): Unit {

    val n = nums.size
    val steps = k % n

    nums.reverse()
    nums.reverse(0, steps)
    nums.reverse(steps, n)

    for(i in nums){
        print(i)
    }
}