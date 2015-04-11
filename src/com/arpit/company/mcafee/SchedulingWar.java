/* https://www.hackerearth.com/mcafee-part-of-intel-security-developer/problems/947c4af664018c558c88253a880a2de3/
 * https://www.hackerearth.com/submission/1694127/
 * 
 * Prateek and Chintu are working on different projects both with equal priority. They both need to run some batches of processes. A batch has processes which need some systems to run them irrespective of the number of process running on each dependent system. If a batch runs then the dependent systems are occupied by its processes. No system can run processes from different projects and thus a system can process only chintu's processes or prateek's processes. Their manager being a stylo creep has allowed prateek to run his batches. Chintu felt offended and complained the CTO directly due to which the manager came up with a condition that if chintu can increase the number of processes running in total by replacing some or all of prateeks processes then only he can run his batches. Chintu wants to maximize the total processes running in order to show the manager his skills. Help him complete his task.

Note:

A system can run any number of process from multiple batches at the same time but only of Chintu or of Prateek.

Prateek's processes are running on some or all systems. Now, chintu has to run his batches of processes inorder to increase the number of running processes across all systems. A batch of chintu either runs all its processes or doesn't run any of them.

If Chintu has replaced a system with his own processes then another batch of him can run its processes on that system.

A batch needs 's' systems and runs 'p' processes overall, in any manner.

Input Format:

The first line contains the total number of systems - 'n', the next line contains 'n' space separated integers - 'Si', denoting the number of prateek's processes running on ith system. Next line contains an integer - 'b' denoting the number of batches Chintu has. This is followed by each line containing space separated integers where the first integer is - 's', number of systems the ith batch needs followed by 's' integers denoting the system numbers and then the number of processes - 'p', the batch needs to run.

Ouput Format:

The increase in number of processes Chintu can put in by replacing some of all of prateeks processes from some or all systems.

Constraints:

1<=n<=100

0<=Si<70

0<=b<100

1<=p<=50

Example 1:

Input:

4

1 7 8 9

2

3 1 2 3 15

2 3 4 11

Output:

1

Explanation Example 1: Chintu can run his batch1's processes by replacing prateeks processes from system 1, 2 and 3. thus decreasing the number of processes by 1. But he can also run his batch2's processes which needs system 3 and 4 and thus removing prateek's processes from system 4 also and increasing the number of running processes by 1. In total 26 processes will be running as compared to 25 in the beginning.

Sample Input (Plaintext Link)
4
3 1 5 2
3
2 1 2 1
2 2 3 7
1 4 3
Sample Output (Plaintext Link)
2
Explanation
Chintu can run batch2's processes by replacing prateek's processes from system 2 and 3 along with batch3's processes by replacing prateek's processes from system 4 and thus increasing the total number of running processes by 2.
 * 
 * */

package com.arpit.company.mcafee;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SchedulingWar {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // no. of systems
        int[] processes = new int[n];
        
        String[] procCount = br.readLine().split(" ");
        int totalProcessprateek = 0;
        for (int i = 0; i < n; i++) {
            processes[i] = Integer.parseInt(procCount[i]);
            totalProcessprateek += processes[i];
        }

		int b = Integer.parseInt(br.readLine()); // no. of batches chintu has
		int[] increase = new int[b];
		
		int totalProcessChintu = 0; // overall total of C's process
		int tempInc = 0;
		for(int i=0; i<b; i++){
			String[] input = br.readLine().split(" ");
			int size = input.length;
			int sysCount = Integer.parseInt(input[0]);      // Total systems required
			int totalInbatchChintu = Integer.parseInt(input[size-1]); // Total C's process in batch
			
			totalProcessChintu += Integer.parseInt(input[size-1]);  
			
			int totalInBatchPrateek = 0;
			for(int j=1; j<=size-2; j++){
				int temp = Integer.parseInt(input[j]);
				totalInBatchPrateek += processes[temp-1];
			}
			
			increase[i] = totalInbatchChintu - totalInBatchPrateek;
			//System.out.println(increase[i]);
			tempInc += Math.max(0, increase[i]);
		}
		
		int allInc = totalProcessChintu - totalProcessprateek;
		
		//System.out.println(allInc + " " + tempInc);
		
        System.out.println(Math.max(allInc, tempInc));
    }
}

