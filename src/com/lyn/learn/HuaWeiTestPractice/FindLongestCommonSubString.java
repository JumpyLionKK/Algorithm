package com.lyn.learn.HuaWeiTestPractice;

public class FindLongestCommonSubString {
    public String findLongetsCommonSubString(String str1, String str2){

        if(str1.length() > str2.length()){
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length + 1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j < dp[0].length + 1; j++){
            dp[0][j] = 0;
        }
        String res = "";

        for(int i = 1; i < dp.length + 1; i++){
            for(int j = 1; j<dp[0].length + 1; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = dp[i][j] > res.length() ? str1.substring(i - dp[i][j], i) : res;
                }
            }
        }
        return res;

    }
}
