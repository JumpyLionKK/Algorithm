package com.lyn.learn.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    // recursion
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        traverse(root, inorder);
        return inorder;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }

    // non-recursion
    public List<Integer> inorderTraversalII(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            inorder.add(node.val);

            if(node.left == null) {
                node = stack.pop();
                while( !stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            }else {
                node = node.right;
                while(node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return inorder;
    }
}
