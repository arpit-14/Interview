/* https://www.hackerearth.com/problem/algorithm/criminals-little-deepu-and-little-kuldeep/
 * https://www.hackerearth.com/submission/1708090/
 * 
 * Little Deepu and Little Kuldeep are world renowned criminals. But, they are not bad people at heart. (Oh, they are...) Anyway, their occupation is to smuggle drugs from one place to another. And both of them are partners in this occupation of theirs. But, now Little Deepu is an amateur drug seller, while Little Kuldeep is a professional at that.

So, every drug box Little Deepu packs has a value X, that is to say, if there are 5 packets, every packet has some high quantity of a given number. A packet can fit inside another packet easily, iff Xi < Xj - and one packet can contain only ONE packet inside it.

So, when Little Kuldeep receives all the packets from Deepu, he decides to reduce the number of total packets for easier smuggling; can you help Little Kuldeep extend his business, by letting him know the minimum number of packets required for him to successfully smuggle the drugs?

Input:
The first line contains the number of test cases T. Every test case contains a number N, denoting the number of total drug packets. This is followed by N lines, containing the highness value of each packet.

Output:
You've to output the minimum number of packets, optimally putting one inside each other.

Constraints:
1 <= T <= 1000
1 <= N <= 100000
1 <= X <= 1000000000

Sample Input (Plaintext Link)
3
3
1
2
3
4
2
2
2
2
3
11
111
1111
Sample Output (Plaintext Link)
1
4
1
Explanation
Test Case # 1: 

There are three boxes of size 1 , 2 and 3 
box of size 1 can fit inside box of size 2 and now box of size 2 which contains box of size 1 can fit inside box of size 3 . So finally there will be only one box. 

Test Case # 2: 

There are four boxes of same size 2 so we can't put boxes inside of any other box of same size. So the answer will be 4.

Test Case # 3: 

There are three boxes of size 11,111,1111 . Box of size 11 can fit inside box of size 111 and box of size 111 which contains box of size 11 can fit inside box 1111 .At final there will be only one box so answer is 1.
 * */

package com.arpit.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class CriminalsLittleDeepuandLittleKuldeep {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            
            int n = Integer.parseInt(br.readLine());
            int[] x = new int[n];
            for(int j=0; j<n; j++){
            	x[j] = Integer.parseInt(br.readLine());
            }
            
            Arrays.sort(x);
            
            List<Integer> numbers = new ArrayList<Integer>();
            for(int j=0; j<n;){
            	
            	int count = 0;
            	int temp = x[j];
            	while(j<n && temp==x[j]){
            		count++;
            		j++;
            	}
            	numbers.add(count);
            }
            
            int size = numbers.size();
            int count = 0;
            for(int j=0; j<size; j++){
            	count = Math.max(count, numbers.get(j) );
            }
            
            System.out.println(count);
        }

    }
}

