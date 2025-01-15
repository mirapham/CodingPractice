package mira.algo.dynamicprogramming

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * */

fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    val result = maxProfit(prices)
    println(result)
}

// buy and sell 1 time only
//[7,1,5,3,6,4] => 6 - 1 = 5
fun maxProfit(prices: IntArray): Int {
    val len = prices.size - 1

    var maxProfit = 0

    // O(N*N)
    for(i in 0..len-1){
        for(j in i+1..len) {
            var profitAtI = prices[j] - prices[i]

            maxProfit = maxOf(maxProfit, profitAtI)

            print("$profitAtI ")
        }

        println()
    }

    return maxProfit

}

