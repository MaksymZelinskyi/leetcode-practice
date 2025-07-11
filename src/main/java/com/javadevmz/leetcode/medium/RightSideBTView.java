package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View

 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class RightSideBTView {

    int lastLevel = -1;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightValues = new LinkedList<>(); //faster if no random access is made
        traverse(root, rightValues, 0);
        return rightValues;
    }

    /*
    Depth-first search the rightmost nodes.
     */
    public void traverse(TreeNode node, List<Integer> values, int level) {
        if(node==null) return;
        //if this level hasn't been processed yet
        if(level>lastLevel) {
            values.add(node.val);//add the rightmost node
            lastLevel = level; //mark the level as processed
        }
        traverse(node.right, values, level+1); //start on the right
        traverse(node.left, values, level+1);
    }
}
