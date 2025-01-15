package mira.algo.array

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * */

fun main() {
    val num = intArrayOf(0,1,0,3,12)
    moveZeroes(num)
}

fun moveZeroes(nums: IntArray): Unit {

    for (i in nums) {
        print(i)
    }

    val len = nums.size - 1

    var zeroIndex = -1
    for (i in 0..len) {
        if (nums[i] == 0) {
            zeroIndex = i
            break
        }
    }

    if(zeroIndex == -1) return

    for(i in zeroIndex..len){
        if(nums[i] != 0) {
            nums[zeroIndex++] = nums[i]
            nums[i] = 0
        }
    }

    println()
    for (i in nums) {
        print(i)
    }
}