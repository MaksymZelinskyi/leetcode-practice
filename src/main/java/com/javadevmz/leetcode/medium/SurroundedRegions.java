package com.javadevmz.leetcode.medium;

/**
 * 130. Surrounded Regions

 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] marked = new boolean[board.length][board[0].length];

        //run dfs from every boarder
        for(int i = 0; i<m; i++) {
            dfs(board, i, 0, marked);
            dfs(board, i, n-1, marked);
        }
        for(int i = 0; i<n; i++) {
            dfs(board, 0, i, marked);
            dfs(board, m-1, i, marked);
        }
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == 'O' && !marked[i][j]) //if belongs to a region that doesn't touch the boarder
                    board[i][j] = 'X'; //swap
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] marked) {
        if(board[i][j]=='X' || marked[i][j]) return;

        marked[i][j] = true; //reachable from the boarder

        //continue dfs
        if(i>0) dfs(board, i-1, j, marked);
        if(i<board.length-1)dfs(board, i+1, j, marked);
        if(j>0) dfs(board, i, j-1, marked);
        if(j<board[0].length-1) dfs(board, i, j+1, marked);
    }
}
