#!/usr/bin/env kotlin

import kotlin.math.pow

//Problem source: https://450dsa.com/dynamic_programming problem number 2
//Problem link : https://practice.geeksforgeeks.org/problems/ncr1019/1

val resp = findNCR(2,4)
println(resp)


fun findNCR(n:Int, r:Int):Int{
    if(r>n) return 0
    val factorialArr = MutableList(n+1){-1}
    val nFactorial  =  findFactorial(n, factorialArr)
    val rFactorial = findFactorial(r, factorialArr)
    val nMinusRFactorial = findFactorial(n-r, factorialArr)
    val factorial = (nFactorial).div(rFactorial*nMinusRFactorial)
    val resp = (factorial %(10.0.pow(9) +7 )).toInt()
    return resp

}

fun findFactorial(n:Int, factorialArr:MutableList<Int>):Int{
    if(n== 0) return 1
    if(factorialArr[n] != -1) return factorialArr[n]
    val factorial =  n*findFactorial(n-1, factorialArr)
    factorialArr[n] = factorial
    return factorial
}

//NC