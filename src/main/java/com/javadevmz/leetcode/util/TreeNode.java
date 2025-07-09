package com.javadevmz.leetcode.util;

public class TreeNode {

    /*
    I had to make the fields public lest I modify masses of code in different solutions
     */
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}