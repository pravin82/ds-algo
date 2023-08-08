#!/usr/bin/env kotlin

import com.sun.source.tree.Tree

//Problem link : https://leetcode.com/problems/insert-into-a-binary-search-tree/


data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    if(root == null) return TreeNode(`val`)
    insertNodeInBST(root, `val`)
    return root
}

fun insertNodeInBST(root:TreeNode, value:Int){
    if(root.left == null && root.value > value) root.left = TreeNode(value)
    else if(root.right == null && root.value < value) root.right = TreeNode(value)
    else if(value > root.value)  insertNodeInBST(root.right!!, value)
    else  insertNodeInBST(root.left!!, value)
}