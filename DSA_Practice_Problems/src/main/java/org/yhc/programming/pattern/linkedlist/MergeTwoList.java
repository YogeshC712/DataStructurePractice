package org.yhc.programming.pattern.linkedlist;

import java.util.Arrays;
import java.util.List;

public class MergeTwoList {
    public static void main(String[] args) {
        List<Integer> l1Input = Arrays.asList(1, 4, 6);
        LinkedList l1 = new LinkedList(l1Input);

        List<Integer> l2Input = Arrays.asList(2, 3);
        LinkedList l2 = new LinkedList(l2Input);

        ListNode head = mergeTwoList(l1.head, l2.head);

        System.out.print("\n\nMerged Linked list: ");
        PrintList.display(head);
    }

    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
