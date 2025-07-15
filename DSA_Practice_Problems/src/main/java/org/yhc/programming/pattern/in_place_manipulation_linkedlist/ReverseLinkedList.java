package org.yhc.programming.pattern.in_place_manipulation_linkedlist;

import org.yhc.programming.pattern.linkedlist.LinkedList;
import org.yhc.programming.pattern.linkedlist.ListNode;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList inputLinkedList = new LinkedList(input);

        System.out.print("\nInput Linked list: ");
        inputLinkedList.displayList(inputLinkedList.head);

        ListNode head = reverse(inputLinkedList.head);

        System.out.print("\n\nReversed Linked list: ");
        inputLinkedList.displayList(head);
        System.out.println();
    }

    /*
    Now, let’s look at the workflow of the implementation of the algorithm.

        1. Initialize three pointers: prev, next, and curr. The prev and next pointers are initialized as NULL, while the curr pointer is initialized to the head of the linked list.
        2. Iterate over the linked list. While iterating, perform the following steps:
            -   Before changing the next of curr, store the next node using the following line of code next = curr.next.
            -   Now, we will update the next pointer of curr with the prev pointer. This will reverse the pointer of the current node from forward to backward, eventually aiding the reversal of the linked list.
            -   After reversing the pointer, we’ll update prev as curr and curr as next using prev = curr and curr = next respectively.
        3. After reversing the whole linked list, we’ll change the head pointer to the prev pointer because prev will be pointing to the new head node.

        Time complexity = O(n)  - Because we reversed in single pass
        Space complexity = O(1) - No extra memory used
     */
    private static ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
