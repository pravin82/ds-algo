#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/bst problem number 1
//Problem link : https://leetcode.com/problems/delete-node-in-a-bst/


 data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun deleteNodeInBinaryTree(root:TreeNode?, key:Int):TreeNode?{
    if(root == null) return root
    if(root.value == key)

}

fun insertNodeInBinaryTree()