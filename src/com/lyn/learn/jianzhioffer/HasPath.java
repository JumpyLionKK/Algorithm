/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HasPath {
    public int[] dx = {0,0,-1,1};
    public int[] dy = {1,-1,0,0};
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){

        char[][] newMatrix = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                newMatrix[i][j] = matrix[i * cols + j];
            }
        }
        boolean[][] visited;
        List<Character> array = new ArrayList<>();
        for(char c : str){
            array.add(c);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(newMatrix[i][j] == str[0]){
                    visited = new boolean[rows][cols];
                    visited[i][j] = true;
                    if(hasPathCore(i, j, newMatrix, visited, rows, cols, array.subList(1,array.size()))){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean hasPathCore(int curRow, int curCol, char[][] matrix, boolean[][] visited, int rows, int cols, List<Character> str){
        if(str == null){
            return true;
        }

        boolean[] HasPath = new boolean[4];
        for(int i = 0; i < 4; i++){
            int newRow = curRow + dy[i];
            int newCol = curCol + dx[i];
            if( inbound(newRow, newCol, rows, cols) && matrix[newRow][newCol] == str.get(0) && visited[newRow][newCol] == false){
                visited[newRow][newCol] = true;
                if(str.size() == 1){
                    HasPath[i] = hasPathCore(newRow, newCol, matrix, visited, rows, cols, null);
                }else{
                    HasPath[i] = hasPathCore(newRow, newCol, matrix, visited, rows, cols, str.subList(1,str.size()));
                }
            }
        }
        return HasPath[0] || HasPath[1] || HasPath[2] || HasPath[3];

    }


    public boolean inbound(int x, int y, int rows, int cols){
        if(x < 0 || x >= rows || y < 0 || y >= cols){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        char[] str = {'a','b', 'c', 'e', 's', 'f', 's', 's', 'a', 'd', 'e', 'e'};
        HasPath hasPath = new HasPath();
        char[] target = {'b', 'c', 'c', 'e', 'd'};
        System.out.println(hasPath.hasPath(str, 3, 4, target));
    }
}
