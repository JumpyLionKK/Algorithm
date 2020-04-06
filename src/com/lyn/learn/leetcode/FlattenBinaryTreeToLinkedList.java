package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList {

    TreeNode prevNode = null;
    public void flatten(TreeNode root) {

        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prevNode;
        root.left = null;
        prevNode = root;


    }

}
