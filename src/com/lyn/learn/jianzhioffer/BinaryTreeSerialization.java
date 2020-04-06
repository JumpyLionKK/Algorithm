/*
请实现两个函数，分别用来序列化和反序列化二叉树
 */
package com.lyn.learn.jianzhioffer;


import com.lyn.learn.BinaryTree.TreeNode;

public class BinaryTreeSerialization {

    int index = -1;
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if(root == null){
            sb.append('#');
            return sb.toString();
        }
        sb.append(root.val + ',');
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }



    TreeNode deserialize(String str) {
        index++;
        String[] array = str.split(",");
        TreeNode node = null;
        if(!array[index].equals("#")){
            node = new TreeNode(Integer.valueOf(array[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }
}
