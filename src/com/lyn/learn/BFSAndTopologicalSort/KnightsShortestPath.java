package com.lyn.learn.BFSAndTopologicalSort;

import java.util.LinkedList;
import java.util.Queue;


public class KnightsShortestPath {
    public static int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] deltaX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] deltaY = {2, -2, 2, -2, 1, -1, 1, -1};

        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Point temp = queue.poll();
                if(temp.x == destination.x && temp.y == destination.y){
                    return step;
                }

                for(int j = 0; j < 8; j++){
                    Point newSource = new Point(temp.x + deltaX[j], temp.y + deltaY[j]);
                    if(!inbound(grid, newSource)){
                        continue;
                    }
                    queue.offer(newSource);
                    grid[newSource.x][newSource.y] = true;

                }
            }
            step ++;

        }

        return -1;
    }

    private static boolean inbound(boolean[][] grid, Point source){
        if(source.x >= grid.length || source.x < 0){
            return false;
        }
        if(source.y >= grid[0].length || source.y < 0) {
            return false;
        }
        return grid[source.x][source.y] == false;
    }

    public static void main(String[] args){
        boolean[][] A = {{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
        shortestPath(A, new Point(2,0), new Point(2,2));
    }
}
