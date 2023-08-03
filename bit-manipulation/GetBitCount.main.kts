#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/bit_manipulation problem number 0
//Problem link : https://practice.geeksforgeeks.org/problems/set-bits0143/1

val resp = countDistinctBits(10)
println(resp)

fun countDistinctBits(inputNumber:Int):Int{
    var number = inputNumber
    val bitList = mutableListOf<Int>()
    while(number > 0){
        val bit = (number%2)
        if(bit ==  1) bitList.add(bit)
        number = number / 2
    }
    return bitList.size

}





