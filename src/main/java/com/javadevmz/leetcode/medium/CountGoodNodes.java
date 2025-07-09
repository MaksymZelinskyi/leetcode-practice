package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree

 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

 * Return the number of good nodes in the binary tree.
 */
public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        return goodNodesWithGreatest(root, root.val);
    }

    int goodNodesWithGreatest(TreeNode root, int greatest) {

        boolean good = true;
        int count = 0;

        //there was a node with a greater value before
        if(greatest>root.val){
            good = false;
        }
        else {
            count++;
            greatest = root.val; //new greatest
        }

        if(root.left!=null) {
            count += goodNodesWithGreatest(root.left, greatest);
        }
        if(root.right!=null) {
            count += goodNodesWithGreatest(root.right, greatest);
        }
        return count;
    }
}
