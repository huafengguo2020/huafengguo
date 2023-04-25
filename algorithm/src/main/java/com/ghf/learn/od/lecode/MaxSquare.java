package com.ghf.learn.od.lecode;

/**
 * 最大正方形-力扣-221
 *
 * https://leetcode.cn/problems/maximal-square/
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * @author huafengguo2020
 * @version 2023/4/25 22:30
 * @since JDK8
 */
public class MaxSquare {
    
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int edgeSize = Math.min(rows,columns);
        for (int i = edgeSize; i >0  ; i--) {
            if(dfsSquare(matrix,i)){
               return i*i;
            }
        }
        return 0;
    }
    public boolean dfsSquare(char[][] matrix ,int edge){
        for (int i = 0; i < matrix.length-edge + 1; i++) {
            for (int j = 0; j < matrix[0].length-edge+1; j++) {
                if(dfsSquare(matrix,edge,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfsSquare(char[][] matrix ,int edge,int rowStart,int colStart){
        for (int i = rowStart; i < rowStart + edge; i++) {
            for (int j = colStart  ; j < colStart + edge; j++) {
                if(matrix[i][j] == '0'){
                    return false;
                }
            }
        }
        return true;
    }
}
