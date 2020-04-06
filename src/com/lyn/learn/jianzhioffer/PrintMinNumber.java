/*描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
* signature:
* inpput: array of numbers
* output: String
* example:
* {3, 32, 321} => 321323
* {1, 43, 321, 432} => 132143243*/

/*
* solution:
* 因为返回的时最小的数，需要找到两个数谁先谁后的规律，由于ab与ba数位必然相等，可以利用比较器比较两者大小，以此规律对整个数组进行排序
* 如：
* {1, 43, 321, 432} => {1, 321, 432, 43}*/

// comparetor: 返回正数时是升序，负数为降序

package com.lyn.learn.jianzhioffer;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public String printMinNumber(int[] numbers){
        if(numbers == null || numbers.length == 0){
            return "";
        }

        String[] str = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Cmp());
        String ans = "";
        for(int i = 0; i < str.length; i++){
            ans += str[i];
        }
        return ans;

    }

    class Cmp implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ba.compareTo(ab);
        }
    }
}
