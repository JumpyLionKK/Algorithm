/*
定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：


int maze[5][5] = {


        0, 1, 0, 0, 0,


        0, 1, 0, 1, 0,


        0, 0, 0, 0, 0,


        0, 1, 1, 1, 0,


        0, 0, 0, 1, 0,


};


它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。

Input

一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。

Output
 */
package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {
    public static class Point{
        public int x;
        public int y;
        public int value;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Point(int x, int y, int value) {
            this.x = x;

            this.y = y;
            this.value = value;
        }

        public String show(){
            return "(" + this.getX() + "," + this.getY() + ")";
        }
    }

    public static void shortestPath(int row, int column, int[][] maze){

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int[][] allPath = new int[row][column];
        int[][] visited = new int[row][column];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,0));
        visited[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point point = queue.poll();
                for(int j = 0; j < 4; j++){
                    int x = point.getX() + dx[j];
                    int y = point.getY() + dy[j];
                    if(inBound(row, column, x, y) && visited[x][y] == 0 && maze[x][y] == 0){
                        Point nextPosition = new Point(x,y,maze[x][y]);
                        visited[x][y] = 1;
                        allPath[x][y] = allPath[point.getX()][point.getY()] + 1;
                        queue.offer(nextPosition);
                    }

                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                System.out.print(allPath[i][j] + " ");
            }
            System.out.println("");
        }
        int value = allPath[row - 1][column - 1];
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(row -1, column -1, 0));

        int i = row - 1, j = column - 1;
        while(value >= 2){
            value = value - 1;
            for(int k = 0; k < 4; k++){
                int x = i + dx[k];
                int y = j + dy[k];
                if(inBound(row, column, x, y) && allPath[x][y] == value){
                    stack.push(new Point(x, y, maze[x][y]));
                    i = x;
                    j = y;
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop().show());
        }

    }

    public static boolean inBound(int row, int column, int x, int y){
        if( x >= 0 && x < row && y >= 0 && y < column){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = {{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 0, 0}};
        //ArrayList<Point> res = shortestPath(5,5,array);
        shortestPath(5,5,array);

    }

}
