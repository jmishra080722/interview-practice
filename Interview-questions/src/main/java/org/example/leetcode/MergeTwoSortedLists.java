package org.example.leetcode;

public class MergeTwoSortedLists {

    private ListNode head;

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(3, r1);
        ListNode r3 = new ListNode(1, r2 );


        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
        mtsl.display(l3);
        mtsl.display(r3);

        ListNode mergedList = mtsl.mergeTwoList(l3, r3);
        mtsl.display(mergedList);

    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode result = new ListNode();
        ListNode start = result;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
            }else {
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }
        }
        if(list1 == null){
            result.next = list2;
        }
        if(list2 == null){
            result.next = list1;
        }

        return start.next;
    }

    public void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val +" -> " );
            current = current.next;
        }
        System.out.println("null");
    }
}
