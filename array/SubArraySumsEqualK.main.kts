#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 20
//Problem link : https://leetcode.com/problems/subarray-sum-equals-k/description/
val resp = getNumbeerOfSubArray(listOf(1,2,3), 3)
println(resp)

fun getNumbeerOfSubArray(arr:List<Int>, target:Int):Int{
    var sum = 0
    val sumMap = mutableMapOf<Int, Int>()

    var count = 0
    arr.map{
        sum = sum+it
        if(sum == target) count++
        val  eleValue1 = sumMap.get(sum-target)?:0
        count = count+eleValue1
        val eleValue = sumMap.get(sum)?:0

        sumMap.put(sum,eleValue+1)

    }
    return count
}