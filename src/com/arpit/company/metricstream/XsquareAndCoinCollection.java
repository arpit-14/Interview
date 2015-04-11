/* https://www.hackerearth.com/problem/algorithm/xsquare-and-coin-collection-2/description/
 * https://www.hackerearth.com/submission/1630952/
 * 
 * Xsquare loves to play with the coins very much. Today , he has N stacks of coins . Each stack of coins has some non zero height Hi equal to the number of coins on that stack ( considering all the coins are identical and each coin has a height of 1 unit ) .

In one move, Xsquare can select any number of consecutive stacks of coins such that the height of each selected stack of coins Hi ≤ K . Once such a sequence of stacks is chosen , Xsquare can collect any number of coins from the chosen sequence of stacks .

Xsquare wonders what is the maximum number of coins that he can collect this way ?

INPUT

First line of input contains a single integer T denoting the number of test cases . First line of each test case contains two space separated integers N and K where N being the number of stacks of coins. Second line of each test case contains N space separated integers denoting the number of coins Hi on each stack .

OUTPUT

For each test case , Print the maximum number of coins Xsquare can collect following the above gaming strategy.

CONSTRAINTS

1 ≤ T ≤ 105

1 ≤ N ≤ 105

1 ≤ K ≤ 109

1 ≤ Hi ≤ 109

Note :

sum of N over all the test case will not exceed 106.

Sample Input (Plaintext Link)
2
8 1
3 2 2 3 1 1 1 3
8 2
3 2 2 3 1 1 1 3
Sample Output (Plaintext Link)
3
4

Explanation
Test 1 :
N = 8 , K = 1
3 2 2 3 1 1 1 3
We can collect coins from stacks numbered 5 , 6 and 7 .

Test 2 :
N = 8 , K = 2
3 2 2 3 1 1 1 3
We can collect coins from stacks numbered 2 and 3 .
 * 
 * */
package com.arpit.company.metricstream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XsquareAndCoinCollection {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            
            temp = br.readLine().split(" ");
            int[] height = new int[n];
            
            for(int j=0; j<n; j++){
            	height[j] = Integer.parseInt(temp[j]);
            }
            
            long maxSum = 0;
            
            long sum=0;
            
            for(int j=0; j<n; j++){
            
            	if(height[j] <= k){
            		sum += height[j];
            	}else{
            		if(sum>maxSum){
            			maxSum = sum;
            		}
            		sum = 0;
            		
            	}
            
            }
            
            if(sum>maxSum){
            	maxSum = sum;
            }
            
            System.out.println(maxSum);
        }

    }
}
