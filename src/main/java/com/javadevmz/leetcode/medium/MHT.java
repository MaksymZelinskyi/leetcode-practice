package com.javadevmz.leetcode.medium;

import java.util.*;

/**
 * 310. Minimum Height Trees

 * A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

 * Return a list of all MHTs' root labels. You can return the answer in any order.

 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
class MHT {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }


        int v = bfsFarthest(0, g, null); // farthest from any node (0)

        int[] parent = new int[n];
        int w = bfsFarthest(v, g, parent); // farthest from v, parents tracked to get the path


        List<Integer> path = new ArrayList<>();
        for (int x = w; x != -1; x = parent[x]) path.add(x);

        int m = path.size();
        if (m % 2 == 1) {
            return List.of(path.get(m / 2));              // even-length diameter (edges): 1 center
        } else {
            return List.of(path.get(m / 2 - 1), path.get(m / 2)); // odd-length diameter: 2 centers
        }
    }

    // BFS that returns the farthest node from start; if parent!=null, fills parent tree
    private int bfsFarthest(int start, List<Integer>[] g, int[] parent) {
        int n = g.length;
        boolean[] vis = new boolean[n];
        if (parent != null) Arrays.fill(parent, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        int last = start;
        while (!q.isEmpty()) {
            int u = q.poll();
            last = u;
            for (int nb : g[u]) {
                if (!vis[nb]) {
                    vis[nb] = true;
                    if (parent != null) parent[nb] = u;
                    q.add(nb);
                }
            }
        }
        return last; // one of the farthest nodes
    }
}
