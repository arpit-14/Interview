/* https://leetcode.com/problems/permutations/
 * https://leetcode.com/submissions/detail/25154158/
 * 
 * Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * */

package com.arpit.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] num) {
        
        List<Integer> temp = new ArrayList<Integer>();
        for (int index = 0; index < num.length; index++){
            temp.add(num[index]);
        }
        return permute(temp);
    }
    
    public List<List<Integer>> permute(List<Integer> num) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = num.size();
        
        if(n<=1){
            ans.add(num);
            return ans;
        }
        
        for(int i=0; i<n; i++){
            
            int temp = num.remove(0);
            num.add(temp);
            
            List<List<Integer>> subAns = permute(num.subList(0,n-1));
            
            for(List<Integer> list : subAns ){
            	Integer[] a = new Integer[list.size()];
            	List<Integer> test = new LinkedList<Integer>(Arrays.asList(list.toArray(a)));
            	test.add(Integer.valueOf(temp));
            	ans.add(test);
            }
            
        }
        
        return ans;
        
    }
}