package com.lyn.learn.JiuZhangSenior;

public class ConnectingGraphII {
    private int[] father = null;
    private int[] size = null;

    private int find(int x){
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }

    public ConnectingGraphII(int n){
        father = new int[n + 1];
        size = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            father[i] = i;
            size[i] = 1;
        }
    }

    public void connect(int a, int b ){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            father[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }

    public int query(int a){
        int root_a = find(a);
        return size[root_a];
    }


}
