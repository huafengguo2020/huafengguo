package com.ghf.learn.od.lecode;

/**
 * 最短回文串-力扣-214
 * https://leetcode.cn/problems/shortest-palindrome/
 *
 * @author huafengguo2020
 * @version 2023/4/25 22:35
 * @since JDK8
 */
public class ShortestPailndrome {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int midIndex = s.length()/2;
        int desInt = getDestInt(s,midIndex,midIndex-1,midIndex+1);
        String tmpStr = s.substring(desInt);
        StringBuffer sb = new StringBuffer(tmpStr);
        String str = sb.toString();
        s = str + s ;
        return s;
    }

    public int getDestInt(String s,int midIndex,int left,int right){
        if(midIndex == 0 || left <0 ){
            return midIndex;
        }
        if(s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }else{
            midIndex --;
            left = midIndex-1;
            right = midIndex +1;
        }
        return getDestInt(s,midIndex,left,right);
    }
}
