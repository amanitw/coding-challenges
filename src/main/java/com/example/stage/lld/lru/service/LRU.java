package com.example.stage.lld.lru.service;

public interface LRU <K,V>{
    public void put(K key, V value);
    public V get(K key);
}
