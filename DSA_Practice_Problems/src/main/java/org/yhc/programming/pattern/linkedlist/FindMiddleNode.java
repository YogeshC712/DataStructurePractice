package org.yhc.programming.pattern.linkedlist;

import java.util.Arrays;
import java.util.List;

public class FindMiddleNode {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList linkedList = new LinkedList(input);

        System.out.print("\nInput Linked list: ");
        linkedList.displayList(linkedList.head);

        System.out.println("The middle node is " + middleNode(linkedList.head).val);
    }

    private static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
