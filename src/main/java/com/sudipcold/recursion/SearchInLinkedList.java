package com.sudipcold.recursion;

import com.sudipcold.common.LinkedList;
import com.sudipcold.common.Node;

public class SearchInLinkedList {
    public static boolean search(Node head, int num) {
        // Base case
        if (head == null) {
            return false;
        }

        // Recursive case
        else {
            if (head.value == num) {
                return true;
            }
            else {
                return search(head.next, num);
            }
        }
    }

    public static void main( String args[] ) {
        /* Start with the empty list */
        LinkedList list = new LinkedList();
        list.push(0);
        list.push(3);
        list.push(1);
        list.push(6);
        list.push(4);

        System.out.println("Linked List: ");
        for (Node i = list.head; i != null; i = i.next) {
            System.out.print(i.value + " ");
        }

        System.out.println(" ");
        int searchFor = 8;
        boolean result = search(list.head, searchFor);
        System.out.println("Is " + searchFor + " present in the list? : " + result);
    }
}
