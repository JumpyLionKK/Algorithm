package com.lyn.learn.leetcode;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {

        int len = s.length();
        int period = 2*(numRows - 1);
        int col;
        if(numRows > 1){
            if(len % period < numRows){
                col = (len / period) * (numRows - 1) + 1;
            }else{
                col = (len / period) * (numRows - 1) + 1 + (len % period) - numRows;
            }
        }else{
            col = len;
        }
        char[][] array = new char[numRows][col];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < col; j++){
                array[i][j] = ' ';
            }
        }
        int totalCycle = len % period == 0 ? len / period : len / period + 1;
        int index = 0;
        for(int i = 0; i < totalCycle; i++){
            for(int j = 0; j < numRows - 1; j++){
                if(j == 0){
                    int count = 0;
                    while(count < numRows && index < len){
                        array[count][i*(numRows - 1)] = s.charAt(index++);
                        count ++;
                    }
                }else{
                    array[numRows - 1 - j][i*(numRows - 1) + j]=s.charAt(index++);
                }
                if(index >= len){
                    break;
                }
            }
        }
        String res = "";
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < col; j++){
                if(array[i][j] != ' '){
                    res += array[i][j];
                }
            }
        }
        return res;

    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
