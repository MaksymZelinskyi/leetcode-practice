package com.javadevmz.leetcode.medium;

/**
 * 684. Redundant Connection

 * In this problem, a tree is an undirected graph that is connected and has no cycles.

 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

 * Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
 */
class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        //union-find
        int[] unionFind = new int[edges.length+1]; //parents
        int[] rank = new int[edges.length+1]; //depths

        for(int[] edge : edges) {
            if(!union(edge[0], edge[1], unionFind, rank)) //if already connected
                return edge;
        }
        return null;
    }

    //find the root
    public int find(int v, int[] unionFind) {
        if(unionFind[v] == 0) return v; //no parents
        int root = v;
        while(unionFind[root]!=0) {
            root = unionFind[root];
        }
        return root;
    }

    public boolean union(int a, int b, int[] unionFind, int[] rank) {
        int rootA = find(a, unionFind);
        int rootB = find(b, unionFind);

        if(rootA == rootB) //already connected
            return false;

        //attach the smaller tree to the root of  the longer
        if(rank[rootA] > rank[rootB]) {
            unionFind[rootA] = rootB;
            rank[rootA]++;
        }else {
            unionFind[rootB] = rootA;
            rank[rootB]++;
        }
        return true;
    }


}