package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 133. Clone Graph

 * Given a reference of a node in a connected undirected graph.

 * Return a deep copy (clone) of the graph.

 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }


 * Test case format:

 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        return dfs(node, new Node[100]); //store the created nodes(1 <= Node.val <= 100)
    }

    private Node dfs(Node node, Node[] marked) {
        if(node==null) return null;
        Node copy = new Node(node.val);
        marked[node.val-1] = copy; //save the copy

        for(Node n : node.neighbors) {
            if(marked[n.val-1]!=null) // if already created
                copy.neighbors.add(marked[n.val-1]); // take existing
            else
                copy.neighbors.add(dfs(n, marked)); // only continue the dfs if the node hasn't been visited yet
        }
        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            this.val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

