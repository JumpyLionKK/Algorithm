package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode prevNode = null;
    TreeNode firstStartNode = null;
    TreeNode lastStartNode = null;

    public void recoverTree(TreeNode root) {

        if(root == null) return;
        inorder(root);
        int val = firstStartNode.val;
        firstStartNode.val = lastStartNode.val;
        lastStartNode.val = val;
    }


    public void inorder(TreeNode root){

        if(root == null) return;

        inorder(root.left);
        if(prevNode != null){
            if(root.val < prevNode.val){
                if(firstStartNode == null){
                    firstStartNode = prevNode;
                }
                lastStartNode = root;
            }
        }
        prevNode = root;
        inorder(root.right);
    }
}
