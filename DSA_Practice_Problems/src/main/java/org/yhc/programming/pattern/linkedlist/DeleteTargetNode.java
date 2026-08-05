package org.yhc.programming.pattern.linkedlist;

import java.util.Arrays;
import java.util.List;

public class DeleteTargetNode {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        LinkedList linkedList = new LinkedList(input);

        System.out.print("\nInput Linked list: ");
        linkedList.displayList(linkedList.head);

        int target = 3;
        linkedList.head = deleteTargetNode(linkedList.head, target);

        System.out.print("\nOutput Linked list: ");
        linkedList.displayList(linkedList.head);
    }

    private static ListNode deleteTargetNode(ListNode head, int target) {
        if(head.val == target){
            return head.next;
        }

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            if(curr.val == target){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
