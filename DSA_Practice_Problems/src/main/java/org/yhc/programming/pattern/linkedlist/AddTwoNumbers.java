package org.yhc.programming.pattern.linkedlist;

import java.util.List;

public class AddTwoNumbers {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(List.of(2, 4, 3));
        LinkedList l2 = new LinkedList(List.of(5, 6, 4));

        ListNode result = addTwoNum(l1.head, l2.head);
        System.out.println("Result node - " + result.val);
    }

    /**
     * This is just like element-wise addition with carry (like we do manually):
     * At each step:
     *      sum = val1 + val2 + carry
     *      digit = sum % 10
     *      carry = sum / 10
     */
    private static ListNode addTwoNum(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0){
            int sum = carry;

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummy.next;
    }
}
