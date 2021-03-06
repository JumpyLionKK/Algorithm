package com.lyn.learn.Sorting.leetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
        if(newInterval == null) {
            return intervals;
        }
        int i = 0;
        List<Interval> res = new ArrayList<>();
        while(i < intervals.size() && intervals.get(i).end <= newInterval.start){
            res.add(intervals.get(i++));
        }

        while(i < intervals.size() && intervals.get(i).start < newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()){
            res.add(intervals.get(i++));
        }

        return res;
    }
}
