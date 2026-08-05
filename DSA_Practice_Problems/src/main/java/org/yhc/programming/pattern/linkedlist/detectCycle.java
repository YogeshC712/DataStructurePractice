package org.yhc.programming.pattern.linkedlist;

import java.util.Arrays;
import java.util.List;

public class detectCycle {
    public static void main(String[] args) {
        // Case 1: No cycle -> 1 -> 2 -> 3 -> 4 -> null
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        System.out.println("Case 1 (no cycle): " + isCycleDetected(n1)); // false

        // Case 2: Cycle -> 1 -> 2 -> 3 -> 4 -> back to 2
        ListNode n2 = new ListNode(1);
        ListNode n2b = new ListNode(2);
        ListNode n2c = new ListNode(3);
        ListNode n2d = new ListNode(4);
        n2.next = n2b;
        n2b.next = n2c;
        n2c.next = n2d;
        n2d.next = n2b; // cycle back to node with val 2
        System.out.println("Case 2 (cycle): " + isCycleDetected(n2)); // true

        // Case 3: Empty list -> null
        ListNode n3 = null;
        System.out.println("Case 3 (empty list): " + isCycleDetected(n3)); // false

        // Case 4: Single node, no self-loop -> 1 -> null
        ListNode n4 = new ListNode(1);
        System.out.println("Case 4 (single node, no loop): " + isCycleDetected(n4)); // false

        // Case 5: Single node, self-loop -> 1 -> back to itself
        ListNode n5 = new ListNode(1);
        n5.next = n5;
        System.out.println("Case 5 (single node, self loop): " + isCycleDetected(n5)); // true

        // Case 6: Two nodes, cycle back to head -> 1 -> 2 -> back to 1
        ListNode n6 = new ListNode(1);
        ListNode n6b = new ListNode(2);
        n6.next = n6b;
        n6b.next = n6;
        System.out.println("Case 6 (two nodes, cycle to head): " + isCycleDetected(n6)); // true
    }

    private static boolean isCycleDetected(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
