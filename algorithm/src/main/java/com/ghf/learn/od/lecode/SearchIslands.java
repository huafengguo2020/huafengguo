package com.ghf.learn.od.lecode;

/**
 * 岛屿数量-力扣200
 *
 * @author huafengguo2020
 * @version 2023/4/23 22:31
 * @since JDK8
 */
public class SearchIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;
        for(int i = 0; i < rows; i ++){
            for (int j = 0; j < columns ;j ++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    result ++;
                }
            }
        }
        return result;
    }

    private void  dfs(char[][] grid,int x,int y){
        // 边界条件
        if(x <0 || x >= grid.length){
            return ;
        }
        if(y <0 || y >= grid[0].length){
            return ;
        }
        if(grid[x][y] == '1'){
            grid[x][y] = '2';
        }else{
            return ;
        }
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }

}
