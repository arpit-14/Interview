/* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * https://leetcode.com/submissions/detail/25344732/
 * 
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {
	
	public void connect(TreeLinkNode root) {
        
        while(root!= null){
            TreeLinkNode temp = root;
            while(temp!=null){
                if(temp.left==null){
                    return;
                }
                temp.left.next = temp.right;
                temp.right.next = temp.next==null? null : temp.next.left;
                
                temp = temp.next;
            }
            
            root = root.left;
        }
        
        
    }
	
}
