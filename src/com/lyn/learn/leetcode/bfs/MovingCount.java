package com.lyn.learn.leetcode.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    public static int movingCount(int m, int n, int k) {
        int[][] metrix = new int[m][n];
        Queue<Pair<Integer, Integer>> statusQueue = new LinkedList<>();
        statusQueue.add(new Pair<>(0,0));
        metrix[0][0] = 1;
        int result = 1;
        while (!statusQueue.isEmpty()) {
            Pair<Integer, Integer> pair = statusQueue.poll();
            if (isReachable(pair.getKey() + 1, pair.getValue(), k, m, n) && metrix[pair.getKey() + 1][pair.getValue()] != 1) {
                statusQueue.offer(new Pair<Integer, Integer>(pair.getKey() + 1, pair.getValue()));
                metrix[pair.getKey() + 1][pair.getValue()] = 1;
                result++;
            }
            if (isReachable(pair.getKey() - 1, pair.getValue(), k, m, n) && metrix[pair.getKey() - 1][pair.getValue()] != 1) {
                statusQueue.offer(new Pair<Integer, Integer>(pair.getKey() - 1, pair.getValue()));
                metrix[pair.getKey() - 1][pair.getValue()] = 1;
                result++;
            }
            if (isReachable(pair.getKey(), pair.getValue() + 1, k, m, n) && metrix[pair.getKey()][pair.getValue() + 1] != 1) {
                statusQueue.offer(new Pair<Integer, Integer>(pair.getKey(), pair.getValue() + 1));
                metrix[pair.getKey()][pair.getValue() + 1] = 1;
                result++;
            }
            if (isReachable(pair.getKey(), pair.getValue() - 1, k, m, n) && metrix[pair.getKey()][pair.getValue() - 1] != 1) {
                statusQueue.offer(new Pair<Integer, Integer>(pair.getKey(), pair.getValue() - 1));
                metrix[pair.getKey()][pair.getValue() - 1] = 1;
                result++;
            }
        }
        return result;
    }

    private static boolean isReachable(int m, int n, int k, int maxRow, int maxColumn) {
        if (m < 0) {
            return false;
        }
        if (n < 0) {
            return false;
        }
        if (m >= maxRow || n >= maxColumn) {
            return false;
        }
        int sum1 = m / 10 + m % 10;
        int sum2 = n / 10 + n % 10;
        return sum1 + sum2 <= k;
    }

}
