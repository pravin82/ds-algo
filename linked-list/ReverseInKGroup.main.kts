#!/usr/bin/env kotlin
//Problem source: https://450dsa.com/linked_list problem number 1
//Problem link : https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
//Similar Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
//Todo complete it after wards

data class ListNode(
    val value:Int,
    var next:ListNode?
)
fun reverseLinkedListInGroup(head:ListNode?, k:Int):ListNode?{
    if(head == null) return head
    var currentNode = head
    var previousNode:ListNode? = null
    var i = 0
    while(currentNode != null && i< k){
        val nextNode = currentNode.next
        currentNode.next = previousNode
        previousNode = currentNode
        if(nextNode != null){
            currentNode = nextNode
        }
        else break
    }
    i++
    if(i == k ) i=0
    return currentNode

}
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]