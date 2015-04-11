/* https://leetcode.com/problems/fraction-to-recurring-decimal/

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".

https://leetcode.com/submissions/detail/23597292/ (31/35)
 * */

package com.arpit.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        
        if(numerator%denominator == 0){
            return Integer.toString(numerator/denominator);
        }
        
        String sign = "";
        String ans = "0";
        
        if(numerator<0 && denominator<0){
            numerator = (-1)*numerator;
            denominator = (-1)*denominator;
        }
        
        if(numerator<0 ){
             numerator = (-1)*numerator;
             sign = "-";
        }
        
        if(denominator<0){
            denominator = (-1)*denominator;
            sign = "-";
        }
        
        if(numerator>denominator){
            int left = numerator/denominator;
            ans = Integer.toString(left);
            
            numerator = numerator%denominator;
        }

        String fraction = "";

        Map<Integer, Integer> rem = new HashMap<Integer, Integer>();

        int i = 0;
        while(numerator != 0){
            if(rem.containsKey(numerator)){
                
                fraction = fraction.substring(0,rem.get(numerator)) + "(" + fraction.substring(rem.get(numerator)) + ")";
                break;
            }
            
            rem.put(numerator, i);
            
            int frac = (numerator*10)/denominator;
            fraction += Integer.toString ( frac );
            
            numerator = (numerator*10)%denominator;
            
            i++;
        }        
        
        return sign + ans + "." + fraction;
    }
}