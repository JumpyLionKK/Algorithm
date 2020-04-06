/*
given an array of integers, return indices of the two numbers such that they add up to a specific target,
you may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given numbers = [2,7,11,15] target = 9,
return [0,1];


algorithm:
    create a hash map, iterate through the given array:
    [2,7,11,15]
    array[0] = 2;
    map.put(target - array[0], index);
    for c in array:
        if (map.containsKey(c))
            return [index of c, map.get(c)];

    time complexity is O(n), space complexity is O(n)
*/
package com.lyn.learn.leetcode;

import java.util.HashMap;

public class Two_Sum {
    public static int[] twoSum(int[] array, int target) {
        if (array == null || array.length == 0) {
            return array;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < array.length; i ++) {
            if (map.containsKey(array[i])){
                result[0] = map.get(array[i]);
                result[1] = i;
                return result;
            }else {
                map.put(target - array[i], i);
            }
        }
        return result;
    }

    public static void main(String[] arg) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);



    }

}
