/*https://leetcode.com/problems/maximum-depth-of-binary-tree/
 Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 
 * https://leetcode.com/submissions/detail/23603670/
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.TreeNode;


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        int height = 0;
        
        if(left > right){
            height = left + 1;
        }else{
            height = right + 1;
        }
        
        return height;
        
    }
}