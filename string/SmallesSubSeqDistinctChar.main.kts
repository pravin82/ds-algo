#!usr/bin/env kotlin

//Problem Link : https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
import java.util.ArrayDeque

fun getSmallestSubsequenceOfDistinctChar(str:String):String{
    val eleMap = mutableMapOf<Char, Int>()
    str.map{
        val value = eleMap.get(it)?:0
        eleMap.put(it, value+1)
    }
    val alreadySeenMap = mutableMapOf<Char,Boolean>()
    val stack = ArrayDeque<Char>()
    stack.push(str.get(0))
    alreadySeenMap.put(str.get(0), true)
    for(i in 1..str.length-1){
        if(stack.contains(str.get(i))) {
            eleMap.put(str.get(i),(eleMap.get(str.get(i))?:0)-1)
            continue
        }
        while(stack.size > 0 && stack.peek() > str.get(i)){
            val eleCount = eleMap.get(stack.peek())?:0
            val ele = stack.peek()
            if(eleCount > 1) {
                eleMap.put(ele,eleCount-1)
                stack.pop()
                alreadySeenMap.put(ele, false)
            }
            else break
        }
        if(!(alreadySeenMap.get(str.get(i))?:false)){
            stack.push(str.get(i))
            alreadySeenMap.put(str.get(i), true)
        }
    }



    return String(stack.reversed().toCharArray())


}




//babc
//bdbc
//dbc
//bdc

