package com.sayan.dp.subsequences;

import java.util.Arrays;

/**
 * link - https://leetcode.com/problems/coin-change/description/
 * 
 * 322. Coin Change
Medium
Topics
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Recursion | time = O(2^n) exponential | space = O(n)
	class SolutionRecursion {

	    private static int recursion(int[] coins, int amount, int ind) {
	        if(ind == 0) {
	            if(amount % coins[0] == 0)
	                return amount / coins[0];
	            return (int) 1e9;
	        }
	        int notPick = recursion(coins, amount, ind - 1);
	        int pick = Integer.MAX_VALUE;
	        if(coins[ind] <= amount) {
	            pick = 1 + recursion(coins, amount - coins[ind], ind);
	        }
	        return Math.min(notPick, pick);
	    }
	    public int coinChange(int[] coins, int amount) {
	        if(amount == 0)
	            return 0;
	        int n = coins.length;
	        int c = recursion(coins, amount, n - 1);
	        return  c >= (int) 1e9 ? -1 : c;
	        
	    }
	}
	
	// time = O(amount * n) | space O(n) + O(amount * n)
	class SolutionMemoization {

	    private static int recursion(int[] coins, int amount, int ind, int[][] dp) {
	        if(ind == 0) {
	            if(amount % coins[0] == 0)
	                return amount / coins[0];
	            return (int) 1e9;
	        }
	        if(dp[ind][amount] != -1)
	            return dp[ind][amount];
	        int notPick = recursion(coins, amount, ind - 1, dp);
	        int pick = Integer.MAX_VALUE;
	        if(coins[ind] <= amount) {
	            pick = 1 + recursion(coins, amount - coins[ind], ind, dp);
	        }
	        return dp[ind][amount] = Math.min(notPick, pick);
	    }
	    public int coinChange(int[] coins, int amount) {
	        if(amount == 0)
	            return 0;
	        int n = coins.length;
	        int[][] dp = new int[n][amount + 1];
	        for(int[]r : dp) {
	            Arrays.fill(r, -1);
	        }
	        int c = recursion(coins, amount, n - 1, dp);
	        return  c >= (int) 1e9 ? -1 : c;
	        
	    }
	}

}
