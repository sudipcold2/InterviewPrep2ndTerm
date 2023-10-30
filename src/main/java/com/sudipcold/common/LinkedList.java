package com.sudipcold.common;

public class LinkedList {
    public Node head;

    public void push(int data){
        if(head == null){
            head = new Node(data);
            head.next = null;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }
}
