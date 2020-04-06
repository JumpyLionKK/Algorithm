package com.lyn.learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    // recursion
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        traverse(root, result);

        return result;

    }

    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }

    // non-recursion
    public List<Integer> preorderTraversalII(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return result;
        }

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
