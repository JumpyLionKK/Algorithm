package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;

public class TrainInStop {

    public ArrayList<ArrayList<Integer>> trainInStop(int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        helper(n, res, visited, new ArrayList<Integer>());
        return res;
    }

    public void helper(int n, ArrayList<ArrayList<Integer>> res, boolean[] visited, ArrayList<Integer> temp){

        if(temp.size() == n){
            res.add(new ArrayList<>(temp));
            //temp = new ArrayList<Integer>();
            return;
        }


        for(int i = 0; i < n; i++){
            if(!visited[i]){
                temp.add(i + 1);
                visited[i] = true;
                helper(n, res, visited,  temp);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
        return;
    }

    public static void main(String[] args){
        TrainInStop trainInStop = new TrainInStop();


        ArrayList<ArrayList<Integer>> res =trainInStop.trainInStop(3);
        for(ArrayList<Integer> c : res){
            for(Integer s: c){
                System.out.print(s + " ");

            }
            System.out.println("");
        }

    }


}
