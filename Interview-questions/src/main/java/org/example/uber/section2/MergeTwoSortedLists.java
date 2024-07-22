package org.example.uber.section2;

import java.util.List;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(1, l2);

        ListNode r1 = new ListNode(4);
        ListNode r2 = new ListNode(3, r1);
        ListNode r3 = new ListNode(1, r2);
        System.out.println(l3);
        System.out.println(r3);

        ListNode result = mergeLists(l3, r3);
        System.out.println(result);
    }

    private static ListNode mergeLists(ListNode leftList, ListNode rightList) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode headNode = result;
        while (leftList != null && rightList != null){
            if(leftList.val < rightList.val){
                result.next = leftList;
                leftList = leftList.next;
            }else {
                result.next = rightList;
                rightList = rightList.next;
            }
            result = result.next;
        }
        if(leftList == null){
            result.next = rightList;
        }
        if ((rightList == null)){
            result.next = leftList;
        }
        return headNode.next;
    }
}
