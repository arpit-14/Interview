/*
Description:
Name string is a string consisting of letters "R","K" and "V". Today Oz wants to design a name string in a beautiful manner. Actually Oz cannot insert these three letters arbitrary anywhere ,he has to follow some rules to make the name string look beautiful. First thing is that the name string should consist of at most two different letters. Secondly adjacent letters in name string must be different.

After this procedure Oz wants name string to be as long as possible. Given the number of "R","K" and "V" letters that you have initially ,help Oz to find the maximum length of name string that Oz can make.

Input :
The first line contains the number of test cases T . Each test case consists of three space separated integers - A,B and C representing number of "R" letters, number of "K" letters and number of "V" letters respectively.

Output :
For each test case T, output maximum length of name string that Oz can make.

Constraints :
1 <= T <=100
0 <= A,B,C <=106

Sample Input (Plaintext Link)
2
1 2 5
0 0 2
Sample Output (Plaintext Link)
5
1
Explanation
For first sample :
The longest name string possible is : VKVKV using 3 "V" letters and 2 "K" letters and its length is 5.
*/

package com.arpit.company.coupondunia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class NameString {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            
            String[] test = br.readLine().split(" ");
            
            int R = Integer.parseInt(test[0]);
            int K = Integer.parseInt(test[1]);
            int V = Integer.parseInt(test[2]);
            
            // find 2 max as string can contain only 2 letters
            int max1 = 0;
            int max2 = 0;
            
            if(R>=K && R>=V){
            	max1 = R;
            	if(K>=V){
            		max2 = K;
            	}else{
            		max2 = V;
            	} 
            }else if(K>=R && K>=V){
            	max1 = K;
            	if(R>=V){
            		max2 = R;
            	}else{
            		max2 = V;
            	} 
            }else{
            	max1 = V;
            	if(K>=R){
            		max2 = K;
            	}else{
            		max2 = R;
            	} 
            }
            
            int maxLength = 0;
            
            if(max1 == 0){
            	maxLength = 0;
            }else if(max2 == 0){
            	maxLength = 1;
            }else if(max1 == max2){
            	maxLength = max1*2;
            }else{
            	maxLength = max2*2 + 1;
            }
            
            System.out.println(maxLength);
        }

        //System.out.println("Hello World!");
    }
}