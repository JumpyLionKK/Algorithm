/*
    Given a string, find the length of the longest substring without repeating characters.\
    Example:
    Given "abcabcbb", answer is "abc"
    Given "bbbbb" answer is "b"
    Given "pwwkew" answer is "kew"

    Algorithm: use hashmap, try to extend range[i, j]
               Time complexity is O(n)
               Space complexity is O(n)
*/
package com.lyn.learn.leetcode;

import java.util.HashMap;


public class longestSubstringWihoutReapeating {
    public static int findLongestSubstring(String s){
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i) ;
                //i = map.get(s.charAt(j));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] arg) {
        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(findLongestSubstring(str1));
        System.out.println(findLongestSubstring(str2));
        System.out.println(findLongestSubstring(str3));


    }
}
