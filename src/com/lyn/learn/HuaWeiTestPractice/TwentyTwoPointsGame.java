package com.lyn.learn.HuaWeiTestPractice;

import java.util.ArrayList;

public class TwentyTwoPointsGame {


    public static boolean dfs(ArrayList<Integer> array){

        if(array.size() == 1 && (array.get(0) < 24 || array.get(0) > 24)){
            return false;
        }
        if(array.size() == 1 && array.get(0) == 24){
            return true;
        }

        boolean flag = false;

        for(int i = 0; i < array.size() - 1; i++){
            for(int j = i + 1; j < array.size(); j++){
                for(int k = 0; k < 4; k++){
                    int resultOfTwo = 0;
                    int num1 = array.get(i);
                    int num2 = array.get(j);
                    switch (k){
                        case 0:
                            resultOfTwo = array.get(i) + array.get(j);
                            break;
                        case 1:
                            resultOfTwo = array.get(i) - array.get(j);
                            break;
                        case 2:
                            resultOfTwo = array.get(i) * array.get(j);
                            break;
                        case 3:
                            if(array.get(j) == 0){
                                break;
                            }
                            resultOfTwo = array.get(i) / array.get(j);
                            break;
                    }
                    ArrayList<Integer> newArray = new ArrayList<>();
                    for(int l = 0; l < array.size(); l++){
                        if(l != i && l != j){
                            newArray.add(array.get(l));
                        }
                    }
                    newArray.add(resultOfTwo);
                    flag = dfs(newArray);

                    if(flag){
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(0);

        arrayList.add(3);
        arrayList.add(4);
        System.out.println(dfs(arrayList));

    }
}
