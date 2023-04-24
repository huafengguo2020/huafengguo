package com.ghf.learn.od.lecode;

import java.util.Arrays;

/**
 * 力扣-128-最长连续序列
 *
 * @author huafengguo2020
 * @version 2023/4/24 21:54
 * @since JDK8
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        LongestConsecutive test = new LongestConsecutive();
        int[] nums = new int[]{1, 2, 0, 1};
        System.out.println(test.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        // 去重
        // 先排序
        Arrays.sort(nums);
        return dfs(nums,0,1);
    }
    public int dfs(int[] nums ,int nowIndex, int maxInt ){
        int tmpRes = 1;
        for(int i = nowIndex +1 ; i < nums.length ; i ++){
            if(nums[i] - nums[nowIndex] == 1){
                tmpRes ++ ;
                nowIndex = i;
            }else if(nums[i] - nums[nowIndex] == 0){
                nowIndex = i;
            }else{
                nowIndex = i;
                break;
            }
        }
        maxInt = Math.max(tmpRes,maxInt);
        if(nowIndex < nums.length-1){
            return dfs(nums,nowIndex,maxInt);
        }
        return maxInt;
    }
}
