package com.algorithm.run.leetcode

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var result:Int = Int.MIN_VALUE
        var start: Int? = null
        var add: Int = 0
        if(nums.size == 1){
            return nums[0]
        }
        for(i in  nums.indices){
            if(start == null){
                if(nums[i] > 0 ){
                    start = nums[i]
                    add = nums[i]
                }
                if(result < nums[i]){
                    result = nums[i]
                }

            }else {
                if (add + nums[i] < 0) {
                    if (result < add + nums[i]) {
                        result = add + nums[i]
                    }
                    start = null
                    add = 0
                } else {
                    add += nums[i]
                    if(result < add){
                        result = add
                    }
                }
            }

        }
        return result
    }
}
fun main(arr: Array<String>){
    val param: IntArray = intArrayOf(-2, 1)
    println(MaximumSubarray().maxSubArray(param))

}