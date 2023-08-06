#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 17
//Problem link : https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

val resp = getNumberofPairsForTarget(listOf(1,1,1,1),2)
println(resp)

fun getNumberofPairsForTarget(arr:List<Int>, target:Int):Int{
  val eleMap = mutableMapOf<Int,Int>()
    var count = 0
    arr.map{
        val diff = target-it
        if(eleMap.get(diff) != null) {
            count += eleMap.get(diff)?:0
        }
        val eleValue = eleMap.get(it)?:0
        eleMap.put(it,eleValue+1)

    }
    return count
}