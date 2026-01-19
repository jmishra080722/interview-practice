package org.example.leetcode;

public class MergeKSortedLists {


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

    public static void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val +" -> " );
            current = current.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(3, r1);
        ListNode r3 = new ListNode(1, r2 );

        ListNode t1 = new ListNode(6);
        ListNode t2 = new ListNode(2, t1);

        ListNode[] lists = {l3, r3, t2};

       ListNode mergedList =  merge(lists);
       display(mergedList);
    }

    private static ListNode merge(ListNode[] lists) {
        if(lists == null || lists.length ==0){
            return null;
        }
        ListNode result = lists[0];
        for(int i=1; i< lists.length; i++){
            if(lists[i] == null){
                continue;
            }
            result = mergeTwo(result, lists[i]);
        }
        return result;
    }

    private static ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged =  merged.next;
        }
        if(list1 == null){
            merged.next = list2;
        }
        if(list2 == null){
            merged.next = list1;
        }
        return head.next;
    }
}
