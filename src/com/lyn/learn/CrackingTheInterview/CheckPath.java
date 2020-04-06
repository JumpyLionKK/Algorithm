/*
对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。

给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b
(请不要在意数据类型，图是有向图),请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
package com.lyn.learn.CrackingTheInterview;


import java.util.*;

public class CheckPath {

    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        return checkPathCore(a, b) && checkPathCore(b, a);


    }

    public boolean checkPathCore(UndirectedGraphNode a, UndirectedGraphNode b){

        if(a == null || b == null){
            return false;

        }

        if(a == b){
            return true;
        }


        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(a);
        visited.add(a);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                UndirectedGraphNode node = queue.poll();
                if(node.neighbors != null){
                    for(UndirectedGraphNode c : node.neighbors){
                        if(c != null){
                            if(c == b){
                                return true;
                            }else{
                                if(!visited.contains(c)){
                                    queue.offer(c);
                                    visited.add(c);
                                }

                            }
                        }
                    }
                }
            }
        }
        return false;



    }
}
