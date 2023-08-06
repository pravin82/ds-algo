#!/usr/bin/env kotlin

//Problem link : https://leetcode.com/problems/sort-an-array/
//Learning :merge function will take O(n2) because for every iteration we are inserting the elements . insertion in array takes O(N)
//Merge V2 will do the merge in 0(N) time



fun mergeSort(arr:List<Int>):List<Int>{
    if(arr.size == 1) return listOf(arr.first())
    val midIndex = (arr.size-1)/2
   val sortedArr =   merge(mergeSort(arr.subList(0,midIndex+1)) ,arr.subList(midIndex+1,arr.size))
    return sortedArr

}

fun merge(sortedArr1:List<Int>, sortedArr2:List<Int>):List<Int>{
    val sortedArr = mutableListOf<Int>()
    sortedArr.addAll(sortedArr1)
    sortedArr2.map{
        val indexToBeInserted = findIndexToBeInserted(sortedArr,it)
        sortedArr.add(indexToBeInserted, it)
    }
    return sortedArr
}

fun findIndexToBeInserted(arr:List<Int>, ele:Int):Int{
    if(arr.isEmpty()) return 0
    if(arr.last() < ele) return arr.size
    if(arr.first() > ele) return 0
    var l = 0
    var r = arr.size-1
    var mid = l+ (r-l)/2
    while(l<=r){
        mid = l+ (r-l)/2
        if (arr.get(mid) > ele) r = mid-1
        else if(arr.get(mid) < ele) l = mid+1
        else return  mid
    }
    if(arr[mid] > ele) return mid
    else return mid+1
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
            j++
        }
        else {
            tempList.set(currentIndex,sortedArr1.get(i))
            i++
        }
        currentIndex++

    }
    for (x in i+1..arraySize1-1){
        tempList.set(currentIndex, sortedArr1.get(x))
        currentIndex++
    }
    for (x in j+1..arraySize2-1){
        tempList.set(currentIndex, sortedArr2.get(x))
    }
    return tempList

}


