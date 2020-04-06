/*
对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。

给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
package com.lyn.learn.CrackingTheInterview;


import com.lyn.learn.BinaryTree.TreeNode;

public class MinimalBST {
    public int buildMinimalBST(int[] vals) {
        // write code here
        TreeNode head = buildMinmalBSTCore(vals, 0, vals.length - 1);

        return getTreeHeight(head);
    }

    public TreeNode buildMinmalBSTCore(int[] vals, int start, int end){

        if(end < 0 || start >= vals.length || start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(vals[mid]);
        node.left = buildMinmalBSTCore(vals, start, mid - 1);
        node.right = buildMinmalBSTCore(vals, mid + 1, end);

        return node;

    }

    public int getTreeHeight(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
