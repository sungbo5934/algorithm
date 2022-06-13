package com.algorithm.run.leetcode

import java.util.*

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var result: Int = 0
        var min: Int = prices[0]
        for (i in 1..prices.size-1 ) {
            val num: Int = prices[i]
            if(num < min){
                min = prices[i]
            }else{
                if(num  - min > result){
                    result = num  - min
                }
            }
        }
        return result
    }
}

fun main(string: Array<String>){
    val stock: IntArray  = intArrayOf(2,4,1)
    println(BestTimeToBuyAndSellStock().maxProfit(stock))
}