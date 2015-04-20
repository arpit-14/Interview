/* https://leetcode.com/problems/find-peak-element/
 * https://leetcode.com/submissions/detail/24241090/
 * 
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
 * 
 * */

package com.arpit.leetcode;

public class FindPeakElement {

    public int findPeakElement(int[] num) {
        
        int n = num.length;
        
        if(n==1){
            return 0;
        }
        
        if(num[0]>num[1]){
            return 0;
        }else if(num[n-1]>num[n-2]){
            return n-1;
        }
        
        int beg = 0;
        int end = n-1;
        
       
        
        while(beg<=end){
            int mid = (beg+end)/2;
            
            if(num[mid]>num[mid-1] && num[mid]>num[mid+1]){ // maxima
                return mid;
            }else if(num[mid]>num[mid-1] && num[mid]<num[mid+1]){ //increasing
                beg = mid;
            }else if(num[mid]<num[mid-1] && num[mid]>num[mid+1]){ //decreasing
                end = mid;
            }else{ //minima
                beg = mid;
            } 
            
            
        }
        
        return -1;
        
    }
}