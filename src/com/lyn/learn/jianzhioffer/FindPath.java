package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> singlePath = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        if(root == null) {
            return listAll;
        }
        singlePath.add(root.val);
        target -= root.val;
        if(target == 0 && (root.left == null && root.right == null)){
            listAll.add(new ArrayList<Integer>(singlePath));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        singlePath.remove(singlePath.size() - 1);

        return listAll;




    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }

}
