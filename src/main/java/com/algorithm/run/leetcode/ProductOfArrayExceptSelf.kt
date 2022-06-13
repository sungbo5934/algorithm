package com.algorithm.run.leetcode

import java.util.Arrays

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {

        var resultArray: IntArray = IntArray(nums.size) { 0 }
        var duplicateNum: Int = 1
        var zeroCnt = 0

        for(i in nums.indices){
            if(nums[i] != 0){
                duplicateNum *= nums[i]
            }else{
                zeroCnt++
            }
        }

        for(i in nums.indices){
            if(zeroCnt > 1){
                break
            }else if(zeroCnt == 1){
                if(nums[i] == 0){
                    resultArray[i] = duplicateNum
                }
            }else{
                resultArray[i] = duplicateNum / nums[i]
            }
        }
        return resultArray
    }

}
fun main(arr: Array<String>){
    val intArray:IntArray = intArrayOf(-1,1,0,-3,3)
    println(ProductOfArrayExceptSelf().productExceptSelf(intArray).contentToString())

}