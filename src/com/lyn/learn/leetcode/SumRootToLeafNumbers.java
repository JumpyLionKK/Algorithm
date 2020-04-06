package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {


    public static int res = 0;

    public static int sumNumbers(TreeNode root) {

        sumNumbersCore(root, new ArrayList<Integer>());
        return res;
    }

    public static void sumNumbersCore(TreeNode root, List<Integer> curPath){

        if(root == null){
            return;
        }

        curPath.add(root.val);

        if(root.left == null && root.right == null){
            res += getSum(curPath);
            curPath.remove(curPath.size() - 1);
            return;
        }
        sumNumbersCore(root.left, curPath);
        sumNumbersCore(root.right, curPath);
        curPath.remove(curPath.size() - 1);


    }

    public static int getSum(List<Integer> array){

        int sum = 0;
        for(int i = 0; i < array.size(); i++){
            sum += Math.pow(10,array.size() - 1 - i) * array.get(i);
        }

        return sum;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));

    }
}
