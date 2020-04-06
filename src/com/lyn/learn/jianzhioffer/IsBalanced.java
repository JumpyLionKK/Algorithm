package com.lyn.learn.jianzhioffer;

import com.lyn.learn.BinaryTree.TreeNode;

public class IsBalanced {
    // 1. from top to bottom
    public boolean isBalanced(TreeNode root){

        if(root == null){
            return true;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 ? isBalanced(root.left) && isBalanced(root.right) : false;
    }

    public int TreeDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

    }
    // 2. from bottom to top
    public boolean IsBalanced_Solution(TreeNode root){
        return TreeHeight(root) != -1;

    }

    public int TreeHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = TreeHeight(root.left);
        if(left == -1) return -1;
        int right = TreeHeight(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
