package com.sayan.dp.subsequences;

import java.util.Arrays;

/**
 * link - https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
 * 
 * 0 1 Knapsack Easy 40/40 Average time to solve is 15m Contributed by 253
 * upvotes Asked in companies Problem statement A thief is robbing a store and
 * can carry a maximal weight of W into his knapsack. There are N items and the
 * ith item weighs wi and is of value vi. Considering the constraints of the
 * maximum weight that a knapsack can carry, you have to find and return the
 * maximum value that a thief can generate by stealing items.
 * 
 * Detailed explanation ( Input/output format, Notes, Images ) Constraints: 1 <=
 * T <= 10 1 <= N <= 10^2 1<= wi <= 50 1 <= vi <= 10^2 1 <= W <= 10^3
 * 
 * Time Limit: 1 second Sample Input: 1 4 1 2 4 5 5 4 8 6 5 Sample Output: 13
 */
public class ZeroOneKnapsack {

	public static void main(String[] args) {

	}

	// Recursion | time = O(n * maxWeight) exponential | space = O(n) + O(n+k)
	class SolutionMemoization {

		private static int recursion(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {
			if (maxWeight == 0) {
				return 0;
			}
			if (n == 0) {
				if (weight[0] <= maxWeight) {
					return value[0];
				}
				return 0;
			}
			if (dp[n][maxWeight] != -1)
				return dp[n][maxWeight];

			int notPick = recursion(weight, value, n - 1, maxWeight, dp);
			int pick = 0;

			if (weight[n] <= maxWeight) {
				pick = value[n] + recursion(weight, value, n - 1, maxWeight - weight[n], dp);
			}
			return dp[n][maxWeight] = Math.max(pick, notPick);
		}

		static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

			int[][] dp = new int[n][maxWeight + 1];
			for (int[] row : dp) {
				Arrays.fill(row, -1);
			}

			return recursion(weight, value, n - 1, maxWeight, dp);

		}
	}

}
