package com.algorithm.run.leetcode

/**
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var intArray: IntArray =  intArrayOf()
        loop1@ for( i in nums.indices){
            val first = nums[i]
            for( j in i+1 until nums.size){
                if(nums[j] == target - first) {
                    intArray =  intArrayOf(i,j)
                    break@loop1
                }
            }
        }
        return intArray
    }
}