package org.example.uber.section2;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-4);
        ListNode l2 = new ListNode(0, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(3, l3);
        l1.next = l3;

        boolean  cyclePresent = hasCycle2(l4);
        System.out.println(cyclePresent);
    }

    private static boolean hasCycle2(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
