package com.javadevmz.leetcode.medium;

/**
 * 200. Number of Islands

 * Given an m x n 2D binary grid 'grid' which represents a map of '1's (land) and '0's (water), return the number of islands.

 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int h = grid.length, w = grid[0].length;
        int count = 0;

        for(int i = 0; i<h; i++) {
            for(int j = 0; j<w; j++) {
                if(grid[i][j]=='1') {
                    dfs(j, i, grid); //new connected component(island)
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int x, int y, char[][] grid) {
        if(grid[y][x]!='1') return; //not a ground or visited

        grid[y][x] = '*'; // visited
        if(x>0)
            dfs(x-1, y, grid);
        if(x<grid[0].length-1)
            dfs(x+1, y, grid);
        if(y>0)
            dfs(x, y-1, grid);
        if(y<grid.length-1)
            dfs(x, y+1, grid);
    }

}
