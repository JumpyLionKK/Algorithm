/*
有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。
下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

T R A I L B Z E S C D F G H J K M N O P Q U V W X Y

上面其他用字母表中剩余的字母填充完整。
在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 */
package com.lyn.learn.HuaWeiTestPractice;

import java.util.HashSet;
import java.util.Set;

public class Encrypt {
    public static String encrypt(String key, String data){
        String dedupeString = dedupe(key);
        String mask = "";
        for(int i = 0; i < 26; i++){
            mask += (char)('A' + i);
        }
        StringBuilder sb = new StringBuilder(mask);
        sb.insert(0, dedupeString);
        StringBuilder sb1 = new StringBuilder(dedupe(sb.toString()));
        String res = "";
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == ' '){
                res += ' ';
                continue;
            }
            if(data.charAt(i) >= 'a' && data.charAt(i) <= 'z'){
                res += Character.toLowerCase(sb1.charAt(Character.toUpperCase(data.charAt(i)) - 'A'));
            }else{
                res += sb1.charAt(data.charAt(i) - 'A');
            }
        }
        return res;

    }

    public static String dedupe(String str){
        StringBuilder sb = new StringBuilder(str);
        Set<Character> set = new HashSet<>();
        String s = "";
        for(int i = 0; i < sb.length(); i++){
            if(!set.contains(sb.charAt(i))){
                set.add(sb.charAt(i));
                s += sb.charAt(i);
            }
        }
        return s;
    }

    public static void main(String[] args){
        System.out.println(encrypt("TRAILBLAZERS", "Attack AT DAWN"));
    }
}
