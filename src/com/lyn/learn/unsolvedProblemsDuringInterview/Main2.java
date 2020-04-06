/*
有n个杀手排成一行，每个杀手都有一个不同的编号(编号为1-n)，
在每个夜晚，杀手都会行动，如果某个杀手编号大于他右边的杀手的编号，他就会杀死他右边的杀手，
杀手是的行动是瞬间的，因此一个人可能某一个夜晚既杀死了别人又被别人杀死，
例如3,2,1这个顺序，在第一个夜晚2会杀死1，同时3也会杀死2。

显而易见，一段时间之后，就不会有人杀或被杀，平安夜也就到来了，请问在平安夜之前有多少个夜晚
 */
// 找有多少个连续递减数列
package com.lyn.learn.unsolvedProblemsDuringInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static int[] findNumsOfContinuesDecreasingSeq(int[] array){


        int singleSeqStartIndex = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] < array[i + 1]){
                res.add(singleSeqStartIndex);
                singleSeqStartIndex = i + 1;
            }
        }
        if(singleSeqStartIndex == 0 || singleSeqStartIndex != res.get(res.size() - 1)){
            res.add(singleSeqStartIndex);
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[] array = new int[num];
            for(int i = 0; i < num; i++){
                array[i] = sc.nextInt();
            }
            int count = 0;
            int[] indexNum = findNumsOfContinuesDecreasingSeq(array);
            while(indexNum.length > 1){
                int[] newArray = new int[indexNum.length];
                for(int i = 0; i < indexNum.length; i++){
                    newArray[i] = array[indexNum[i]];
                }
                indexNum = findNumsOfContinuesDecreasingSeq(newArray);
                count++;
            }
            System.out.println(count + 1);
        }
    }
}
