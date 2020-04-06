/*
有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，
在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，v
图像元素小于等于256。
 */
package com.lyn.learn.CrackingTheInterview;

public class Transform {

    public int[][] transformImage(int[][] mat, int n){

        int rectangleNum = n % 2 == 0 ? n / 2 : (n + 1) / 2;
        for(int i = 0; i < rectangleNum; i++){
            int first = i;
            int last = n - 1 - i;
            for(int j = first; j < last; j++){
                int offset = j - first;
                int top = mat[first][j];
                // left -> top
                mat[first][j] = mat[last - offset][first];
                // bottom -> left
                mat[last - offset][first] = mat[last][last - offset];
                // right -> bottom
                mat[last][last - offset] = mat[j][last];
                // top -> right
                mat[j][last] = top;
            }
        }
        return mat;
    }
}
