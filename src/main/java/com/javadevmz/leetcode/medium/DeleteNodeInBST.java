package com.javadevmz.leetcode.medium;

import com.javadevmz.leetcode.util.TreeNode;

/**
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 *     Search for a node to remove.
 *     If the node is found, delete the node.
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = root;
        TreeNode currentNode = root;
        boolean isLeft = false;

        //Binary-search the node, tracking the parent
        while(currentNode!=null && currentNode.val!=key) {
            parent = currentNode;
            if(currentNode.val>key) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }
        if(currentNode == null) {
            return root;
        }
        if(currentNode==parent.left) isLeft = true;

        TreeNode left = currentNode.left;
        TreeNode right = currentNode.right;

        //if there is only one child, just replace the node with it
        if(left==null) {
            currentNode = right;
        } else if(right == null) {
            currentNode = left;
        }else {
            TreeNode leafParent = right;
            currentNode = right;
            //find the leftmost leaf of the right subtree
            while(currentNode.left != null) {
                leafParent = currentNode;
                currentNode = leafParent.left; //new root of the subtree
            }
            //attach the left subtree
            if(currentNode!=right){
                leafParent.left = currentNode.right;
                currentNode.right = right;
            }
            currentNode.left = left;

        }
        if(root.val == key) return currentNode;

        //attach the subtree to the parent of the node being removed
        if(isLeft) parent.left = currentNode;
        else parent.right = currentNode;

        return root;
    }
}
