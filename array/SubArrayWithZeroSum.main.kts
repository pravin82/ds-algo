#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 20
//Problem link : https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1

val resp = isSubArrayWithZeroSum(listOf(4,2,0,1,6))
println(resp)

fun isSubArrayWithZeroSum(arr:List<Int>):Boolean{
    for (i in arr.indices){
        if(arr[i] == 0 ) return true
    }
    val eleMap = mutableMapOf<Int,Int>()
    var sum = 0
    arr.map{
      sum=sum+it
        if(sum == 0) return true
      val eleValue = eleMap.get(sum)?:0
        eleMap.put(sum,eleValue+1)
    }
    eleMap.values.map{
       if(it > 1) return true
    }
    return false

}