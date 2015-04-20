/* https://leetcode.com/problems/merge-intervals/
 * https://leetcode.com/submissions/detail/24722156/
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 * */

package com.arpit.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.arpit.leetcode.util.Interval;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        
        int n = intervals.size();
        
        if(n<=1){
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Iterator<Interval> itr = intervals.iterator();
        
        for(int i=0; i<intervals.size()-1; ){
            
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i+1);
            
            if(next.start>=cur.start && next.start<=cur.end){
                if(next.end>cur.end){
                    cur.end = next.end;
                }
                intervals.remove(next);
            }else{
                i++;
            }
        
            
        }
        
        
        return intervals;
    }
}