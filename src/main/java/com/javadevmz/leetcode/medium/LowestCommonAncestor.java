package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

import java.util.Stack;

/**
 * 236. Lowest Common Ancestor of a Binary Tree

 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
 * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pAncestors = new Stack<>();
        Stack<TreeNode> qAncestors = new Stack<>();
        findNode(root, p, pAncestors); //collect all p ancestors
        findNode(root, q, qAncestors); //collect all q ancestors

        // reach the moment at which the numbers of ancestors are equal by removing the highest ancestors from both stacks
        while(pAncestors.size()>qAncestors.size()) {
            pAncestors.pop();
        }
        while(qAncestors.size()>pAncestors.size()) {
            qAncestors.pop();
        }
        //Remove ancestors until the first common ancestor is reached. It's the lowest one because we are going up to the root
        while(!pAncestors.isEmpty() && !qAncestors.isEmpty()) {
            TreeNode lowestPAncestor = pAncestors.pop();
            TreeNode lowestQAncestor = qAncestors.pop();
            if(lowestPAncestor == lowestQAncestor) return lowestPAncestor;
        }
        return null;
    }

    /*
    Depth-first search the nodes
     */
    private boolean findNode(TreeNode root, TreeNode searchedNode, Stack<TreeNode> ancestors) {
        if(root==null) {
            return false;
        }
        ancestors.add(root);
        if(root==searchedNode) {
            return true;
        }
        boolean leftAncestor = findNode(root.left, searchedNode, ancestors);
        boolean rightAncestor = findNode(root.right, searchedNode, ancestors);
        if(leftAncestor || rightAncestor) return true;
        ancestors.pop();
        return false;
    }
}
