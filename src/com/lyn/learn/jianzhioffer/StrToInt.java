package com.lyn.learn.jianzhioffer;

public class StrToInt {
    public int strToInt(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int start = 0;
        int sum = 0;

        char[] array = str.toCharArray();
        if(array[0] == '-' || array[0] == '+'){
            start = 1;
        }
        for(int i = start; i < array.length; i++){
            if(array[i] == ' ' || charToInt(array[i]) > 9 || charToInt(array[i]) < 0){
                return 0;
            }
            if (array[0] == '-') {
                sum += -1 * charToInt(array[i]) *  Math.pow(10, array.length - i - 1);
            }else{
                sum += charToInt(array[i]) *  Math.pow(10, array.length - i - 1);
            }

        }
        return sum;
    }

    public int charToInt(char character){
        return character - '0';
    }

    public static void main(String[] args){
        String str = "-123";
        StrToInt strToInt = new StrToInt();

        System.out.println(strToInt.strToInt(str));
    }
}
