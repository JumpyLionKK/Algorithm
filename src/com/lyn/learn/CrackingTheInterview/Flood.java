/*
在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。
请返回洪水流到(n - 1,m - 1)
的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。

给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。
 */
package com.lyn.learn.CrackingTheInterview;

public class Flood {
    public static int floodFill(int[][] map, int n, int m) {
        // BFS
        int[][] dp = new int[n][m];
        int[] dx = {0,-1};
        int[] dy = {-1,0};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < 2; k++){
                    int prevRow = i + dx[k];
                    int prevCol = j + dy[k];
                    if(isInbound(n,m,prevRow,prevCol) && map[i][j] == 0 && dp[prevRow][prevCol] != Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j], dp[prevRow][prevCol] + 1);
                    }
                }
            }
        }



        return dp[n - 1][m - 1];


    }

    public static boolean isInbound(int n, int m, int row, int col){

        if(row < 0 || row >= n){
            return false;
        }

        if(col < 0 || col >= m){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[][] map = {{0,0,1},{1,0,0},{0,0,0}};
        System.out.println(floodFill(map, 3, 3));

    }
}
