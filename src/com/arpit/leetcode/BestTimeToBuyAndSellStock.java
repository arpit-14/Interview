/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://leetcode.com/submissions/detail/25156273/
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * */

package com.arpit.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        if(n<=1){
            return 0;
        }
        
        int[] min = new int[n];
        int[] max = new int[n];
        
        max[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--){
            max[i] = Math.max(prices[i], max[i+1]);
        }
        
        min[0] = prices[0];
        for(int i=1; i<n; i++){
            min[i] = Math.min(prices[i], min[i-1]);
        }
        
        int profit = 0;
        for(int i=0; i<n; i++){
            profit = Math.max(profit, max[i]-min[i]);
        }
        
        return profit;
        
    }
}