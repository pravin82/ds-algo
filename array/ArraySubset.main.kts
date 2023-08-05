#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 26
//Problem link : https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
val resp = isSubset(listOf(10, 5, 2, 23, 19), listOf(19, 5, 3))
println(resp)

fun isSubset(arr1:List<Int>, arr2:List<Int>):Boolean{
    val arr1Ele = mutableMapOf<Int, Int>()
    arr1.map{
        arr1Ele.put(it, 1)

    }
    var isSubset = true
    arr2.map{
       if(arr1Ele.get(it) ==  null)  isSubset = false
    }
    return isSubset
}