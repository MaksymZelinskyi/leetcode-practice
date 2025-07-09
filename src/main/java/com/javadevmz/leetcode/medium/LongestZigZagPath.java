package com.javadevmz.leetcode.medium;

/**
 * 1372. Longest ZigZag Path in a Binary Tree

 * You are given the root of a binary tree.

 * A ZigZag path for a binary tree is defined as follow:

 *     Choose any node in the binary tree and a direction (right or left).
 *     If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 *     Change the direction from right to left or from left to right.
 *     Repeat the second and third steps until you can't move in the tree.

 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

 * Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagPath {

    private int max = 0;

    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;

        //Start a zig-zag
        continueZigZag(root.left, true, 1);
        continueZigZag(root.right, false, 1);
        return max;
    }

    /*
    Recursively extends the current zig-zag path
     */
    private void continueZigZag(TreeNode root, boolean left, int length) {
        if(root==null) return;

        max = Math.max(length, max);
        //if the current node is left to its parent
        if(left) {
            //continue with right child
            continueZigZag(root.right, false, length+1);
            //and start a new zig-zag with the left
            continueZigZag(root.left, true, 1);
        }
        //if the current node is right to its parent
        else {
            //continue with left child
            continueZigZag(root.left, true, length+1);
            //and start a new zig-zag with the right
            continueZigZag(root.right, false, 1);
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
