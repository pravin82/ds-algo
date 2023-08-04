#!/usr/bin/env kotlin
import kotlin.math.pow

//Problem source: https://450dsa.com/bit_manipulation problem number 4
//Problem link : https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
val resp = isPowerOf2(98)
println(resp)

fun isPowerOf2(n:Int):Boolean{
    val maxPowerOf2 = findMaxPowerOf2(n)
    return 2.0.pow(maxPowerOf2).toInt() == n
}

fun findMaxPowerOf2(n:Int):Int{
    var numberVar = n;
    var count = 0
    while(numberVar> 1){
        numberVar = numberVar/2
        count++
    }
    return count
}