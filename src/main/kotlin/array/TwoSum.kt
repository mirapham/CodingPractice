package mira.algo.array

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * */

fun main() {
    val A = intArrayOf(3,3)
    val target = 6
    val res = twoSum(A, target)
    for (i in res) {
        print("$i ")
    }
}

//  * Input: nums = [2,7,11,15], target = 9
// * Output: [0,1]
fun twoSum(nums: IntArray, target: Int): IntArray {
    val len = nums.size - 1

    val result = mutableListOf<Int>()

    val map = HashMap<Int, Int>()

    for(i in 0..len){
        val value = nums[i]

        if(map.contains(target - value)) {
            result.add(map[target - value]!!)
            result.add(i)
            map.remove(target - value)
        } else {
            map[value] = i
        }
    }

    return result.toIntArray()

}