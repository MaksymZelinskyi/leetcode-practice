package com.javadevmz.leetcode.medium;

import java.util.*;

/** 1466. Reorder Routes to Make All Paths Lead to the City Zero

 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

 * It's guaranteed that each city can reach city 0 after reorder.
 */
public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>(); //a bidirectional graph
        boolean[] visited = new boolean[n]; //track visited
        int count = 0;

        for(int[] conn : connections) {
            //simple order
            List<Integer> list = new ArrayList<>();
            graph.putIfAbsent(conn[0], list);
            list = graph.get(conn[0]);
            list.add(conn[1]);

            //reverse order
            list = new ArrayList<>();
            graph.putIfAbsent(conn[1], list);
            list = graph.get(conn[1]);
            list.add(-conn[0]); //negative to mark the order
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        // Breadth-First-Search
        while(!q.isEmpty()) {
            Integer current = q.poll();
            visited[current] = true;
            List<Integer> neighbors = graph.get(current);
            for(Integer city : neighbors) {
                if(!visited[Math.abs(city)]) {
                    if(city>0) { //the route leads from the capital
                        count++; //reorder
                    }else {
                        city = Math.abs(city);
                    }
                    q.add(city);
                }
            }
        }
        return count;
    }
}
