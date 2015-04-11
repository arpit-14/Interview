/* https://www.hackerearth.com/problem/algorithm/divide-array-2/
 * https://www.hackerearth.com/submission/1562918/
 * 
 *  Given an array A of size N. Given Q operations, each operation contains an integer D. In each operation you have to divide all the elements of the array by D.

For example, for each operation with a given D, the new array A would be:

A[0] / D, A[1] / D, A[2] / D, ..... , A[N-1] / D
Finally, after processing all the operations you have to print the final array after Q operations.
Note : The result of the each division will be an integer, for example 5 / 2 = 2

Input :
First line of input contains a single integer N denoting number of elements in the array A. Next line of input contains N space separated integers denoting the elements of array A. Next line contains Q denoting number of operations. Next Q lines contains a single integer D by which divide the elements of the array.

Output :
Print single line containing N space separated integers after processing Q operations.

Constraints: 
1<=N<=100000
1<=Ai<=1000000 
1<=Q<=100000 
1<=D<=1000

Sample Input (Plaintext Link)
5
50 20 18 27 19
3
2
3
2


Sample Output (Plaintext Link)
4 1 1 2 1
Explanation
In operation 1 after dividing the whole array by D=2, the resultant array will be : [25, 10, 9, 13, 9]
In operation 2 after dividing the array from operation 1 by 3, the resultant array will be : [8, 3, 3, 4, 3]
In operation 3 after dividing the array from operation 2 by 2, the resultant array will be : [4, 1, 1, 2, 1]
So, the resultant array will be [4, 1, 1, 2, 1]
 * 
 * */

package com.arpit.company.honeywell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DivideArray {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        String[] input = br.readLine().split(" ");
        
        line = br.readLine();
        int q = Integer.parseInt(line);

		BigInteger operation = new BigInteger("1");
		for (int i = 0; i < q; i++) {
        	operation = operation.multiply(new BigInteger(br.readLine()));
        }

		for (int i = 0; i < N; i++) {
        	
        	BigInteger temp = new BigInteger(input[i]); 
        	
        	System.out.print( temp.divide(operation) + " ");
        }

    }
}
