#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/array problem number 11
//Problem link : https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
val resp = mergeV3(listOf(1 ,3 ,5, 7).toMutableList(), listOf(0 ,2, 6, 8, 9).toMutableList())
println(resp)

fun merge(arr1:List<Int>, arr2:List<Int>):List<Int>{
    val tempArray = mutableListOf<Int>()
    var i = 0
    var j = 0
    val arr1Size = arr1.size
    val arr2Size = arr2.size
    var currentIndex = 0
    while(i< arr1Size-1 && j <arr2Size-1){
        if(arr1.get(i) <  arr2.get(j)){
            tempArray.add(arr1.get(i))
            i++
        }
        else {
            tempArray.add(arr2.get(j))
            j++
        }
        currentIndex++
    }
    for (x in i..arr1Size-1){
        tempArray.add(arr1.get(x))
        currentIndex++
    }
    for (x in j..arr2Size-1){
        tempArray.add(arr2.get(x))
        currentIndex++
    }
    return tempArray
}

fun mergeV2(arr1:MutableList<Int>, arr2:MutableList<Int>):Pair<List<Int>,List<Int>>{
  var i = arr1.size-1
  var j = 0
  while(i>=0 && j<arr2.size) {
      if(arr1.get(i) > arr2.get(j)){
          val arr2Ele = arr2.get(j)
          arr2.set(j, arr1.get(i))
          arr1.set(i, arr2Ele)
          i--
          j++
      }
      else break;

  }
    arr1.sort()
    arr2.sort()
    return Pair(arr1,arr2)
}

fun mergeV3(arr1:MutableList<Int>, arr2:MutableList<Int>):Pair<List<Int>,List<Int>>{
    val totalSize = arr1.size + arr2.size
    var gap = (totalSize/2) + (totalSize%2)
    while(gap > 0) {
        var left = 0
        var right = left + gap
        while (right < arr1.size + arr2.size){
            if (left < arr1.size && right >= arr1.size) {
                swapIfGreater(arr1, arr2, left, right - arr1.size)
            }
       else if (left < arr1.size && right < arr1.size) {
            swapIfGreater(arr1, arr1, left, right)
        } else {
            swapIfGreater(arr2, arr2, left-arr1.size, right-arr1.size)
        }
        left++
        right++
    }
        if(gap == 1) break
        gap = (gap/2) + (gap%2)
    }
    return Pair(arr1,arr2)
}

fun swapIfGreater(arr1:MutableList<Int>, arr2:MutableList<Int>, left:Int, right:Int){
    if(arr1.get(left) >  arr2.get(right)){
        val arrEle = arr2.get(right)
        arr2.set(right, arr1.get(left))
        arr1.set(left, arrEle)
    }

}

//n = 4, arr1[] = [1 3 5 7]
//m = 5, arr2[] = [0 2 6 8 9]
