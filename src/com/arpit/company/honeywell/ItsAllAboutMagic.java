/* https://www.hackerearth.com/problem/algorithm/its-all-about-magic/description/
 * https://www.hackerearth.com/submission/1562732/
 * 
 * Recently Oz has found a magical string consisting of single digit "1". After experimenting on the string, Oz found a weird magical property of the string that is whenever he touches the string then each digit "1" of string changed to digit "0" and each digit "0" of string changed to "01". Oz found this property interesting and immediately asked a question to RK : "How many 1's and 0's will be in the magical string if he touches the string M times ?"

Input :

The first line contains the number of test cases T . Each test case consists of a positive integer - M .

Output :

For each test case output two space-separated integers, number of 1's and number of 0's in the magical string if Oz touches the string M times.

Constraints :

1<= T <=20

1<= M <=90

Sample Input (Plaintext Link)
2
1
2
Sample Output (Plaintext Link)
0 1
1 1
 * 
 * 
 * */
package com.arpit.company.honeywell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ItsAllAboutMagic {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        long[] fib = new long[100];
        
        fib[0] = 0;
        fib[1] = 1;
        
        for(int i=2; i<100; i++){
        	fib[i] = fib[i-1]+fib[i-2];
        }
        
        for (int i = 0; i < N; i++) {
        	
        	int m = Integer.parseInt( br.readLine());
        	
        	System.out.println(fib[m-1] + " " + fib[m]);
        }

        
    }
}
