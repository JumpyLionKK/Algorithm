/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
package com.lyn.learn.jianzhioffer;

import com.lyn.learn.BinaryTree.TreeNode;

public class IsSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }

        return helper(pRoot.left, pRoot.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left == null) return right == null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }







}
