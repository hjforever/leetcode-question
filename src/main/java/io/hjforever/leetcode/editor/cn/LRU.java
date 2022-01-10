package io.hjforever.leetcode.editor.cn;

import java.util.LinkedHashMap;

public class LRU<K extends Object, V extends Object> {

    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU<>(3);
        for (int i = 0; i < 10; i++) {
            lru.put(i, i);
        }
    }

    private int capicity;
    private LinkedHashMap<K, V> lruMap;

    public LRU(int capicity) {
        this.capicity = capicity;
        lruMap = new LinkedHashMap<>();
    }

    //插入
    public void put(K key, V value) {
        if (!lruMap.containsKey(key)) {
            removeExpireKey();
            lruMap.put(key, value);
        } else {
            lruMap.put(key, value);
            //refresh
            refreshKey(key);
        }

    }

    public V get(K key) {
        V value = lruMap.get(key);
        refreshKey(key);
        return value;
    }

    //移除过期的key
    void removeExpireKey() {
        while (lruMap.size() >= capicity) {
            K expireKey = lruMap.keySet().iterator().next();
            lruMap.remove(expireKey);
        }
    }


    void refreshKey(K key) {
        if (!lruMap.containsKey(key)) return;
        V value = lruMap.get(key);
        lruMap.remove(key);
        //重新放到队尾
        lruMap.put(key, value);
    }
}
