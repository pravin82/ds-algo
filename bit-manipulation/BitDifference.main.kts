#!/usr/bin/env kotlin
//Problem source: https://450dsa.com/bit_manipulation problem number 2
//Problem link : https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1

val resp = findBitDifferenceV2(20,25)
println(resp)

fun findBitDifference(a:Int, b:Int):Int{
    var axorb= a xor b
    var count = 0
    while(axorb > 0){
       if(axorb%2 == 1)  count++
        axorb = axorb/2
    }
    return count

}

fun findBitDifferenceV2(a:Int, b:Int):Int{
    var axorb= a xor b
    var count = 0
    while(axorb > 0){
        val rsbm = getRightMostSetBitMasked(axorb)
        axorb = axorb-rsbm
        count++
    }
    return count

}

fun getRightMostSetBitMasked(a:Int):Int{
    val inverseA = a.inv()
    val twoComplementOfA = inverseA +1
    return a and twoComplementOfA
}



fun getBits(a:Int):String{
   val resp =  a.toString(2)
    println("Resp:${resp}")
    return resp

}
