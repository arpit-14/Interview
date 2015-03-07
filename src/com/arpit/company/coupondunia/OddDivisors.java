/*
Little Dipu is a small kid and like all the other kids, he likes to play, but he plays with numbers (He is extraordinary you know). Now-a-days Dipu has some extra interest in odd numbers. So, he says that a number N is interesting if it has odd number of divisors. Now Dipu turns to you and asks you to tell him how many interesting numbers are there between two given numbers, L and R (both inclusive). 

Input

First line of input contains the number of test cases T. Each of the next T lines contains two space separated integers L and R. 
Output

For each test case, output an integer, denoting the count of interesting numbers between L and R (both inclusive). 
Constraints

1 <= T <= 100000 
1 <= L <= R <= 1018 
Sample Input (Plaintext Link)
2
1 3
6 10
Sample Output (Plaintext Link)
1
1
Explanation
In 1st test case, 1 has 1 divisor, 2 has 2 divisors and 3 also has 2 divisors. So only 1 has odd number of divisors. Hence count of interesting numbers is 1.

In 2nd test case, 9 is the only number to have odd number of divisors. So answer is again 1.
*/

package com.arpit.company.coupondunia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.lang.Math;

class OddDivisors {
    public static void main(String args[] ) throws Exception {

// We just need to find total perfect squares in the range.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            
            String[] test = br.readLine().split(" ");
            
            long L = Long.parseLong(test[0]);
            long R = Long.parseLong(test[1]);
            
            double rootL = Math.sqrt(L);
            double rootR = Math.sqrt(R);
            
            int flag = 0;
            
            if(rootL == Math.floor(rootL)){
            	flag = 1;
            }
            
            int ans = (int)(Math.floor(rootR) - Math.floor(rootL) + flag);
            
            System.out.println(ans);
        }

        
    }
}