/*
问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，
并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
输入：
包含已知数字的9X9盘面数组[空缺位以数字0表示]
输出：
完整的9X9盘面数组

输入描述:
包含已知数字的9X9盘面数组[空缺位以数字0表示]

输出描述:
完整的9X9盘面数组
 */
package com.lyn.learn.HuaWeiTestPractice;

public class Sudoku {
    public void sudoku(int[][] array){
        int step = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                if(array[i][j] == 0){
                    step++;
                }
            }
        }
        dfs(array, step);
    }

    public int dfs(int[][] array, int step){
        if(step == 0){
            return 0;
        }

        int row = array.length;
        int column = array[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(array[i][j] == 0){
                    for(int k = 1; k <= 10; k++){
                        if( k == 10){
                            return step;
                        }
                        array[i][j] = k;
                        if(!isValid(array, i, j)){
                            array[i][j] = 0;
                        }else{
                            step --;
                            step = dfs(array, step);
                            if(step == 0){
                                return 0;
                            }
                            array[i][j] = 0;
                            step ++;
                        }

                    }
                }
            }
        }
        return step;
    }

    public boolean isValid(int[][] array, int row, int colum){

        boolean[] check = new boolean[10];
        // check row
        for(int i = 0; i < row; i++){
            if(check[array[i][colum]] == false){
                check[array[i][colum]] = true;
            }else{
                return false;
            }
        }

        // check column
        boolean[] check1 = new boolean[10];
        for(int i = 0; i < colum; i++){
            if(check1[array[row][i]] == false){
                check1[array[row][i]] = true;
            }else{
                return false;
            }
        }

        // check 3 * 3
        boolean[] check2 = new boolean[10];
        int rowTemp = (row / 3) * 3;
        int colTemp = (colum / 3) * 3;
        for(int k = 0; k < 9; k++){
            int r = rowTemp + k / 3;
            int c = colTemp + k % 3;
            if(check2[array[r][c]] == false){
                check2[array[r][c]] = true;
            }else{
                return false;
            }
        }
        return true;
    }
}
