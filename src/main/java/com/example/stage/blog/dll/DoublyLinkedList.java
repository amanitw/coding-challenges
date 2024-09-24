package com.example.stage.blog.dll;

public class DoublyLinkedList {
    private Node headNode;
    private Node tailNode;

    public DoublyLinkedList() {
        this.headNode = new Node(0);
        this.tailNode = null;
    }

    public void add(int val) {
        Node newNode = new Node(val);
        if (tailNode == null) {
            headNode.setNext(newNode);
            newNode.setPrev(headNode);
        } else {
            tailNode.setNext(newNode);
            newNode.setPrev(tailNode);
        }
        tailNode = newNode;
    }

    public void delete(int val) {
        Node curr = headNode.getNext();
        while (curr != null) {
            if (curr.getValue() == val) {
                break;
            }
            curr = curr.getNext();
        }
        if (curr == null) {
            System.out.println("Node not found");
            return;
        }

        Node prev = curr.getPrev();
        Node next = curr.getNext();
        prev.setNext(next);
        if (next != null) {
            next.setPrev(prev);
        } else {
            tailNode = prev;
        }
    }

    public void print() {
        Node curr = headNode.getNext();
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
    }
}
