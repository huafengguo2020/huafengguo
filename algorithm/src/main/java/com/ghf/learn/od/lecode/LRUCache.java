package com.ghf.learn.od.lecode;

import java.util.*;

/**
 * 力扣-146-LRU缓存
 * 20230424 22：43提交超时！！！
 *
 * @author huafengguo2020
 * @version 2023/4/24 22:15
 * @since JDK8
 */
public class LRUCache {
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private List<Integer> sortList = new ArrayList<>();
    private List<Map<Integer ,Integer>> maps = new ArrayList<>();
    public int get(int key) {
        if(sortList.contains(key)){
            int index = sortList.indexOf(key);
            System.out.println(index + "-" + sortList.size() + "-" + maps.size());
            Map<Integer,Integer> tmpMap = maps.get(index);
            sortList.remove(index);
            maps.remove(index);
            sortList.add(key);
            maps.add(tmpMap);
            return tmpMap.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Map<Integer,Integer> tmpMap = new HashMap<>();
        if(sortList.contains(key)){
            int index = sortList.indexOf(key);
            sortList.remove(index);
            maps.remove(index);
        }else{
            if(capacity == sortList.size()){
                sortList.remove(0);
                maps.remove(0);
            }
        }
        tmpMap.put(key,value);
        sortList.add(key);
        maps.add(tmpMap);
    }
}
