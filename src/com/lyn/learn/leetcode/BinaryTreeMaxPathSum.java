package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

public class BinaryTreeMaxPathSum {

    private static int maxSum;

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        maxPathSumDownRecur(root);

        return maxSum;
    }

    private int maxPathSumDownRecur(TreeNode root) {

        if (root == null)
            return 0;

        int leftResult = Math.max(0, maxPathSumDownRecur(root.left));
        int rightResult = Math.max(0, maxPathSumDownRecur(root.right));

        maxSum = Math.max(leftResult + rightResult + root.val, maxSum);

        return Math.max(leftResult, rightResult) + root.val;
    }


}
