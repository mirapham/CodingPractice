package mira.algo.array

/***
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 *
 * Input: nums = [1], target = 0
 * Output: -1
 *
 */

fun main(){
    val num = intArrayOf(1,2,3,4,5,6)
    val target = 3
    val result = search(num, target)
}


// rotate array first then search for target later
// [1,2,3,4,5,6,7] => [5,6,7,1,2,3,4]
fun search(nums: IntArray, target: Int): Int {

    val len = nums.size

    if(target < nums[0] || target > nums[len-1]) return -1

    // rotate array [1,2,3,4,5,6,7] with 4 => [5,6,7,1,2,3,4]

    val arr1 = nums.copyOfRange(target, len)
    val arr2 = nums.copyOfRange(0, target).toList()
    val arr = arr1.toMutableList()
        arr.addAll(arr2)

    for (i in arr){
        print("$i ")
    }

    return 0

}