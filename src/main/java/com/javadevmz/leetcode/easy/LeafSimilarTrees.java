package com.javadevmz.leetcode.easy;

import com.javadevmz.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.

 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return root1==null && root2==null;

        Stack<Integer> leaves = new Stack<>();
        addLeaves(root1, leaves);
        return leavesPresent(root2, leaves) && leaves.isEmpty();
    }

    /*
    Reach the leaves with the depth-first and collect them into the stack
     */
    void addLeaves(TreeNode subtree, Stack<Integer> leaves) {

        if(subtree.left==null && subtree.right==null) {
            leaves.add(subtree.val);
        }else {
            if(subtree.left!=null)
                addLeaves(subtree.left, leaves);
            if(subtree.right!=null)
                addLeaves(subtree.right, leaves);
        }

    }

    /*
    Verifies that the leaves extracted from tree1 are present in tree2 in the same order
     */
    boolean leavesPresent(TreeNode subtree, Stack<Integer> leaves) {
        boolean result = true;
        if(subtree.right!=null) {
            result = leavesPresent(subtree.right, leaves);
        }
        if(subtree.left!=null) {
            return result && leavesPresent(subtree.left, leaves);
        }
        if(subtree.right!=null) {
            return result;
        }

        if(leaves.isEmpty()) return false;

        return subtree.val==leaves.pop();
    }
}
