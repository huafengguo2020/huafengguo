package com.ghf.learn.od.lecode;
import java.util.*;

/**
 * 所有子字符串美丽之和-力扣-1781
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 *
 * @author huafengguo2020
 * @version 2023/4/25 22:31
 * @since JDK8
 */
public class BeautySum {
    public int beautySum(String s) {
        if(s == null || s.length() == 0 ){
            return 0;
        }
        Map<Character,Integer> maps = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            if(maps.containsKey(tmpChar)){
                int size = maps.get(tmpChar);
                maps.put(tmpChar,size+1);
            }else{
                maps.put(tmpChar,1);
            }
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(maps.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int resInt = list.get(0).getValue();
        return resInt*resInt +1;
    }
}
