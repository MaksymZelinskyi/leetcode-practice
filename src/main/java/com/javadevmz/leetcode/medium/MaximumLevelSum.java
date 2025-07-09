package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree

 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSum {

    public int maxLevelSum(TreeNode root) {
        //two queues for switching levels
        Queue<TreeNode> thisLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        //auxiliary variable
        Queue<TreeNode> emptyQueue = nextLevel;

        thisLevel.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int currentLevel = 1;
        int currentSum = 0;
        TreeNode node = null;

        //Breadth-first search
        while(!(thisLevel.isEmpty())) {
            while(!thisLevel.isEmpty()) {
                node = thisLevel.poll();
                currentSum+=node.val;
                if(node.left!=null)
                    nextLevel.add(node.left);
                if(node.right!=null)
                    nextLevel.add(node.right);
            }
            if(currentSum>maxSum) {
                maxSum = currentSum; //find the maximum sum
                maxLevel = currentLevel++;
            }
            //switch the level
            currentSum = 0;
            emptyQueue = thisLevel;
            thisLevel = nextLevel;
            nextLevel = emptyQueue;
        }

        return maxLevel;
    }
}
