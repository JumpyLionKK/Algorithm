/*
有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
package com.lyn.learn.HuaWeiTestPractice;

public class RabbitCount {
    public int rabbitCount(int month){
        int[] res = new int[month];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;
        for(int i = 4; i < month; i++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[month -1];
    }
}
