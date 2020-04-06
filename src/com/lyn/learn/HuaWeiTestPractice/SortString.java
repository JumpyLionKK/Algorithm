package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortString {
    public static String sortString(String str){
        char[] stringList = str.toCharArray();
        ArrayList<Character> array = new ArrayList<>();
        for(int i = 0; i < stringList.length; i++){
            if((stringList[i] <= 'z' && stringList[i] >= 'a') || (stringList[i] <= 'Z' && stringList[i] >= 'A')){
                array.add(stringList[i]);
            }
        }
        Collections.sort(array, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                Character O1 = Character.toLowerCase(o1);
                Character O2 = Character.toLowerCase(o2);
                return O1.compareTo(O2);
            }
        });
        String temp = "";
        for(char s: array){
            temp += s;
        }
        StringBuilder sb = new StringBuilder(temp);
        for(int i = 0; i < stringList.length; i++){
            if(!((stringList[i] <= 'z' && stringList[i] >= 'a') || (stringList[i] <= 'Z' && stringList[i] >= 'A'))){
                sb.insert(i, stringList[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(sortString("A Famous Saying: Much Ado About Nothing(2012/8)."));
    }
}
