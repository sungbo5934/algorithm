package com.algorithm.run.leetcode

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        var result: Boolean = false
        var numsMap: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
        for (i in nums.indices){
            var isExist:Int = numsMap.getOrDefault(nums[i], 0)
            if(isExist != 0){
                result = true
                break
            }
            numsMap.put(nums[i], isExist + 1)
        }
        return  result
    }
}

fun main(args: Array<String>){
    var parameterArr: IntArray = intArrayOf(1,2,3,4,5,6)
    println(ContainsDuplicate().containsDuplicate(parameterArr))
}