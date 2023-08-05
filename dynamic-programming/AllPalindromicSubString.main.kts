#!/usr/bin/env kotlin

//Problem link : https://leetcode.com/problems/palindromic-substrings/description/


val resp = countAllPalindromicSubString("aaa")
println(resp)

fun countAllPalindromicSubString(str:String):Int{
    if(str.length == 1) return 1
    if(str.length == 0) return 0
    val count = countAllPalindromicSubString(str.drop(1)) + getNumberOfPalindromeFromSubstringWithFirstEle(str)
    return count
}


fun isStringPalindrome(str:String):Boolean{
    return str == str.reversed()
}

fun getNumberOfPalindromeFromSubstringWithFirstEle(str:String):Int{
    if(str.length == 0) return 0
    if(str.length == 1) return 1
   var count = 1
   for (i in  1..(str.length-1)){
    val strSubs =  str.slice(0..i)
       if(isStringPalindrome(strSubs)) count++
   }
    return count
}
