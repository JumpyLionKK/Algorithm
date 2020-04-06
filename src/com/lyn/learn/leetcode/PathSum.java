package com.lyn.learn.leetcode;


import com.lyn.learn.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum){

        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        pathSumCore(root, sum, cur, res);
        return res;

    }

    public void pathSumCore(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res){

        if(root == null) return;

        if(root.left == null && root.right == null && root.val == sum){
            cur.add(root.val);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }

        cur.add(root.val);
        sum -= root.val;
        pathSumCore(root.left, sum, cur, res);
        pathSumCore(root.right, sum, cur, res);
        cur.remove(cur.size() - 1);
        return;
    }
}
