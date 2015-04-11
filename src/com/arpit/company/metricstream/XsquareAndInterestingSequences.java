/* https://www.hackerearth.com/problem/algorithm/xsquare-and-interesting-sequences/description/
 * https://www.hackerearth.com/submission/1630866/
 * 
 * Xsquare get bored playing with the arrays all the time. So,he decided to buy a new character set to play with. Xsquare's character set contains only lower case alphabets more specifically characters from 'a' to 'z' (both inclusive). Xsquare was playing with this new character set and formed some interesting continuous sequences of characters.

for ex :

ioi
cheffehc
bab
codeedoc
radar
Xsquare called this sequences interesting as these sequences remains same even after reversing. Come on , you are already familiar with these sequences. If in case you are not. Please, Have a look at this link

Fascinated with these sequences, Xsquare starts thinking how many distinct interesting sequences of length N are possible if he would have infinite number of each character in the character set.

Xsquare thinks he is very good at counting and starts counting the number of such sequences for a given length N on his fingers.

Can you help him by verifying his answer. Please calculate the number of sequences modulo (109 + 9)

Input

First line of input contains a single integer T denoting the number of test cases. First and only line of each test case contains a single integer N denoting the length of the sequences.

Output

Output consists of **T** lines, one line per test cases containing the required answer.

Constraints

1<=T<=105
1<=N<=1018
Sample Input (Plaintext Link)
2
1
2

Sample Output (Plaintext Link)
26
26
Explanation
Test 1 : 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' are the required sequences.

Test 2 : 'aa','bb','cc','dd','ee','ff','gg','hh','ii','jj','kk','ll','mm','nn','oo','pp','qq','rr','ss','tt','uu','vv','ww','xx','yy','zz' are the required sequences.
 * 
 * */

package com.arpit.company.metricstream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class XsquareAndInterestingSequences {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        for (int i = 0; i < T; i++) {
            
            long n =  Long.parseLong(br.readLine());
            
            long pow = (n+1)/2;
            
            BigInteger letters = new BigInteger("26");
            
            BigInteger exponent = new BigInteger(String.valueOf(pow));
            
            BigInteger ansBig = letters.modPow(exponent, new BigInteger("1000000009") );
            
            System.out.println(ansBig);
            
            
        }

    }
}
