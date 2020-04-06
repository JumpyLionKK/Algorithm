package com.lyn.learn.jianzhioffer;

import java.util.Stack;

public class ConvertBSTtoLinkedList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    // non-recursion
    public TreeNode convert(TreeNode pRootOfTree){
        Stack<TreeNode> stack = new Stack<>();
        if(pRootOfTree == null){
            return null;
        }
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        while(p != null || !stack.isEmpty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;

            }else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    public TreeNode convert1(TreeNode root){
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode left = convert1(root.left);
        TreeNode p = left;

        while(p != null && p.right != null){
            p = p.right;
        }

        if(left != null){
            p.right = root;
            root.left = p;
        }

        TreeNode right = convert1(root.right);
        if(right != null){
            right.left = root;
            root.right = right;
        }

        return left != null ? left : root;
    }
}
