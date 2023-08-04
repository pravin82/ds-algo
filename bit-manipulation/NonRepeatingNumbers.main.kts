#!/usr/bin/env kotlin
//Problem source: https://450dsa.com/bit_manipulation problem number 1
//Problem link : https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1
//Learning:
//XOR = if both bit are same then false otherwise true
//XOR of one number with same number is 0
//XOR of 0 with other number is other number
//XOR is associative meaning a xor (b xor c)  =  (a xor b) xor c
//Two complement is inverse of number and add 1
//rightmostsetBitMask is everything is 0 except rightMostSetBitOf 1

val resp = findTwoUniqueNumbersV2(listOf(2, 4, 7, 9, 2, 4,9,5))
println(resp)

fun getXOR(x: Int, y: Int): Int {
    return (x or y) and (x.inv() or y.inv())
}

fun getBitsList(number:Int):List<Int>{
    var mutableNumber = number
    val bitList = mutableListOf<Int>()
    while(mutableNumber > 0){
       bitList.add(mutableNumber%2)
        mutableNumber =  mutableNumber/2
    }
    return bitList.reversed()

}

fun getXOROfList(numbersList:List<Int>):Int{
    var xorOfList = 0
    numbersList.map{
        xorOfList =  xorOfList xor it
    }
    return xorOfList
}

fun findTwoUniqueNumbers(numbersList:List<Int>):Pair<Int,Int>{
     val xorOfList = getXOROfList(numbersList)
     val xorBits = getBitsList(xorOfList)
     val array1 = mutableListOf<Int>()
     val array2 = mutableListOf<Int>()
     var indexWithBitSet = -1
    //Finding any one index with bit set.
    //Note: XOR of two  distinct numbers will have alteast one bit set to 1
     xorBits.mapIndexed{index,ele->
         if(ele == 1) indexWithBitSet = ele

     }
    numbersList.map{
       val bitList =  getBitsList(it)
        if(bitList.get(indexWithBitSet) == 1) array1.add(it)
        else array2.add(it)
    }
    val xorOfArr1 = getXOROfList(array1)
    val xorOfArr2 = getXOROfList(array2)

   return Pair(xorOfArr1,xorOfArr2)



}
fun findTwoUniqueNumbersV2(numbersList:List<Int>):Pair<Int,Int>{
    val xorOfList = getXOROfList(numbersList)
    val inverseXOR = xorOfList.inv()
    val twoComplement = inverseXOR+1
    val rsbMask = xorOfList and twoComplement
    val array1 = mutableListOf<Int>()
    val array2 = mutableListOf<Int>()

    numbersList.map{
        if((it and rsbMask ) == 0) array1.add(it)
        else array2.add(it)
    }
    val xorOfArr1 = getXOROfList(array1)
    val xorOfArr2 = getXOROfList(array2)

    return Pair(xorOfArr1,xorOfArr2)



}




