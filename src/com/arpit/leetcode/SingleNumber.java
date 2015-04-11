/* https://leetcode.com/problems/single-number/
 
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 
 * https://leetcode.com/submissions/detail/23603418/
 * */

package com.arpit.leetcode;

public class SingleNumber {
    public int singleNumber(int[] A) {
        int ans = A[0];
        for(int i=1; i<A.length; i++){
            ans = ans^A[i];
        }
        return ans;
    }
}