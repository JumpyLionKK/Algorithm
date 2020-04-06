package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class SortAndDedupe {
    public static ArrayList<Integer> sortAndDedupe(int[] array){


        sort(array, 0, array.length - 1);

        return dedupe(array);

    }

    public static void sort(int[] array, int start, int end){

        if(start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, end);

    }


    public static void merge(int[] array, int start, int end){

        int mid = start + (end - start) / 2;
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        for(int k = 0; k < end - start + 1; k++){
            if(i <= mid && (j > end || array[i] < array[j])){
                temp[k] = array[i++];
            }else{
                temp[k] = array[j++];
            }
        }
        for(int k = 0; k < end - start + 1; k++){
            array[start + k] = temp[k];
            //sortedArray[start + k] = temp[k];
        }
    }


    public static ArrayList<Integer> dedupe(int[] array){
        //HashMap<Integer, Integer>

        ArrayList<Integer> newArray = new ArrayList<>();
        newArray.add(array[0]);
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[i - 1]){
                newArray.add(array[i]);
            }else{
                continue;
            }
        }
        return newArray;
    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int count = sc.nextInt();
//        int[] array = new int[count];
//        for(int i = 0; i < count; i++){
//            array[i] = sc.nextInt();
//        }
        int[] array = {5,5,5,4,3,2,7,8,7,3,1};
        SortAndDedupe sortAndDedupe = new SortAndDedupe();
        ArrayList<Integer> res = sortAndDedupe.sortAndDedupe(array);
        for(Integer c : res){
            System.out.println(c);

        }
    }
}
