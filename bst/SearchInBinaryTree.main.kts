#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/bst problem number 0
//Problem link : https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
//Similar Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/description/

data class TreeNode(var value: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }


fun searchInBinaryTree(root:TreeNode?,value:Int):TreeNode?{
    if(root == null) return root
    if(root.value == value) return root
    if(root.value < value)  return searchInBinaryTree(root.right, value)
    else return searchInBinaryTree(root.left, value)
}