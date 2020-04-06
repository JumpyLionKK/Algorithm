/*
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 */
package com.lyn.learn.jianzhioffer;

import com.lyn.learn.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintTreeNode {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        int level = 0;
        while(!deque.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            level++;
            int size = deque.size();
            if((level & 1) == 0){//偶数层倒序
                for(int i = 0; i < size; i++){
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if(node.right != null){
                        deque.addFirst(node.right);
                    }
                    if(node.left != null){
                        deque.addFirst(node.left);
                    }
                }
            }else{
                for(int i = 0; i < size; i++){
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);

                    if(node.left != null){
                        deque.addLast(node.left);
                    }
                    if(node.right != null){
                        deque.addLast(node.right);
                    }

                }
            }
            res.add(list);
        }
        return res;
    }
}
