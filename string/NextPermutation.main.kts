#!/usr/bin/env kotlin

//Problem link : https://practice.geeksforgeeks.org/problems/next-permutation5226/1
//Problem Source: https://450dsa.com/string Problem no 14

fun findNextPermutation(arr:MutableList<Int>):List<Int>{
    if(arr.isEmpty()) return arr
    var indexToReplace = -1
    var indexToBeReplacedWith = -1
    for(i in arr.size-1 downTo 1){
        if(arr[i] > arr[i-1]) indexToReplace = i-1
    }
    if(indexToReplace == -1) return arr.reversed()
    for(i in arr.size-1 downTo indexToReplace+1){
        if(arr[i] > arr[indexToReplace]){
            indexToBeReplacedWith = i
            break
        }

    }
    val elementToReplace = arr[indexToReplace]
    arr.set(indexToReplace, arr[indexToBeReplacedWith])
    arr.set(indexToBeReplacedWith,elementToReplace)
    arr.subList(indexToReplace+1,arr.size-1).reverse()
    return arr



}