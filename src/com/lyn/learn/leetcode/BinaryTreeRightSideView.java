package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideViewDFS(TreeNode root) {

        Map<Integer,Integer> rightMostNode = new HashMap<>();
        int maxDepth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        depthStack.push(0);
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){

            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if(node != null){

                maxDepth = Math.max(depth,maxDepth);
                if(!rightMostNode.containsKey(depth)){
                    rightMostNode.put(depth,node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);

                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i <= maxDepth; i++){
            res.add(rightMostNode.get(i));
        }
        return res;
    }

    public List<Integer> rightMostNodeBFS(TreeNode root){


        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        List<List<Integer>> layer = new ArrayList<>();
        while(!nodeQueue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            int size = nodeQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = nodeQueue.poll();
                cur.add(node.val);
                if(node.left != null){
                    nodeQueue.offer(node.left);
                }
                if(node.right != null){
                    nodeQueue.offer(node.right);
                }
            }
            layer.add(cur);
        }
        List<Integer> res = new ArrayList<>();
        for(List<Integer> list : layer){
            res.add(list.get(list.size() - 1));
        }
        return res;
    }

}
