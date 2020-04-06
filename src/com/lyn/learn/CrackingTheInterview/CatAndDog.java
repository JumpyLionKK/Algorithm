/*
        有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。

       给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，
       则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，\若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略
 */
package com.lyn.learn.CrackingTheInterview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CatAndDog {
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here

        LinkedList<int[]> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] items : ope) {

            if (items[0] == 1) {
                // 如果遇到宠物就加入列表中(收容所)
                list.add(items);
            } else if (items[0] == 2) {
                // 如果遇到收养人
                // 采取第一种收养方式
                if (items[1] == 0) {
                    if (!list.isEmpty()) {
                        int[] animal = list.remove(0);
                        res.add(animal[1]);
                    }
                } else {
                    // 收取猫或狗(若为1，则指定收养狗，若为-1则指定收养猫)
                    for (int i = 0; i < list.size(); i++) {
                        // 收容所有合适宠物则弹出
                        if ((items[1] == 1 && list.get(i)[1] > 0) || (items[1] == -1 && list.get(i)[1] < 0)) {
                            // 移除宠物
                            int[] animal = list.remove(i);
                            res.add(animal[1]);
                            // 结束本层循环
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
