package com.sudipcold.twopointers;

public class MiddleOfLinkedList {

    public static LinkedListNode middleNode(LinkedListNode head) {

        if(head == null || head.next == null)
            return head;

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
