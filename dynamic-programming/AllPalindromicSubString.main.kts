#!/usr/bin/env kotlin

//Problem link : https://leetcode.com/problems/palindromic-substrings/description/


val resp = countAllPalindromicSubStringV2("fdsklf")
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

fun countAllPalindromicSubStringV2(str:String):Int{
    if(str.length == 1) return 1
    if(str.length == 0) return 0
    val strLength = str.length
    val emptyListOf0 = MutableList(strLength){0}
    val table = MutableList(strLength){MutableList(strLength){0} }
    var count = 0;
    var i = 0
    var j = 0
    var diff = 0
    while(diff< strLength){
        j = i+diff
        while(j<strLength){
            if(diff == 0) {
                table[i][j] = 1
                count++
            }
            else if(diff == 1 && (str.get(i) == str.get(j)) ){
                table[i][j] = 1
                count++
            }
            else {
                table[i][j] = when((str.get(i) == str.get(j)) && table[i+1][j-1] ==  1){
                    true -> {
                        count++
                        1

                    }
                    else -> 0
                }
            }

            i++
            j++

        }
        i=0
        j=0
        diff++
    }

    return count
}
//[[0, 0, 0], [0, 0, 0], [0, 0, 0]]
//[[0, 0, 0]]

//[[1, 0, 0], [0, 0, 0], [0, 0, 0]



