package org.example.uber.section2;

import java.util.List;
import java.util.Stack;

public class ReverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(2, l2);
        ListNode l4 = new ListNode(1, l3);
        ListNode l5 = new ListNode(5, l4);
        System.out.println(l5);
        //ListNode reversedList  = revers(l5);
        ListNode reversedList  = reversWithoutStack(l5);
        System.out.println("Reversed: "+reversedList);
    }

    private static ListNode reversWithoutStack(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode preNode = null;
        ListNode currentNode = head;

        while(currentNode != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
        }
        head = preNode;
        return head;
    }

    private static ListNode revers(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        ListNode reversedList = new ListNode(Integer.MIN_VALUE);
        ListNode pointer = reversedList;
        while (!stack.isEmpty()){
            pointer.next = new ListNode(stack.pop());
            pointer = pointer.next;
        }
        return reversedList.next;
    }
}
