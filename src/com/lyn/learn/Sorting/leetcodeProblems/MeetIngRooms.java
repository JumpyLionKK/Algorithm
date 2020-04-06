package com.lyn.learn.Sorting.leetcodeProblems;

import java.util.Arrays;

public class MeetIngRooms {
    public static int meetingRooms(Interval[] intervals){
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIndex = 0;
        int room = 0;
        for(int j=0; j < start.length; j++){
            if(start[j] < end[endIndex]){
                room++;
            }else{
                endIndex++;
            }
        }
        return room;
    }
}
