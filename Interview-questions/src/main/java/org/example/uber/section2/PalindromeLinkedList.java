package org.example.uber.section2;

import org.example.uber.inheritance.A;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3, l1);
        ListNode l3 = new ListNode(7, l2);
        ListNode l4 = new ListNode(7, l3);
        ListNode l5 = new ListNode(3, l4);
        ListNode l6 = new ListNode(2, l5);
        System.out.println("Original list: "+l6);
        //boolean isPalindrome = isPalindrome(l6);
        boolean isPalindrome = isPalindrome2(l6);
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        fast = head;
        System.out.println("Slow: "+slow);
        System.out.println("Fast: "+fast);
        slow = reverseList(slow);
        System.out.println("Reversed slow node: "+slow);
        while (slow != null && fast != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode previousNode = null;
        ListNode currentNode = head;
        while (currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
        return head;
    }

    private static boolean isPalindrome(ListNode listNode) {
        boolean isPalindrome = true;
        List<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int i = 0;
        int j = list.size()-1;
        while (i < j){
            if(list.get(i) != list.get(j)){
                isPalindrome = false;
            }
            i++;
            j--;
        }
        return isPalindrome;
    }
}
