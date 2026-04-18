package org.yhc.programming.pattern.linkedlist;

public class ListNode {
    public ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
