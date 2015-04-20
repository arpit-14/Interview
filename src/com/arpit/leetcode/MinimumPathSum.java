/* https://leetcode.com/problems/minimum-path-sum/
 * https://leetcode.com/submissions/detail/25430474/
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * 
 * */

package com.arpit.leetcode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        
        int n=0;
        if(m==0){
            return 0;
        }else{
            n = grid[0].length;
        }
        
        int[][] minSum = new int[m][n];
        
        
        minSum[m-1][n-1] = grid[m-1][n-1];
        
        // popuate last row
        for(int i=n-2; i>=0; i--){
            minSum[m-1][i] = grid[m-1][i] + minSum[m-1][i+1];
        }
        
        // popuate last column        
        for(int i=m-2; i>=0; i--){
            minSum[i][n-1] = grid[i][n-1] + minSum[i+1][n-1];
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                
                int min=0;
                int right = minSum[i][j+1];
                int bottom = minSum[i+1][j];
                
                if(right<=bottom){
                    min = right;
                }else{
                    min = bottom;
                }
                
                minSum[i][j] = grid[i][j] + min;
                
            }
        }
    
    
        return  minSum[0][0];
    }
    
    
    
}