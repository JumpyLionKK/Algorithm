package com.lyn.learn.leetcode.bfs;

import com.lyn.learn.BinaryTree.TreeNode;

public class SymmetricBinaryTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isUnitSymmetric(root.left, root.right);
    }

    private static boolean isUnitSymmetric(TreeNode node1, TreeNode node2) {
        // 递归结束条件：
        // 1. 都为空指针返回true
        // 2. 只有一个为空返回false
        if ((node1 == null) && (node2 == null)) return true;
        if ((node1 == null) || (node2 == null)) return false;

        return (node1.val == node2.val)
                && (isUnitSymmetric(node1.left, node2.right))
                && (isUnitSymmetric(node2.left, node1.right));
    }
}
