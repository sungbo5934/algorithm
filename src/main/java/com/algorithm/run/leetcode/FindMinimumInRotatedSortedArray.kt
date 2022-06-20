package com.algorithm.run.leetcode

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var result = Int.MAX_VALUE
        var before = 0
        for(i in nums.indices){
            if(nums[i] < before){
                result = nums[i]
                break
            }
            before = nums[i]
            if(nums[i] < result){
                result = nums[i]
            }
        }


        return result
    }
}

fun main(arr: Array<String>){

    val param: IntArray = intArrayOf(11,13,15,17)
    println(FindMinimumInRotatedSortedArray().findMin(param))
}