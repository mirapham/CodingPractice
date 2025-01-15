package mira.algo.dynamicprogramming

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * */

fun main(){
    val result = climbStairs(4) // 1,1,1,1/ 1,1,2 / 2,1,1 / 2,2/ 1,2,1
    println(result)
}

fun climbStairs(n: Int): Int {
    if (n <= 1) return 1

    val dp = IntArray(n + 1)
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
        println(dp[i])
    }

//    println()
    return dp[n]
}