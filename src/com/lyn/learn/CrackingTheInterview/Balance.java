/*
实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。

给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
package com.lyn.learn.CrackingTheInterview;

import com.lyn.learn.BinaryTree.TreeNode;

public class Balance {

    public boolean isBalance(TreeNode root) {
        // write code here
        return findHeight(root) != -1;

    }

    public int findHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftHeight = findHeight(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = findHeight(root.right);
        if(rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;


    }
}
