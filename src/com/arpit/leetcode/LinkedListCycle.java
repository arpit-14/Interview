/* https://leetcode.com/problems/linked-list-cycle/
 * https://leetcode.com/submissions/detail/25060802/
 * 
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * 
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            
            if(slow==fast && slow!=null){
                return true;
            }
            
        }
        
        return false;
        
    }
}