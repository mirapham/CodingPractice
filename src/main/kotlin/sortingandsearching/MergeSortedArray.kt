package mira.algo.sortingandsearching

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * */
fun main() {
    val num1 = intArrayOf(1,2,3,0,0,0)
    val num2 = intArrayOf(2,5,6)
    val m = 3
    val n = 3
    val result = merge(num1, m, num2, n)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var index1 = 0
    var index2 = 0

    val newArr = IntArray(n+m){0}
    var count = 0

    while(index1 < m && index2 < n){
        if(nums1[index1] < nums2[index2]){
            newArr[count++] = nums1[index1]
            index1++
        } else {
            newArr[count++] = nums2[index2]
            index2++
        }
    }

    while(index1 < m){
        newArr[count++] = nums1[index1++]
    }

    while(index2 < n){
        newArr[count++] = nums2[index2++]
    }

    var i = 0
    while(i<count){
        nums1[i] = newArr[i]
        i++
    }

//    for(i in nums1) print(" $i")

}