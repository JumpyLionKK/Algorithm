/*

1.有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。

给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12
 */
/*
2.有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。

给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，
为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
package com.lyn.learn.CrackingTheInterview;

public class Robot {
    public static int countWays1(int x, int y){
        int[] dx = {0, -1};
        int[] dy = { -1, 0};
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < 2; k++){
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if(inbound(x, y, newX, newY)){
                        dp[i][j] += dp[newX][newY];
                    }
                }
            }
        }
        return dp[x - 1][y - 1];

    }

    public static int countWays2(int[][] map, int x, int y){
        int[] dx = {0, -1};
        int[] dy = { -1, 0};
        int[][] dp = new int[x][y];
        dp[0][0] = 1;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < 2; k++){
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if(inbound(x, y, newX, newY) && map[i][j] == 1 && map[newX][newY] == 1){
                        dp[i][j] += dp[newX][newY];
                    }
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public static boolean inbound(int x, int y, int row, int col){
        if(row < 0 || row >= x){
            return false;
        }
        if(col < 0 || col >= y){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println();
    }
}
