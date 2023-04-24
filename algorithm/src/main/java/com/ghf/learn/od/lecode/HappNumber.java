package com.ghf.learn.od.lecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐数-力扣202
 *
 * @author huafengguo2020
 * @version 2023/4/24 21:43
 * @since JDK8
 */
public class HappNumber {


    public boolean isHappy(int n) {
        return dfs(n,new ArrayList<>());
    }

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 9.62%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 6.11%
     * 的用户
     * 通过测试用例：
     * 406 / 406
     *
     * @param n 当前数据
     * @param list 已经循环的数据列表
     * @return 返回值
     */
    public boolean dfs(int n , List<Integer> list){
        String numStr = String.valueOf(n);
        int sum = 0;
        for(int i =0; i < numStr.length();i++){
            int tmpNum = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            sum += tmpNum*tmpNum;
        }
        if (sum == 1 ){
            return true;
        }
        if(list.contains(sum)){
            return false;
        }
        list.add(sum);
        return dfs(sum,list);
    }
}
