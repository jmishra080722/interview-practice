package org.example.leetcode;

import java.util.List;

public class SwapNodesInPairs_24 {
    ListNode head;

    private static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        display(l1);
        ListNode result = swapNodes(l1);
        display(result);
    }

    private static ListNode swapNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode point = dummy;

        while(point.next != null && point.next.next != null) {
            ListNode left = point.next;
            ListNode right = point.next.next;

            left.next = right.next;
            right.next = left;

            point.next = right;
            point = left;

        }
        return dummy.next;
    }

    private static void display(ListNode head){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
