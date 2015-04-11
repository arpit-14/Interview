//https://oj.leetcode.com/problems/valid-parentheses/
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//https://leetcode.com/submissions/detail/23594731/

package com.arpit.leetcode;

public class ValidParentheses {
    public boolean isValid(String s) {
        
        if((null == s) || (s.trim() == "") ){
            return true;
        }
        
        char open1 = '(';
        char close1 = ')';
        char open2 = '{';
        char close2 = '}';
        char open3 = '[';
        char close3 = ']';
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        int lastOpen = 0;
        
        int[] input = new int[s.length()];
        int j = -1;
        
        for(int i=0; i<s.length(); i++){
            
            char temp = s.charAt(i);
            if( temp == open1){
                input[++j] = 1;
                count1++; 
            }else if( temp == open2){
                input[++j] = 2;
                count2++; 
            }else if( temp == open3){
                input[++j] = 3;
                count3++; 
            }else if( temp == close1 ){
                if( j<0 || input[j--] != 1){
                    return false;
                }
                count1--;
            }else if(  temp == close2 ){
                if( j<0 ||  input[j--] != 2){
                    return false;
                }
                count2--;
            }else if(  temp == close3 ){
                if( j<0 || input[j--] != 3){
                    return false;
                }
                count3--;
            }
        }
        
        if((count1 == 0) && (count2 == 0) && (count3 == 0) ){
            return true;
        }
        
        return false;
        
    }
}