/* https://leetcode.com/problems/add-two-numbers/
 * https://leetcode.com/submissions/detail/25430460/
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * 
 * */

package com.arpit.leetcode;

import com.arpit.leetcode.util.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        return addTwoNumbers(l1, l2, 0);

    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        
        if(l1==null && l2==null && carry==0){
            return null;
        }
        
        int sum = 0;
        
        if(l1 != null){
            sum += l1.val;
            l1 = l1.next;
        }
        
        if(l2 != null){
           sum += l2.val;
           l2 = l2.next;
        }

        sum += carry;
        
        int val = sum%10;
        carry = sum/10;
        
        ListNode node = new ListNode(val);
        
        node.next = addTwoNumbers(l1, l2, carry);
        
        return node;
        
    }
    
}