/* https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/submissions/detail/24680542/
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 * 
 * 
 * */

package com.arpit.leetcode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        
        int[][] mat = new int[m][n];
        
        for(int i=0; i<n; i++){ // last row
            mat[m-1][i] = 1;
        }
        
        for(int i=0; i<m; i++){ // last column
            mat[i][n-1] = 1;
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                mat[i][j] = mat[i][j+1] + mat[i+1][j];
            }
        }
        
        return mat[0][0];
        
        
    }
}