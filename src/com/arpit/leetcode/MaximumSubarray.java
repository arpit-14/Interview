/* https://leetcode.com/problems/maximum-subarray/
 * https://leetcode.com/submissions/detail/24902357/
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * 
 * */

package com.arpit.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        
        int maxSum = Integer.MIN_VALUE;
        int n = A.length;
        int sum=0;
        
        for(int i=0; i<n; i++){
            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(0, sum);
        }
        
        return maxSum;
    }
}