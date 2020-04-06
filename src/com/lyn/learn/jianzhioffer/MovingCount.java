/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
package com.lyn.learn.jianzhioffer;

public class MovingCount {

    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int count = 0;

    public int movingCount(int threshold, int rows, int cols){

        boolean[][] visited = new boolean[rows][cols];

        return movingCountCore(0, 0, rows, cols, visited, threshold);

    }

    public int movingCountCore(int curRow, int curCol, int rows, int cols, boolean[][] visited, int threshold){

        if(rows == 1 && cols == 1){
            return 1;
        }
        for(int i = 0; i < 4; i++){
            int newRow = curRow + dy[i];
            int newCol = curCol + dx[i];
            if(inbound(rows, cols, newRow, newCol) && visited[newRow][newCol] == false && canEnter(newRow, newCol, threshold)){
                visited[newRow][newCol] = true;
                count = movingCountCore(newRow, newCol, rows, cols, visited, threshold) + 1;
            }
        }

        return count;
    }

    public boolean inbound(int rows, int cols ,int row, int col){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return false;
        }
        return true;
    }

    public boolean canEnter(int row, int col, int threshold){

        int rowSum = 0;
        int colSum = 0;
        while(row != 0){
            rowSum += row % 10;
            row = row / 10;
        }

        while(col != 0){
            colSum += col % 10;
            col = col / 10;
        }

        return rowSum + colSum <= threshold;
    }

}
