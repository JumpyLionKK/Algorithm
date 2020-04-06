/*
对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。

给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回一个链表ListNode，代表该深度上所有结点的值，
请按树上从左往右的顺序链接，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
package com.lyn.learn.CrackingTheInterview;


import com.lyn.learn.BinaryTree.TreeNode;
import com.lyn.learn.leetcode.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeLevel {

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                temp.add(node.val);
            }
            res.add(temp);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ArrayList<Integer> target = res.get(dep);
        for(int i = 0; i < target.size(); i++){
            cur.next = new ListNode(target.get(i));
            cur = cur.next;
        }
        return dummy.next;
    }


}
