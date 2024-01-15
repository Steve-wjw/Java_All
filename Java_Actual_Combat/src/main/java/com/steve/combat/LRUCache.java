package com.steve.combat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @Author: STEVE
 * @Description: 手写LRUcache - 基于linkedHashMap
 * LRU是Least Recently Used的缩写，意思是最近最少使用，它是一种Cache替换算法。
 * Cache的容量有限，因此当Cache的容量用完后，而又有新的内容需要添加进来时， 就需要挑选并舍弃原有的部分内容，从而腾出空间来放新内容。
 * LRU Cache 的替换原则就是将最近最少使用的内容替换掉。其实，LRU译成最久未使用会更形象， 因为该算法每次替换掉的就是一段时间内最久没有使用过的内容。
 * @since: 2024/1/9
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity; // 容量大小

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        // 缓存中不存在此key，直接返回
        if (!cache.containsKey(key)) {
            return -1;
        }
        int res = cache.get(key);
        cache.remove(key);  // 先从链表中删除
        cache.put(key, res);    // 再把该节点放到链表末尾处
        return res;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);  // 已经存在，在当前链表移除
        }
        if (capacity == cache.size()) {
            // cache已满，删除链表头位置
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value); // 插入到链表末尾
    }

}
