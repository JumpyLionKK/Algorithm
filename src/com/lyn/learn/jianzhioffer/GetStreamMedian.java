/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
package com.lyn.learn.jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GetStreamMedian {
    int count = 0;

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        count++;
        if((count & 1) == 0){
            maxHeap.offer(num);
            int filteredNum = maxHeap.poll();

            minHeap.offer(filteredNum);
        }else{

            minHeap.offer(num);
            int filteredNum = minHeap.poll();
            maxHeap.offer(filteredNum);
        }


    }

    public Double GetMedian() {
        if((count & 1) == 0){
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }else{
            return (double)maxHeap.peek();
        }
    }

    public static void main(String[] args){
        GetStreamMedian getStreamMedian = new GetStreamMedian();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            getStreamMedian.Insert(sc.nextInt());
            System.out.println(getStreamMedian.GetMedian());
        }
    }
}
