#!/usr/bin/env kotlin

//Problem link : https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1
//Problem Source: https://450dsa.com/string Problem no 11
//Related problem: https://leetcode.com/problems/count-binary-substrings/

fun countBalancedBinaryString(str:String):Int{
    var count = 0
    for(i in str.indices){
        var sameCount = 1
        var diffCount = 0

        for(j in i+1..str.length-1){
            if(diffCount > 0 && str.get(i) == str.get(j)) break
            if(str.get(i) == str.get(j)) sameCount++
            else diffCount++
            if(sameCount == diffCount){
                //  println("ij:${i}:${j}")
                count++
                break
            }
        }

    }
    return count
}