/*Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

        This matrix has the following properties:

        Integers in each row are sorted from left to right.
        Integers in each column are sorted from up to bottom.
        No duplicate integers in each row or column.

Example:
        [
        [1, 3, 5, 7],
        [2, 4, 7, 8],
        [3, 5, 9, 10]
        ]
Given target = 3, return 2 */

package com.lyn.learn.leetcode;

public class search_a_2D_matrix2 {
    public static int searchMatrix(int[][] array, int target) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        if (array[0].length == 0 || array[0] == null) {
            return 0;
        }
        int count = 0;
        int m = array.length - 1;
        int n = 0;
        while (m >=0 && n <= array[0].length - 1) {
            if (array[m][n] > target) {
                m --;
            }else if (array[m][n] == target) {
                count ++;
                m --;
            }else {
                n ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                { 1,3,5,7 },
                { 2,4,7,8 },
                { 3,5,9,10 }
        };
        System.out.println(searchMatrix(array, 3));
    }


}
