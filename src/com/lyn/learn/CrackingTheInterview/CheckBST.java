/*
请实现一个函数，检查一棵二叉树是否为二叉查找树。

给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
package com.lyn.learn.CrackingTheInterview;

import com.lyn.learn.BinaryTree.TreeNode;

public class CheckBST {

    public boolean checkBST(TreeNode root){
        return checkBSTCore(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean checkBSTCore(TreeNode root, int max, int min){

        if(root == null){
            return true;
        }

        if(root.val < min || root.val >= max){
            return false;
        }

        if(!checkBSTCore(root.left, root.val, min) || !checkBSTCore(root.right, max, root.val)){
            return false;
        }

        return true;
    }
}
