package com.lyn.learn.BFSAndTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here

        // collect indegree
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++){
            edges[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = (int)queue.poll();
            order.add(temp);
            count ++;
            int size = edges[temp].size();
            for(int i = 0; i < size; i++){
                int pointer = (int)edges[temp].get(i);
                indegree[pointer]--;
                if(indegree[pointer] == 0){
                    queue.offer(pointer);
                }
            }
        }
        if(count != numCourses){
            return new int[0];
        }
        int[] res = new int[order.size()];
        for(int i = 0; i < order.size(); i++){
            res[i] = order.get(i);
        }
        return res;
    }

}
