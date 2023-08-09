#!/usr/bin/env kotlin

//Problem source: https://450dsa.com/bst problem number 1
//Problem link : https://leetcode.com/problems/delete-node-in-a-bst/


 data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun deleteNodeInBinaryTree(root:TreeNode?, value:Int):TreeNode?{
    if(root == null) return root
    if(root.value == value) {
        if(root.left == null) return root.right
        else  insertNodeInBST(root.left, root.right)
        return root.left
    }
    val nodeWhoseChildIsToBeDeleted = searchInBinaryTreeReturningParentRoot(root, value)
    if(nodeWhoseChildIsToBeDeleted == null) return root
    else {
        if(nodeWhoseChildIsToBeDeleted.left?.value == value) {
            val rightNode = nodeWhoseChildIsToBeDeleted.left?.right
            nodeWhoseChildIsToBeDeleted.left = nodeWhoseChildIsToBeDeleted.left?.left
            if( nodeWhoseChildIsToBeDeleted.left == null) nodeWhoseChildIsToBeDeleted.left = rightNode
            else  insertNodeInBST(nodeWhoseChildIsToBeDeleted.left, rightNode)
        }
        else {
            val rightNode = nodeWhoseChildIsToBeDeleted.right?.right
            nodeWhoseChildIsToBeDeleted.right = nodeWhoseChildIsToBeDeleted.right?.left
            if( nodeWhoseChildIsToBeDeleted.right == null) nodeWhoseChildIsToBeDeleted.right = rightNode
            insertNodeInBST(nodeWhoseChildIsToBeDeleted.right, rightNode)
        }
    }
    return root




}

fun insertNodeInBST(root:TreeNode?, newNode:TreeNode?){
    if(newNode == null || root == null ) return
    if(root.left == null && root.value > newNode.value) root.left = newNode
    else if(root.right == null && root.value < newNode.value) root.right = newNode
    else if(newNode.value > root.value)  insertNodeInBST(root.right!!, newNode)
    else  insertNodeInBST(root.left, newNode)
}

fun searchInBinaryTreeReturningParentRoot(root:TreeNode?,value:Int):TreeNode?{
    if(root == null) return root
    if(root.left == null && root.right == null) return null
    if(root.left != null && root.left!!.value == value) return root
    else if(root.right != null && root.right!!.value == value) return root
    if(root.value < value)  return searchInBinaryTreeReturningParentRoot(root.right, value)
    else return searchInBinaryTreeReturningParentRoot(root.left, value)
}