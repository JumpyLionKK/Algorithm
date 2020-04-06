package com.lyn.learn.jianzhioffer;

import com.lyn.learn.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
        return res;
    }
}
