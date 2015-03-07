// http://www.hackerearth.com/problem/algorithm/chess-tournament-4/

package com.arpit.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;
 
class ChessTournament {
    public static void main(String args[] ) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        
        int total = (int) Math.pow(2, (double)N);
        
        int[][] players = new int[total + 1][total + 1];
        
        int count = 2;
        for (int i = 2; i<=total; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=1; j<i; j++){
                players[i][j] = Integer.parseInt(input[j-1]);    
            }
        }
 
        LinkedList<Integer> activePlayers = new LinkedList<Integer>();
        for(int i=1; i<=total; i++){
            activePlayers.add(new Integer(i));
        }
 
        count = total;
 
        while(count>1){
            
            for(int i=0; i<count-1; i= i+2){
                if(players[activePlayers.get(i+1)][activePlayers.get(i)] == 1){
                    activePlayers.set(i, -1);
                }else{
                    activePlayers.set(i+1, -1);
                }
            }
            
            while(activePlayers.removeFirstOccurrence(-1)){
                
            }
            count = activePlayers.size();
        }
        
        System.out.println(activePlayers.getFirst());
    }
}

