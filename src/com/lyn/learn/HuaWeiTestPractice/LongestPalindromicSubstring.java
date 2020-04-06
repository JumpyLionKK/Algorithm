/*
Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗
 */
package com.lyn.learn.HuaWeiTestPractice;

public class LongestPalindromicSubstring {
    public int longestPalindromicSubstring(String str){
        char[] array = str.toCharArray();
        int n = array.length;
        boolean[][] dp = new boolean[n][n];

        int max = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                if(j == i){
                    dp[j][i] = true;
                }else if(j + 1 == i){
                    dp[j][i] = array[i] == array[j];
                }else if(j + 1 < i){
                    dp[j][i] = dp[j + 1][i - 1] && array[i] == array[j];
                }
                if(dp[j][j] && max < i + j - 1){
                    max = i + j - 1;
                }
            }
        }
        return max;

    }
}
