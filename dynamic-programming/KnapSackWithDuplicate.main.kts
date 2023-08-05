#!/usr/bin/env kotlin


//Problem source: https://450dsa.com/dynamic_programming problem number 36
//Problem link : https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

val resp = main(listOf(1,4,5,7), listOf(1,3,4,5),8)
println(resp)

fun main(valueList:List<Int>, weightList:List<Int>,maxWeight:Int):Int{
    val table = MutableList(valueList.size+1){ emptyList<Int>().toMutableList()}
    (0..valueList.size).toList().map{
        table[it] = (0..maxWeight).toList().map{-1}.toMutableList()
    }
    return knapSack(valueList,weightList,maxWeight, table)

}


fun knapSack(valueList:List<Int>, weightList:List<Int>,maxWeight:Int, table:MutableList<MutableList<Int>>):Int{
    if(valueList.isEmpty() || maxWeight == 0) return 0
    if(table[valueList.size][maxWeight] != -1) return table[valueList.size][maxWeight]
    val valueIfEleIsIncluded =  when(maxWeight >= weightList.first()){
        true -> knapSack(valueList, weightList,maxWeight-weightList.first(), table) + valueList.first()
        else -> 0

    }
    val valueIfEleisExcluded = knapSack(valueList.drop(1), weightList.drop(1), maxWeight, table)
    val maxValue = maxOf(valueIfEleIsIncluded,valueIfEleisExcluded )
    table[valueList.size][maxWeight] = maxValue
    return  maxValue
}
//0,1,2,3
//4
//