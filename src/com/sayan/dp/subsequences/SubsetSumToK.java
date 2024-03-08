package com.sayan.dp.subsequences;

/*
 * link https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954
 * 
Subset Sum Equal To K
Moderate
80/80
Average time to solve is 30m
438 upvotes
Asked in companies
Problem statement
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.

Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.

For Example :
If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4. These are {1,3} and {4}. Hence, return true.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
0 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1:
2
4 5
4 3 2 1
5 4
2 5 1 6 7
Sample Output 1:
true
false
Explanation For Sample Input 1:
In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.
Sample Input 2:
2
4 4
6 1 2 1
5 6
1 7 2 9 10
Sample Output 2:
true
false
Explanation For Sample Input 2:
In example 1, ‘ARR’ is {6,1,2,1} and ‘K’ = 4. There exist 1 subset with sum = 4. That is {1,2,1}. Hence, return true.
In example 2, ‘ARR’ is {1,7,2,9,10} and ‘K’ = 6. There are no subsets with sum = 6. Hence, return false.
		*/
public class SubsetSumToK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursion | time = O(n*k) | space = O(n) + O(n+k)
	class SolutionMemoization {

		private static boolean recursionMemoization(int ind, int k, int arr[], boolean dp[][]) {

			if (k == 0)
				return true;
			if (ind == 0) {
				return k == arr[ind];
			}
			if (dp[ind][k] != false)
				return dp[ind][k];
			boolean left = recursionMemoization(ind - 1, k, arr, dp);
			boolean right = false;
			if (arr[ind] <= k) {
				right = recursionMemoization(ind - 1, k - arr[ind], arr, dp);
			}
			return dp[ind][k] = left | right;
		}

		public static boolean subsetSumToK(int n, int k, int arr[]) {
			// Write your code here.
			boolean[][] dp = new boolean[n][k + 1];
			return recursionMemoization(n - 1, k, arr, dp);
		}
	}

	// Recursion | time = O(n*k) | space = O(n+k)
	public class SolutionTabulation {

		public static boolean subsetSumToK(int n, int k, int arr[]) {
			boolean[][] dp = new boolean[n][k + 1];

			for (int ind = 0; ind < n; ind++) {
				dp[ind][0] = true;
			}
			if (arr[0] <= k)
				dp[0][arr[0]] = true;

			for (int ind = 1; ind < n; ind++) {
				for (int tar = 1; tar <= k; tar++) {

					boolean left = dp[ind - 1][tar];
					boolean right = false;
					if (arr[ind] <= tar) {
						right = dp[ind - 1][tar - arr[ind]];
					}
					dp[ind][tar] = left | right;
				}
			}
			return dp[n - 1][k];
		}
	}

}
