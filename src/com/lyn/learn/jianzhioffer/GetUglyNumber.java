/*
* 描述： 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
* signature：
*   input：int
*   output： int*/

/*
 * solution:
 *  1. 对于新生成的丑数，必然是之前所有的丑数乘2，乘3，乘5中最小的一个
 *  2. 假设之前的丑数均已排序，对于乘2来说，存在某一个丑数t2,在他之前的数乘以2的结果都会小于已有的最大丑数，在他之后的数乘以2会比最大的丑数大，t3, t5同理
 *  3. 记录下t2,t3,t5的位置并维护
 */

package com.lyn.learn.jianzhioffer;

import java.util.ArrayList;

public class GetUglyNumber {

    public int getUglyNumber(int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index < 7) return index;
        list.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i = 1; i < index; i++){
            list.add(Math.min(Math.min(list.get(t2) * 2, list.get(t3) * 3), list.get(t5) * 5));
            if(list.get(i) == list.get(t2) * 2) t2++;
            if(list.get(i) == list.get(t3) * 3) t3++;
            if(list.get(i) == list.get(t5) * 5) t5++;
        }

        return list.get(index - 1);

    }



}
