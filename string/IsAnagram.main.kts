#!/usr/bin/env kotlin

//Problem link : https://practice.geeksforgeeks.org/problems/print-anagrams-together/1

fun isAnagram(str1:String, str2:String):Boolean{
    if(str1.length != str2.length) return false
    val eleMap = mutableMapOf<Char,Int>()
    str2.map{
        val value = eleMap.get(it)?:0
        eleMap.put(it, value+1)
    }
    str1.map{
        if(eleMap.get(it) == null || eleMap.get(it) == 0) return false
        val value = eleMap.get(it)?:0
        eleMap.put(it, value-1)

    }
    return true
}