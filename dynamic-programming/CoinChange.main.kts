#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/dynamic_programming problem number 0
//Problem link : https://practice.geeksforgeeks.org/problems/coin-change2448/1
val resp = main(listOf(1,2),5)
println(resp)



fun main(arr:List<Int>,sum:Int):Int{
    val table = MutableList(sum) { emptyList<Int>().toMutableList() }
   (0..sum-1).toList().map{
        table.set(it,(0..arr.size-1).toList().map{0}.toMutableList())
    }
    val resp =  possibleWaysOfSum2(arr,sum, table)
    return resp
}

fun possibleWaysOfSum(arr:List<Int>,sum:Int):Int{
    if(sum == 0) return 1
    else if(sum < 0) return 0
    if(arr.isEmpty()) return 0
    val newArr = arr.drop(1)
   val count =  possibleWaysOfSum(arr,sum-arr[0]) + possibleWaysOfSum(newArr, sum)
    return count

}

fun possibleWaysOfSum2(arr:List<Int>,sum:Int, table:MutableList<MutableList<Int>>):Int{
    if(sum == 0) return 1
    else if(sum < 0) return 0
    if(arr.isEmpty()) return 0
    println(table)
    if(!table.isNullOrEmpty() && !table[sum-1].isNullOrEmpty() && table[sum-1][arr.size-1] != 0) return table[sum-1][arr.size-1]
    val newArr = arr.drop(1)
    val count =  possibleWaysOfSum2(arr,sum-arr[0], table) + possibleWaysOfSum2(newArr, sum, table)
    table[sum-1][arr.size-1] = count
    return count

}

//N = 3, sum = 4
//coins = {1,2,3}
//1,1,1,1  1,2,1,  2,2
//(1,2) , 3 +  ,( 1,2)  2
//(1,2 , 2  )+ (1,2,1) + ((1,2) ,1) + (1,2 ,0)
//2 + 1+1+0

//1 count = possibleWaysOfSum(3)
// 1, possibleWaysofsumm(3) ->

