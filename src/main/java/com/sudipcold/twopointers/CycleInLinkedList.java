package com.sudipcold.twopointers;

public class CycleInLinkedList {
    public static boolean detectCycle(LinkedListNode head) {
        if(head == null)
            return false;

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
                return true;
        }

        return false;
    }
}


