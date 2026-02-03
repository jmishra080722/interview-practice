package org.example.leetcode;

public class ReverseNodesInKGroup_25 {
    ListNode head;

    public static class ListNode{
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
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        int k = 3;
        display(l1);
        ListNode reversedListNode = reversKGroup(l1, k);
        display(reversedListNode);
    }

    private static ListNode reversKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        while (true){
            ListNode kTh = getKht(groupPrev, k);
            if(kTh == null){
                break;
            }
            ListNode groupNext = kTh.next;
            //reverse group
            ListNode prev = kTh.next;
            ListNode current = groupPrev.next;

            while (current != groupNext){
                ListNode temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kTh;
            groupPrev = temp;

        }
        return dummy.next;

    }

    private static ListNode getKht(ListNode current, int k) {
        while (current != null && k > 0){
            current = current.next;
            k -= 1;
        }
        return current;
    }

    private static void display(ListNode head){
        ListNode current = head;
        while (current !=null){
            System.out.print(current.val+" -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
