#!/usr/bin/env kotlin


//Problem source: https://450dsa.com/dynamic_programming problem number 30
//Problem link : https://www.geeksforgeeks.org/minimum-removals-array-make-max-min-k/

val resp = minRemovalFromArray(listOf(1, 5, 6, 2, 8), 2)
println(resp)

fun minRemovalFromArray(arr:List<Int>, maxDiff:Int):Int{
    if(arr.size == 0) return 0
    val sortedArr = arr.sorted().toMutableList()
    var isDiffLessThanTarget = false
    var removedEleCount = 0
    while(!isDiffLessThanTarget && sortedArr.isNotEmpty()){
        if(sortedArr.size <= 2) return removedEleCount
        val diff =  sortedArr.last() - sortedArr.first()
        if(diff <= maxDiff) isDiffLessThanTarget = true
        else {
            val firstElement = sortedArr.getOrNull(1)?:0
            val startDiff = firstElement-sortedArr.first()
            val secondLastElement = sortedArr.getOrNull(sortedArr.size-2)?:0
            val lastDiff = sortedArr.last()- secondLastElement
            if(lastDiff > startDiff) sortedArr.removeAt(sortedArr.size-1)
            else sortedArr.removeAt(0)
            removedEleCount++
        }

    }
    return removedEleCount



}



