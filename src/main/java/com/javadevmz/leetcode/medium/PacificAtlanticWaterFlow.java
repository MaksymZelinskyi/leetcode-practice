package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. Pacific Atlantic Water Flow

 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {

    //intuition: find the cells reachable by an ascending path from both oceans, by executing two BFS from the borders
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();

        boolean[][] pMarked = new boolean[m][n];

        // cells adjacent with Pacific Ocean
        for(int i = 0; i<n; i++) {
            q.add(List.of(0, i));
        }
        for(int i = 0; i<m; i++) {
            q.add(List.of(i, 0));
        }

        bfs(heights, q, pMarked);

        boolean[][] aMarked = new boolean[m][n];

        // cells adjacent with Atlantic Ocean
        for(int i = 0; i<n; i++) {
            q.add(List.of(m-1, i));
        }
        for(int i = 0; i<m; i++) {
            q.add(List.of(i, n-1));
        }

        bfs(heights, q, aMarked);

        // find intersections
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(pMarked[i][j] && aMarked[i][j])
                    result.add(List.of(i, j));
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<List<Integer>> q, boolean[][] marked) {
        int m = heights.length, n = heights[0].length;
        while(!q.isEmpty()) {
            List<Integer> coord = q.poll();
            int y = coord.get(0), x = coord.get(1);
            if(marked[y][x]) continue;

            marked[y][x] = true;

            //add the higher neighbors
            if(y>0 && heights[y-1][x] >= heights[y][x]) q.add(List.of(y-1, x));
            if(y<m-1 && heights[y+1][x] >= heights[y][x]) q.add(List.of(y+1, x));
            if(x>0 && heights[y][x-1] >= heights[y][x]) q.add(List.of(y, x-1));
            if(x<n-1 && heights[y][x+1] >= heights[y][x]) q.add(List.of(y, x+1));
        }
    }

}
