/*
请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。

给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
 */
package com.lyn.learn.CrackingTheInterview;

import com.lyn.learn.BinaryTree.TreeNode;

public class Successor {

    boolean flag=false;
    int result=-1;
    public int findSucc(TreeNode root, int p) {
        findSuccByCenterSort(root,p);
        return result;
    }
    public void findSuccByCenterSort(TreeNode root,int p) {
        if(root==null) return;
        if(root.left!=null) findSuccByCenterSort(root.left,p);
        if(flag) {
            flag=false;
            result=root.val;
        }
        if(root.val==p) flag=true;
        if(root.right!=null)findSuccByCenterSort(root.right,p);
    }

}
