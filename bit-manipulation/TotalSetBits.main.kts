#!/usr/bin/env kotlin
import kotlin.math.pow

//Problem source: https://450dsa.com/bit_manipulation problem number 3
//Problem link : https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
//Learning: If you write the bits to some numbers you will find the pattern of set bits .
// in least significant bits it appears alternatively. after that it appears after two row but twice consecutively and so on
//0  0	0	0	0	0
//1	 0	0	0	0	1
//2	 0	0	0	1	0
//3  0	0	0	1	1
//4	 0	0	1	0	0
//5	 0	0	1	0	1
//6	 0	0	1	1	0
//7	 0	0	1	1	1
//8	 0	1	0	0	0
//9	 0	1	0	0	1
//10 0	1	0	1	0
//11 0	1	0	1	1
//12 0	1	1	0	0
//13 0	1	1	0	1
//14 0	1	1	1	0
//15 0	1	1	1	1
//16 1	0	0	0	0

val resp = countSetBits(17)
println(resp)

fun countSetBits(n:Int):Int{
    if(n <= 0) return 0
    val maxPower = findMaxPowerOf2(n+1)
    val maxNumberMultipleOfPw2 = 2.0.pow(maxPower).toInt()
    val setBitsTillNearest2Power =  (maxNumberMultipleOfPw2/2)*(maxPower)
    val restNumber = n-maxNumberMultipleOfPw2+1
    val bitsOfRestNumber =  restNumber + countSetBits(restNumber-1)
    return setBitsTillNearest2Power + bitsOfRestNumber
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