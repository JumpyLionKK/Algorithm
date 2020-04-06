package com.lyn.learn.Sorting.leetcodeProblems;

import java.util.HashSet;

public class findWords {


    public boolean findWords(String word, HashSet<String> set){


        return helper(word, set, 0, new Boolean[word.length()]);



    }

    private boolean helper(String word, HashSet<String> set, int start, Boolean[] list ) {

        if(start == word.length()){
            return true;
        }

        if(list[start] != null) {
            return list[start];
        }



        for(int end = start + 1; end <= word.length(); end ++){
            if(set.contains(word.substring(start, end)) && helper(word, set, end, list)) {
                return list[start] = true;
            }
        }

        return list[start] = false;
    }



}
