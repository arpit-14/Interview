/* https://leetcode.com/problems/reorder-list/
 * https://leetcode.com/submissions/detail/25073042/
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        
        if(head==null || head.next==null || head.next.next==null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head.next.next;
        
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        
        ListNode laterHalf = slow.next;
        slow.next = null;
        
        ListNode h1 = head;
        ListNode t1 = h1.next;
        
        ListNode h2 = reverse(laterHalf);
        ListNode t2 = h2.next;
        
        while(h2!=null){
            h1.next = h2;
            h2.next = t1;
            
            h1 = t1;
            h2 = t2;
            
            t1 = t1==null ? null : t1.next;
            t2 = t2==null ? null : t2.next;

        }
        
        return;
        
        
    }
    
    public ListNode reverse(ListNode head) {
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head==null ? null : head.next;
        
        while(cur!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            if(next!=null){
                next = next.next;
            }
            
        }
        
        return pre;

    }
    
    
}