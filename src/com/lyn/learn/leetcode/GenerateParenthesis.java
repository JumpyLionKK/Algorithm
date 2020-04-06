/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
package com.lyn.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n){

        List<String> res = new ArrayList<>();
        String cur = "";
        generateParenthesisCore(res, cur, 0, 0, n);
        return res;
    }

    public void generateParenthesisCore(List<String> res, String cur, int open, int end, int max){

        if(cur.length() == max * 2){
            res.add(cur);
            return;
        }

        if(open < max){
            generateParenthesisCore(res, cur+"(", open + 1, end, max);
        }

        if(end < open){
            generateParenthesisCore(res, cur + ")", open, end + 1, max);
        }




    }
}
