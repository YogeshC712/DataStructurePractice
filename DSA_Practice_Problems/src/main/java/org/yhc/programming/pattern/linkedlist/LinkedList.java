package org.yhc.programming.pattern.linkedlist;

import java.util.List;

public class LinkedList {
    public ListNode head;

    public LinkedList(){
    }

    public LinkedList(List<Integer> values){
        createLinkedList(values);
    }

    private void createLinkedList(List<Integer> values){
        if(values.isEmpty()){
            return;
        }

        head = new ListNode(values.get(0));
        ListNode current = head;
        for (int i = 1; i<values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
    }

    public void displayList(ListNode head){
        ListNode current = head;

        System.out.println("\t");
        while (current != null){
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.print("NULL");
    }
}

