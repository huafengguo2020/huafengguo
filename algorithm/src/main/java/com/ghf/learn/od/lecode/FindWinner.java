package com.ghf.learn.od.lecode;

import java.util.*;
/**
 * 找出游戏的获胜者-力扣-1823
 *
 * @author huafengguo2020
 * @version 2023/4/26 19:47
 * @since JDK8
 */
public class FindWinner {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        while(list.size() > 1 ){
            int index = k %list.size();
            if(index == 0){
                list.remove(list.size()-1);
            }else{
                List<Integer> list1 = list.subList(0,index-1);
                List<Integer> list2 = list.subList(index,list.size());
                list = new ArrayList<>();
                if(!list2.isEmpty()){
                    list.addAll(list2);

                }
                if(!list1.isEmpty()){
                    list.addAll(list1);
                }
            }
        }
        return list.get(0);
    }
}
