package com.example.stage.lld.lru.service;

import com.example.stage.lld.lru.model.Node;

import java.util.HashMap;
import java.util.Map;

public class DLLBasedLRU<K, V> implements LRU<K, V> {
    private Node<K, V> headNode;
    private Node<K,V> tailNode;
    private Map<K, Node<K, V>> nodeMap;
    private int capacity;

    public DLLBasedLRU(int capacity) {
        this.headNode = new Node<>(null, null);
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        this.tailNode = null;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> newNode = nodeMap.get(key);
        if (newNode != null) {
            deleteNode(newNode);
        }
        if (nodeMap.size() >= capacity) {
            evict();
        }

        newNode = new Node<>(key, value);
        addFront(newNode);
    }

    @Override
    public V get(K key) {
        Node<K, V> node = nodeMap.get(key);
        if (node == null) {
            //System.out.println("No key found");
            return null;
        }

        V value = node.getValue();
        deleteNode(node);
        addFront(node);
        return value;
    }

    private void evict() {
        deleteNode(tailNode);
    }

    private void deleteNode(Node<K, V> node) {
        Node<K, V> prev = node.getPrev();
        Node<K, V> next = node.getNext();
        prev.setNext(next);
        if (next != null) {
            next.setPrev(prev);
        }else {
            tailNode = prev;
        }
        nodeMap.remove(node.getKey());
    }

    private void addFront(Node<K, V> newNode) {
        Node<K,V> firstNode = headNode.getNext();
        headNode.setNext(newNode);
        newNode.setPrev(headNode);
        newNode.setNext(firstNode);
        if (firstNode!=null){
            firstNode.setPrev(newNode);
        }

        nodeMap.put(newNode.getKey(),newNode);
    }

}
