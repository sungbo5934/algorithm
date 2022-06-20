package com.algorithm.run.leetcode

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class SearchInRotatedSortedArray {
    fun search(nums: IntArray, target: Int): Int {
        var result:Int = -1

        var start:Int = 0
        var end:Int = nums.size - 1
        while (start <= end){
            var pivot: Int = start + (end - start) / 2

            if(nums[pivot] == target) {
                result = pivot
                break
            }

            if(nums[pivot] >= nums[start]){
                if(target >= nums[start] &&  target < nums[pivot]){
                    end = pivot -1
                }else{
                    start = pivot +1
                }
            }else{
                if(target > nums[pivot] &&  target <= nums[end]){
                    start = pivot + 1
                }else{
                    end = pivot - 1
                }
            }
        }

        return result

    }
}

fun main(arr: Array<String>){
    val param: IntArray = intArrayOf(1,3)
    val target: Int = 3
    println(SearchInRotatedSortedArray().search(param, target))
}