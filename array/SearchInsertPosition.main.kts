#!/usr/bin/env kotlin

//Problem link : https://leetcode.com/problems/search-insert-position/submissions/1013392099/

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