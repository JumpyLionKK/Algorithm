/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
 */
package com.lyn.learn.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class StringToInteger {

    public static int myAtoi(String str){

        boolean isNagtive = false;

        Queue<Integer> queue = new LinkedList<>();

        str = str.trim();
        if(str != null && str.length() != 0){
            if(str.charAt(0) == '+' || str.charAt(0) == '-'){
                isNagtive = str.charAt(0) == '+' ? false : true;
                if(str.length() > 1){
                    str = str.substring(1);
                }else{
                    return 0;
                }
            }

            if(str.charAt(0) < '0' || str.charAt(0) > '9') return 0;

            for(Character c : str.toCharArray()){
                if(c < '0' || c > '9') break;
                queue.offer(Integer.parseInt(Character.toString(c)));
            }
            long res = 0;
            while(!queue.isEmpty()){
                res += Math.pow(10,queue.size() - 1) * queue.poll();
            }
            res = isNagtive ? -1 * res : res;
            if(res <= Integer.MIN_VALUE){
                return  Integer.MIN_VALUE;
            }else if(res >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)res;

            }        }
        return 0;

    }
}
