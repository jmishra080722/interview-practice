package org.example.leetcode;

import java.security.InvalidParameterException;

public class RemoveNthNodeFromEndOfList {

    private ListNode head;
    private int length;

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
       RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4, fifth);
        ListNode third  = new ListNode(3, fourth);
        ListNode second = new ListNode(2,  third);
        rm.head = new ListNode(1, second);

        rm.display(rm.head);

        ListNode listNode = removeNthFromStart(rm.head, 3);
        //ListNode listNode = removeNthFromEnd(rm.head, 2);
        rm.display(listNode);
    }

    public void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;
        for (int i = 0; i < n; i++){
            secondPtr = secondPtr.next;
        }
        while (secondPtr.next != null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        firstPtr.next = firstPtr.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromStart(ListNode head, int n) {
        if (n <= 0) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode current = dummy;
        int count = 0;

        while (current.next != null) {
            count++;
            if (count == n) {
                current.next = current.next.next;
                return dummy.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}


