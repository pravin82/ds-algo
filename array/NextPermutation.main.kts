#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 14
//Problem link : https://leetcode.com/problems/next-permutation/
//Learning: we should change the least significant number to get the next permuation.
//hence we should iterate the array from end
//we can only interchnage such number whose next value is greater than the current value
//if that will not be the case we will not get lexographically greater number
//hence iterate the array from last and find such element whose next element has greater value
//now that number should be replaced with least number in right part of the list whose  value is greater than number to be replaced
//now we will interchange the elements . if you notice the right side of the array index where we replaced the number that is in descending order. we will
//just have to reverse the array to get the desired result

val resp = nextPermutation(listOf(8,3,7,6,5,2).toMutableList())
println(resp)


fun nextPermutation(nums:MutableList<Int>):List<Int>{
    var indexToChange = -1
    for (i in nums.indices){
        val index  = nums.size-1-i
        if(index == 0) break
        if((nums[index] - nums[index-1]> 0)) indexToChange = index-1
    }
    if(indexToChange == -1) reverseTheArray(nums)
    else {
        var indexToReplacedWith = -1
        val eleToReplace = nums[indexToChange]
        for (i in nums.size-1 downTo  indexToChange+1 ){
            if( eleToReplace < nums[i] ){
                indexToReplacedWith = i
                break
            }
        }
        nums.set(indexToChange, nums[indexToReplacedWith])
        nums.set(indexToReplacedWith, eleToReplace)
        nums.subList(indexToChange+1, nums.size).reverse()
    }
    return nums
}




fun reverseTheArray(nums:MutableList<Int>){
    for (i in 0..nums.size-1){
        val ele = nums[i]
        val secondIndex = nums.size-1-i
        nums.set(i, nums[secondIndex])
        nums.set(secondIndex,ele)
    }
}