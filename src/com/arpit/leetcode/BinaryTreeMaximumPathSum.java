/* https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * https://leetcode.com/submissions/detail/24907329/
 * 
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * 
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxPathSum1(root);
        return maxSum;
        
    }
    
    public int maxPathSum1(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int lSum = maxPathSum1(root.left);
        int rSum = maxPathSum1(root.right);
        
        lSum = Math.max(lSum, 0);
        rSum = Math.max(rSum, 0);
        
        int sum = lSum + root.val + rSum;
        
        maxSum = Math.max(maxSum, sum);
        
        return Math.max(lSum, rSum) + root.val;
        
    }
}