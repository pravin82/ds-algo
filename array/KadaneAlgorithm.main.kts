#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 7
//Problem link : https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1

fun getMaxSum(arr:List<Int>):Int{
    var currentSum = 0
    var maxSum = Integer.MIN_VALUE
  arr.map{
      currentSum += it
      if(currentSum >  maxSum) maxSum = currentSum
      if(currentSum < 0) currentSum = 0
  }
    return maxSum
}