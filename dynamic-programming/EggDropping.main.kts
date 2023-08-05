#!/usr/bin/env kotlin


//Problem source: https://450dsa.com/dynamic_programming problem number 22
//Problem link : https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

val resp = main(2,10)
println(resp)

fun main(eggCount:Int, floorCount:Int):Int{
    val table  = MutableList(eggCount+1){ MutableList(floorCount+1){-1} }
    populateTable(eggCount, floorCount, table)
    println(table)
    val minIteration = getMinAttempt(eggCount, floorCount, table)
    return minIteration



}

fun getMinAttempt(eggCount:Int, floorCount:Int, table:MutableList<MutableList<Int>>):Int{
    if(eggCount == 1 || floorCount in (0..1)) return floorCount
    if(table[eggCount][floorCount] != -1){
        println("here")
        return table[eggCount][floorCount]
    }

    val numbers =   (1..floorCount).toList().map{
        getMinAttemptFromParticularFloorV2(eggCount, floorCount, it, table)
    }
   return numbers.minOrNull()?:0


}

fun getMinAttemptFromParticularFloor(eggCount:Int, floorCount:Int,floorNo:Int, table:MutableList<MutableList<Int>>):Int{
    val countIfEggBreaks = getMinAttempt(eggCount-1, floorNo-1,table)
    val countIfEggDoesNotBreak = getMinAttempt(eggCount, floorCount-floorNo,table)
    return 1 + maxOf(countIfEggBreaks, countIfEggDoesNotBreak)

}

fun getMinAttemptFromParticularFloorV2(eggCount:Int, floorCount:Int,floorNo:Int, table:MutableList<MutableList<Int>>):Int{
    val countIfEggBreaks = table[eggCount-1][floorNo-1]
    val countIfEggDoesNotBreak =  table[eggCount][floorCount-floorNo]
    return 1 + maxOf(countIfEggBreaks, countIfEggDoesNotBreak)

}


fun populateTable(eggCount:Int, floorCount:Int, table:MutableList<MutableList<Int>>){
    var i = 1
    var j = 1
    for(x in 0..floorCount){
        table[0][x] = 0
    }
    for(x in 0..eggCount){
        table[x][0] = 0
    }
    for (x in 0..eggCount){
        table[x][1] = 1
    }

    while(i<= eggCount){
        while(j<=floorCount){
            if(i == 1) table[i][j] = j
            else {
                var res = Integer.MAX_VALUE
                for(x in (1..j)){
                    val steps = 1+ maxOf(table[i-1][x-1], table[i][j-x])
                    if(steps <= res) res = steps

                }
                table[i][j] = res
            }
            j++
        }
        j=1
        i++

    }
}