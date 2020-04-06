package com.lyn.learn.jianzhioffer;

import com.lyn.learn.BinaryTree.TreeNode;

import java.util.ArrayList;

public class KthNode {

    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode kthNode(TreeNode pRoot, int k){
        if(k <= 0 || pRoot == null){
            return null;
        }
        preOrderTraversal(pRoot);
        if(list.size() < k){
            return null;
        }
        return list.get(k - 1);
    }

    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        preOrderTraversal(root.left);
        list.add(root);
        preOrderTraversal(root.right);

    }
}
