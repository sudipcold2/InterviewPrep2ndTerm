package com.sudipcold.recursion;

import com.sudipcold.common.LinkedList;
import com.sudipcold.common.Node;

/**
 * Length of a Single LinkedList
 */
public class LengthOfLinkedList {

    public static int lengthOfList(Node head) {
        // Base case
        if (head == null) {
            return 0;
        }
        // Recursive case
        else {
            return 1 + lengthOfList(head.next);
        }
    }

    public static void main(String[] args) {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Count of nodes is = " + lengthOfList(llist.head));
    }
}
