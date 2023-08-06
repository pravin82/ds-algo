#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 15
//Problem link : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
//Similar Problem https://leetcode.com/problems/global-and-local-inversions/description/
//Learning:we can found global inversion count  by merge sort and keeping a count counter
//When a number from right array is shifted to left array . inversion count we calculate
// by difference of the index of element in (left array +combined array) minus it's final index

var count = 0
fun getLocalInversion(nums:IntArray):Int{
    val tempList = MutableList<Int>(nums.size){0}
    nums.mapIndexed{index,ele->
      val elementToAdd =   when(index == nums.size-1)  {
          true -> ele
          else -> nums[index+1] - nums[index]
      }
        tempList.add(elementToAdd)
    }
    var count = 0
    tempList.map{
        if(it < 0) count++
    }
    return count
}

fun getGlobalInversion(arr:List<Int>){

}

fun mergeV2(sortedArr1:List<Int>, sortedArr2:List<Int>):List<Int>{
    val arraySize1 = sortedArr1.size
    val arraySize2 = sortedArr2.size
    val tempList = MutableList(arraySize1+arraySize2){0}
    var i = 0
    var j = 0
    var currentIndex = 0

    while(i < arraySize1 && j< arraySize2){
        if(sortedArr1.get(i) > sortedArr2.get(j)){
            tempList.set(currentIndex, sortedArr2.get(j))
            val numbersAheadOfIIncludingI = arraySize1-i
            count = count + numbersAheadOfIIncludingI
            j++
        }
        else {
            tempList.set(currentIndex,sortedArr1.get(i))
            i++
        }
        currentIndex++

    }
    for (x in i..arraySize1-1){
        tempList.set(currentIndex, sortedArr1.get(x))
        currentIndex++
    }
    for (x in j..arraySize2-1){
        tempList.set(currentIndex, sortedArr2.get(x))
        currentIndex++
    }
    return tempList

}


