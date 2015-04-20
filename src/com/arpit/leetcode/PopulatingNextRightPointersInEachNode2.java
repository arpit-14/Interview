/* https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * https://leetcode.com/submissions/detail/25346159/
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode2 {

	public void connect(TreeLinkNode root) {
        
        while(root!= null){
            TreeLinkNode temp = root;
            TreeLinkNode pre = null;
            while(temp!=null){
                
                
                if(temp.left!=null){
                    if(pre!=null){
                        pre.next = temp.left;
                    }
                    
                    if(temp.right!=null){
                        temp.left.next = temp.right;
                        pre = temp.right;
                    }else{
                        pre = temp.left;
                    }
                }else{
                    if(temp.right!=null){
                        if(pre!=null){
                            pre.next = temp.right;
                        }
                        pre = temp.right;
                    }
                }
                
                
                temp = temp.next;
            }
            
            while(root!=null){
                if(root.left!= null){
                    root = root.left;
                    break;
                }else if(root.right!= null){
                    root = root.right;
                    break;
                }
                root = root.next;
            }
            
        }
        
        
    }
}
