package com.sayan.dp.oned;

import java.util.Arrays;

/*
70. Climbing Stairs
Easy
Topics
Companies
Hint
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45
*/
public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Recursion | time = O(2^n) | space = O(n)
	class SolutionRecursion {
	    private static int helper(int n) {
	        if (n <= 1) {
	            return 1;
	        }
	        return helper(n - 1) + helper(n - 2);
	    }

	    public int climbStairs(int n) {
	        return helper(n);
	    }
	}
	
	// Recursion with Memoization | time = O(n) | space = O(n) + O(n)
	class SolutionMemoization {
	    private static int helper(int n, int[] dp) {
	        if (n <= 1) {
	            return 1;
	        }
	        if (dp[n] != -1)
	            return dp[n];
	        return dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
	    }

	    public int climbStairs(int n) {
	        int[] dp = new int[n + 1];
	        Arrays.fill(dp, -1);
	        return helper(n, dp);
	    }
	}
	
	// Tabulation | time = O(n) | space = O(n)
	class SolutionTabulation {
	    public int climbStairs(int n) {
	        if (n <= 1) {
	            return 1;
	        }
	        int[] dp = new int[n + 1];
	        dp[0] = dp[1] = 1;
	        for (int i = 2; i <= n; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }
	        return dp[n];
	    }
	}

}
