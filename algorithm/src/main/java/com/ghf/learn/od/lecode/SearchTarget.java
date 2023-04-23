package com.ghf.learn.od.lecode;

/**
 * 搜索二维矩阵-力扣240
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 *
 * @author huafengguo2020
 * @version 2023/4/23 22:38
 * @since JDK8
 */
public class SearchTarget {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 获取最后一列
        return dfs(matrix,target,0, matrix.length-1);
    }

    public boolean dfs(int[][] matrix, int target,int xStart,int xEnd ){
        if(xStart == xEnd ){
            return hasTarget(matrix,target,xStart);
        }
        // 获取比较的最后一列的值
        int tmpRow = (xStart + xEnd) /2 ;
        if(matrix[tmpRow][matrix[0].length -1] == target){
            return true;
        }else if(matrix[tmpRow][matrix[0].length -1] < target){

            if(matrix[tmpRow][0] <= target){
                if(hasTarget(matrix,target,tmpRow)){
                    return  true;
                }
            }
            xEnd = tmpRow;
            return dfs(matrix,target,xStart,xEnd);
        }else{
            xStart = tmpRow +1;
            return dfs(matrix,target,xStart,xEnd);
        }
        // 获取最后一列

    }
    public boolean hasTarget(int[][] matrix,int target ,int x){
        for(int i = 0 ; i < matrix[x].length; i ++){
            if (matrix[x][i] == target){
                return true;
            }
        }
        return false;
    }
}
