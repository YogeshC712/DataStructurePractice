package org.yhc.programming.pattern.linkedlist;

import java.util.Arrays;
import java.util.List;

public class ListLength {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList inputLinkedList = new LinkedList(input);

        System.out.print("\nInput Linked list: ");
        inputLinkedList.displayList(inputLinkedList.head);

        System.out.println("The length of List is " + findLength(inputLinkedList.head));
    }

    private static int findLength(ListNode head) {
        ListNode curr = head;
        int length = 0;

        while (curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }
}
