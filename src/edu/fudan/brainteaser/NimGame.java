package edu.fudan.brainteaser;

import java.util.Random;

/**
 * @author abner
 * 
 * You are playing the following Nim Game with your friend: 
 * There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
 * The one who removes the last stone will be the winner. 
 * You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. 
 * Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
 * 
 * Hint:If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 *
 * References and extensions:
 * 1.http://www.guokr.com/blog/777525/
 * 2.http://www.cnblogs.com/yintingru/archive/2012/08/27/2658483.html
 * 3.http://www.cnblogs.com/exponent/articles/2141477.html
 */

public class NimGame {
    public static boolean canWinNim(int n) {
        return n%4!=0;
    }
    
    /**
     * Test Method
     * @param args
     */
    public static void main(String args[]){
    	for(int i=1;i<=10;i++){
    		int stoneNum=new Random().nextInt(i*i)+1;
    		System.out.println("stone num is "+stoneNum+", \t and result is "+NimGame.canWinNim(stoneNum));
    	}
    }
}
