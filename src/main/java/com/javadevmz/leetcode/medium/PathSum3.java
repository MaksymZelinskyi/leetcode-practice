package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

/**
 * 437. Path Sum III

 * premium lock iconCompanies

 * Given the root of a binary tree and an integer targetSum,
 * return the number of paths where the sum of the values along the path equals targetSum.

 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 */
public class PathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;

        int count = countPathsFrom(root, targetSum); //count paths starting at this node
        count += pathSum(root.left, targetSum); //repeat for the left child
        count += pathSum(root.right, targetSum); //repeat for the right child

        return count;
    }

    int countPathsFrom(TreeNode root, long sum) {
        if(root == null) return 0; //base case
        int count = 0;

        count += countPathsFrom(root.left, sum-root.val); //count paths passing by the left

        count += countPathsFrom(root.right, sum-root.val); //count paths passing by the left

        if(root.val==sum) count++; // if the current value completes the sum, mark the end of a path
        return count;
    }
}
