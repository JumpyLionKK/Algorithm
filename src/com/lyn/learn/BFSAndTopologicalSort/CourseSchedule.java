package com.lyn.learn.BFSAndTopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        while(!queue.isEmpty()){
            int temp = (int)queue.poll();
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
        return count == numCourses;
    }
}
