package com.sudipcold.recursion;

public class BSTInsertion {

    static class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }

    //Variables
    private Node root;
    //Getter for Root
    public Node getRoot() {
        return root;
    }
    //Setter for root
    public void setRoot(Node root) {
        this.root = root;
    }


    //Recursive function to insert a value in BST
    public Node recursiveInsert(Node currentNode, int value) {

        //Base Case
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.getData()) {
            //Iterate left sub-tree
            currentNode.setLeftChild(recursiveInsert(currentNode.getLeftChild(), value));
        } else if (value > currentNode.getData()) {
            //Iterate right sub-tree
            currentNode.setRightChild(recursiveInsert(currentNode.getRightChild(), value));
        } else {
            // value already exists
            return currentNode;
        }

        return currentNode;
    }

    //Function to call recursive insert
    public boolean insert(int value) {

        root = recursiveInsert(this.root, value);
        return true;
    }

    //Function to check if Tree is empty or not
    public boolean isEmpty() {
        return root == null; //if root is null then it means Tree is empty
    }

    //Just for Testing purpose
    public void printTree(Node current) {

        if (current == null) return;

        System.out.print(current.getData() + ",");
        printTree(current.getLeftChild());
        printTree(current.getRightChild());

    }
    public static void main(String args[]) {

        BSTInsertion bsT = new BSTInsertion();
        bsT.insert(6);
        bsT.insert(4);
        bsT.insert(8);
        bsT.insert(5);
        bsT.insert(2);
        bsT.insert(8);
        bsT.insert(12);
        bsT.insert(10);
        bsT.insert(14);
        bsT.printTree(bsT.getRoot());

    }
}
