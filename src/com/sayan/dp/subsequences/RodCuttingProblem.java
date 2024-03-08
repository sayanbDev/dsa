package com.sayan.dp.subsequences;

/*
 * link - https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284
 * 
 * Rod cutting problem
Moderate
0/80
Average time to solve is 40m
Contributed by
270 upvotes
Asked in companies
Problem statement
Given a rod of length ‘N’ units. The rod can be cut into different sizes and each size has a cost associated with it. Determine the maximum cost obtained by cutting the rod and selling its pieces.

Note:
1. The sizes will range from 1 to ‘N’ and will be integers.

2. The sum of the pieces cut should be equal to ‘N’.

3. Consider 1-based indexing.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= A[i] <= 100

Where ‘T’ is the total number of test cases, ‘N’ denotes the length of the rod, and A[i] is the cost of sub-length.

Time limit: 1 sec.
Sample Input 1:
2
5
2 5 7 8 10
8
3 5 8 9 10 17 17 20
Sample Output 1:
12
24
Explanation of sample input 1:
Test case 1:

All possible partitions are:
1,1,1,1,1           max_cost=(2+2+2+2+2)=10
1,1,1,2             max_cost=(2+2+2+5)=11
1,1,3               max_cost=(2+2+7)=11
1,4                 max_cost=(2+8)=10
5                   max_cost=(10)=10
2,3                 max_cost=(5+7)=12
1,2,2               max _cost=(1+5+5)=12    

Clearly, if we cut the rod into lengths 1,2,2, or 2,3, we get the maximum cost which is 12.


Test case 2:

Possible partitions are:
1,1,1,1,1,1,1,1         max_cost=(3+3+3+3+3+3+3+3)=24
1,1,1,1,1,1,2           max_cost=(3+3+3+3+3+3+5)=23
1,1,1,1,2,2             max_cost=(3+3+3+3+5+5)=22
and so on….

If we cut the rod into 8 pieces of length 1, for each piece 3 adds up to the cost. Hence for 8 pieces, we get 8*3 = 24.
Sample Input 2:
1
6
3 5 6 7 10 12
Sample Output 2:
18
 */
public class RodCuttingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time O(2^n) | space - o(n)
	public class Solution {

		private static int recursion(int price[], int ind, int tar) {

			if (ind == 0) {
				return tar * price[0];
			}
			int notCut = recursion(price, ind - 1, tar);
			int cut = -(int) 1e9;
			if (ind + 1 <= tar) {
				cut = price[ind] + recursion(price, ind, tar - ind - 1);
			}
			return Math.max(notCut, cut);

		}

		public static int cutRod(int price[], int n) {
			// Write your code here.

			return recursion(price, n - 1, n);
		}
	}

//time - o(tar * n) | space - O(n) + O(tar * n)
	public class SolutionMemoization {

		private static int recursion(int price[], int ind, int tar, int[][] dp) {

			if (ind == 0) {
				return tar * price[0];
			}
			if (dp[ind][tar] != -1)
				return dp[ind][tar];
			int notCut = recursion(price, ind - 1, tar, dp);
			int cut = -(int) 1e9;
			if (ind + 1 <= tar) {
				cut = price[ind] + recursion(price, ind, tar - ind - 1, dp);
			}
			return dp[ind][tar] = Math.max(notCut, cut);

		}

		public static int cutRod(int price[], int n) {
			// Write your code here.

			int[][] dp = new int[n][n + 1];
			for (int[] r : dp) {
				Arrays.fill(r, -1);
			}
			return recursion(price, n - 1, n, dp);
		}
	}

}
