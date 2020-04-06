package com.lyn.learn.jianzhioffer;

public class Match {

    public static boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i ++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.') dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }


    public static void main(String[] args){
        char[] str = {'a', 'a', 'c'};
        char[] pattern = {'a', 'a', '*', 'c'};
        System.out.println(match(str, pattern));
    }
}
