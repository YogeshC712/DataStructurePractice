package org.yhc.programming.pattern.two_pointers;

import org.yhc.programming.pattern.linkedlist.LinkedList;
import org.yhc.programming.pattern.linkedlist.ListNode;
import org.yhc.programming.pattern.linkedlist.PrintList;

import java.util.Arrays;
import java.util.List;

/*
Problem statement -
Given the head of a singly linked list and an integer n, remove the nth node from the end of the list and return the head of the modified list.

Solution/approach -
1. Initialize left and right pointers pointing to the linked list’s head.
2. Move the right pointer n steps forward.
3. If the right pointer has reached the end of the list, i.e., NULL, it means the head is the target node for removal.
In this case, return head.next as the new head of the linked list. This effectively removes the original head of the list.
4. Otherwise, move left and right pointers forward one step at a time.
    - Once the right pointer reaches the end of the linked list, update left.next to left.next.next.
    This is to skip the target node, effectively removing it from the linked list.
5. Finally, return the head, pointing to the updated linked list with the nth node removed.
 */
public class RemoveNthLastNode {
    public static void main(String[] args) {
        //List<Integer> input = Arrays.asList(23, 89, 10, 5, 67, 39, 70, 28);
        List<Integer> input = Arrays.asList(34, 53, 6, 95, 38, 28, 17, 63, 16, 76);
        int n = 1;

        LinkedList inputLinkedList = new LinkedList(input);

        ListNode head = removeNthLastNode(inputLinkedList.head, n);
        PrintList.display(head);
    }

    private static ListNode removeNthLastNode(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        for(int i = 0; i < n; i++){
            right = right.next;
        }

        if(right == null){
            return head.next;
        }

        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
