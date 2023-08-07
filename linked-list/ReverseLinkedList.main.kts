#!/usr/bin/env kotlin
//Problem source: https://450dsa.com/linked_list problem number 0
//Problem link : https://www.geeksforgeeks.org/reverse-a-linked-list/

data class ListNode(
   val value:Int,
   var next:ListNode?
)

fun reverseLinkedList(head:ListNode?):ListNode?{
    if(head == null) return head
    var currentNode = head
    var previousNode:ListNode? = null

    while(currentNode != null){
        val nextNode = currentNode.next
        currentNode.next = previousNode
        if(nextNode != null){
            previousNode = currentNode
            currentNode = nextNode
        } else break;




    }
    return currentNode

}