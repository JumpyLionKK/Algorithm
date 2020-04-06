package com.lyn.learn.JiuZhangSenior;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        int[] cnt = new int[256];
        char[] sc = s.toCharArray();

        int ams = 0;
        int sum = 0;
        for(int l = 0, r = 0; r < sc.length; r++){
            cnt[sc[r]]++;
            if(cnt[sc[r]] == 1){
                sum ++;
            }

            while(sum > k){
                cnt[sc[l]]--;
                if(cnt[sc[l]] == 0){
                    sum --;
                }
                l++;
            }

            ams = Math.max(ams, r - l + 1);
        }
        return ams;
    }
}
