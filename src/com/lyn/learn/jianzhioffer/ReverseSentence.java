package com.lyn.learn.jianzhioffer;

public class ReverseSentence {
    public String reverseSentence(String str) {
        StringBuilder sb = new StringBuilder(str);
        String newString = sb.reverse().toString();
        String[] strList = newString.split(" ");
        String res = null;
        for(int i = 0; i < strList.length; i++){
            StringBuilder tmp = new StringBuilder(strList[i]);
            strList[i] = tmp.reverse().toString();
            res += strList[i] + " ";
        }
        return res.trim();




    }

}
