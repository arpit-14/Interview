/* https://leetcode.com/problems/word-break/
 * https://leetcode.com/submissions/detail/25283637/  [Time Limit Exceeded] 
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

 * */


package com.arpit.leetcode;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
     
        int len = s.length();
        
        if(len == 0){
            return true;
        }
        
        for(int i=0; i<len; i++){
            if( dict.contains(s.substring(0,i+1)) ){
                if(i == len-1){
                    return true;
                }else if(wordBreak(s.substring(i+1), dict)){
                    return true;
                }
            }
        }
        
        return false;
        
           
    }
}

