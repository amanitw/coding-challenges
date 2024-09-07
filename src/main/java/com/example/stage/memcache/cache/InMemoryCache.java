package com.example.stage.memcache.cache;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCache<K,V> implements Cache<K,V>{
    private  Map<K,V> hashMap = new HashMap<>();
    @Override
    public void put(K key, V value) {
        hashMap.put(key,value);
    }

    @Override
    public V get(K key) {
        return hashMap.get(key);
    }
}
