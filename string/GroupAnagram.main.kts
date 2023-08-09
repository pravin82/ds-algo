#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/string problem number 35
//Problem link : https://practice.geeksforgeeks.org/problems/print-anagrams-together/1


fun groupAnagrams(strs:List<String>):List<List<String>>{
    val anaArray = mutableListOf<MutableList<String>>()
    val anagramFound = mutableListOf<Int>()
  for (i in strs.indices){
      if(anagramFound.contains(i)) continue
      val anaOfCurrentEle = mutableListOf<String>()
      anaOfCurrentEle.add(strs[i])


      for (j in i+1..strs.size-1){
          val isAnagram = isAnagram(strs[i], strs[j])
          if(isAnagram){
              anaOfCurrentEle.add(strs[j])
              anagramFound.add(j)

          }
      }
      anaArray.add(anaOfCurrentEle)


  }
    return anaArray
}

fun isAnagram(str1:String, str2:String):Boolean{
    if(str1.length != str2.length) return false
    val eleMap = mutableMapOf<Char,Int>()
    str2.map{
        val value = eleMap.get(it)?:0
        eleMap.put(it, value+1)
    }
    str1.map{
        if(eleMap.get(it) == null || eleMap.get(it) == 0) return false
        val value = eleMap.get(it)?:0
        eleMap.put(it, value-1)

    }
    return true
}

fun groupAnagramsV2(strs:List<String>):List<List<String>>{
    val eleMap = mutableMapOf<String, List<String>>()
    strs.map{
        val sortedStr = it.toCharArray().sorted().joinToString("")
        val eleValue = eleMap.get(sortedStr)?.toMutableList()?: emptyList<String>().toMutableList()
        eleMap.put(sortedStr,eleValue.plus(it) )

    }
    return eleMap.values.toList()

}