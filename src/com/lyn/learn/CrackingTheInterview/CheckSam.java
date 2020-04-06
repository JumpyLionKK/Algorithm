/*
给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，
能否变成另一个字符串。这里规定大小写为不同字符，且考虑字符串中的空格
 */
package com.lyn.learn.CrackingTheInterview;

public class CheckSam {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        int[] check = new int[256];
        for(Character c : stringA.toCharArray()){
            check[c]++;
        }

        for(Character c : stringB.toCharArray()){
            check[c]--;
            if(check[c] < 0){
                return false;
            }
        }
        return true;
    }
}
