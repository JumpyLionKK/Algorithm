/*
找出输入字符串中的重复字符,再根据ascii把重复的字符从小到大排序。
 */
package com.lyn.learn.HuaWeiTestPractice;

import java.util.*;

public class findDuplicate {
    public String findDuplicate(String str){

        Map<Character, Integer> map = new HashMap<>();
        char[] c = str.toCharArray();
        for(int i =0; i < c.length; i++){
            if(map.containsKey(c[i])){
                map.put(c[i], map.get(c[i]) + 1);
            }else{
                map.put(c[i], i);
            }
        }
        ArrayList<Character> lis = new ArrayList<>();
        for(int i = 0; i < c.length; i++){
            if(map.containsKey(c[i]) && map.get(c[i]) > 1){
                lis.add(c[i]);
                map.remove(c[i]);
            }
        }
        Collections.sort(lis);
        String res = "";
        for(Character i : lis){
            res += i;
        }
        return res;
    }
}
