/* https://leetcode.com/problems/dungeon-game/
 * https://leetcode.com/submissions/detail/24342485/
 * 
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2(K)	-3	 3
-5	   -10	 1
10	    30	 -5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * 
 * */

package com.arpit.leetcode;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        
        int m = dungeon.length;
        int n= m!=0 ? dungeon[0].length : 0;

        int[][] health = new int[m][n]; // min health required to enter that block
        
        int val = dungeon[m-1][n-1];
        health[m-1][n-1] = val>=0 ? 1 : 1-val;
        
        // populate last row
        for(int i=n-2; i>=0; i--){
            val = health[m-1][i+1] - dungeon[m-1][i];
            health[m-1][i] = val<=0 ? 1 : val;
        }
        
        // populate last column
        for(int i=m-2; i>=0; i--){
            val = health[i+1][n-1] - dungeon[i][n-1];
            health[i][n-1] = val<=0 ? 1 : val;
        }
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                
                int minHealth = Math.min(health[i][j+1], health[i+1][j]);
                
                val = minHealth - dungeon[i][j];
                health[i][j] = val<=0 ? 1 : val;

            }
        }

        return health[0][0];    
    }
}