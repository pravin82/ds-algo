#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/dynamic_programming problem number 1
//Problem link : https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

val resp = main(listOf(1,2,3), listOf(4,5,1),3)
println(resp)

fun main(valList:List<Int>, weightList:List<Int>, maxWeight:Int):Int{
    val table = MutableList(valList.size) { emptyList<Int>().toMutableList() }
    (0..valList.size-1).toList().map{
        table.set(it,(0..maxWeight-1).toList().map{-1}.toMutableList())
    }
   return  knapSack(valList, weightList, maxWeight, table)
}

fun knapSack(valList:List<Int>, weightList:List<Int>, maxWeight:Int, table:MutableList<MutableList<Int>>):Int{
    if(maxWeight == 0 || valList.isNullOrEmpty()) return 0
    if(table.get(valList.size-1).get(maxWeight-1) != -1) return table.get(valList.size-1).get(maxWeight-1)
    val newValList = valList.drop(1)
    val eleWeight = weightList.get(0)
    val firstValue = valList.get(0)
    val newWeightList= weightList.drop(1)
    val sumIfElemIsIncluded = when(eleWeight <= maxWeight){
        true -> knapSack(newValList,newWeightList, maxWeight-eleWeight,table)  +  firstValue
        else -> 0
    }
    val sumIfEleIsExcluded = knapSack(newValList, newWeightList,maxWeight,table)
    val sum = maxOf(sumIfEleIsExcluded, sumIfElemIsIncluded)
    table[valList.size-1][maxWeight-1] = sum
    return sum

}

//maxKnapSack(w) = value + maxKnapSack(w-eleWeight)
// sum =
