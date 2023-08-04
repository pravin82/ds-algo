#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/bit_manipulation problem number 5
//Problem link : https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
val resp = findOnlySetBit(16)
println(resp)

fun findOnlySetBit(n:Int):Int{
    var numberVar = n
    var count = 0
    var index = 1
    var iterationNumber = 1
    while(numberVar > 0){
        val bit = numberVar %2
        if(bit ==1 ) {
            count++
            index = iterationNumber
        }
        numberVar = numberVar /2
        iterationNumber++
    }
    return when(count == 1){
        true -> index
        else -> -1
    }
}