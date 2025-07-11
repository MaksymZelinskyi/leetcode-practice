package com.javadevmz.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1926. Nearest Exit from Entrance in Maze

 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.')
 * and walls (represented as '+'). You are also given the entrance of the maze, where
 * entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

 * In one step, you can move one cell up, down, left, or right.
 * You cannot step into a cell with a wall, and you cannot step outside the maze.
 * Your goal is to find the nearest exit from the entrance.
 * An exit is defined as an empty cell that is at the border of the maze.
 * The entrance does not count as an exit.

 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

 */
public class Maze {

    public int nearestExit(char[][] maze, int[] entrance) {
        //two queues to track the level-changes
        Queue<int[]> neighbors1 = new LinkedList<>();
        Queue<int[]> neighbors2 = new LinkedList<>();
        Queue<int[]> temp = neighbors1;

        int count = 1;
        int[] currentCell = null;

        int row = entrance[0];
        int col = entrance[1];

        if(row>0 && maze[row-1][col]=='.')neighbors1.add(new int[]{row-1, col});
        if(col>0 && maze[row][col-1]=='.')neighbors1.add(new int[]{row, col-1});
        if(row<maze.length-1 && maze[row+1][col]=='.')neighbors1.add(new int[]{row+1, col});
        if(col<maze[0].length-1 && maze[row][col+1]=='.')neighbors1.add(new int[]{row, col+1});

        maze[row][col] = '+'; //mark as visited; important: mark the cells before and not after visiting them

        while(!neighbors1.isEmpty()) {
            while(!neighbors1.isEmpty()) {
                currentCell = neighbors1.poll();
                row = currentCell[0];
                col = currentCell[1];

                //exit!
                if(row==0 || col==0 || row==maze.length-1 || col==maze[0].length-1) return count;
                //check the neighbors
                if(maze[row-1][col]=='.') {
                    neighbors2.add(new int[]{row-1, col});
                    maze[row-1][col] = '+';
                }
                if(maze[row][col-1]=='.') {
                    neighbors2.add(new int[]{row, col-1});
                    maze[row][col-1] = '+';
                }
                if(maze[row+1][col]=='.') {
                    neighbors2.add(new int[]{row+1, col});
                    maze[row+1][col] = '+';
                }
                if(maze[row][col+1]=='.') {
                    neighbors2.add(new int[]{row, col+1});
                    maze[row][col+1] = '+';
                }
            }
            //switch the level
            count++;
            temp = neighbors1;
            neighbors1 = neighbors2;
            neighbors2 = temp;
        }
        return -1; // no exit found
    }
}
