/* https://leetcode.com/problems/lru-cache/
 * https://leetcode.com/submissions/detail/24678850/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * */

package com.arpit.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    private final int capacity;
    
    private final Map<Integer, Integer> map;
    private final List<Integer> keyList;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Integer>();
        keyList = new ArrayList<Integer>();
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            keyList.remove(Integer.valueOf(key));
            keyList.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        
        keyList.remove(Integer.valueOf(key));
        map.remove(key);
        
        keyList.add(key);
        map.put( key, value);
        
        if(keyList.size() > capacity){
            map.remove(keyList.get(0));
            keyList.remove(0);
        }
        
        
        
    }
}
