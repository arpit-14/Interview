/* https://leetcode.com/problems/insert-interval/
 * https://leetcode.com/submissions/detail/24722399/
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * */

package com.arpit.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.arpit.leetcode.util.Interval;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        int n = intervals.size();
        
        if(n==0){
            intervals.add(newInterval);
            return intervals;
        }
        
        if(newInterval.start > intervals.get(n-1).end ){
            intervals.add(newInterval);
            return intervals;
        }else if(newInterval.end < intervals.get(0).start){
            List<Interval> temp = new ArrayList<Interval>();
            temp.add(newInterval);
            temp.addAll(intervals);
            return temp;
        }
        
        int beg = 0;
        int end = 0;
        
        if(newInterval.start <= intervals.get(0).end){
            beg = 0;
        }else{
            for(int i=1; i<n; i++){
                if(newInterval.start > intervals.get(i-1).end && newInterval.start <= intervals.get(i).end){
                    beg = i;
                    break;
                }
            }
        }
            
        if(newInterval.end >= intervals.get(n-1).start){
            end = n-1;
        }else{
            for(int i=0; i<n-1; i++){
                if(newInterval.end >= intervals.get(i).start && newInterval.end < intervals.get(i+1).start){
                    end = i;
                    break;
                }
            }
        }
            
        int a = intervals.get(beg).start;
        int interval_start = newInterval.start < a ? newInterval.start : a ;
        
        a = intervals.get(end).end;
        int interval_end = newInterval.end > a ? newInterval.end : a ; 
        
        List<Interval> temp = new ArrayList<Interval>();
        temp.addAll(intervals.subList(0,beg));
        temp.add(new Interval(interval_start, interval_end));
        for(int i=end+1; i<=n-1; i++){
            temp.add(intervals.get(i));
        }
        
        return temp;
    }
}