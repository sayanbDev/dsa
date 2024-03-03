package com.sayan.dp.oned;

/*
 * link https://www.codingninjas.com/studio/problems/frog-jump_3621012
 * 
Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[i] <= 1000 .

Time limit: 1 sec
Sample Input 1:
2
4
10 20 30 10
3
10 50 10
Sample Output 1:
20
0
Explanation of sample input 1:
For the first test case,
The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
So, the total energy lost is 20 which is the minimum. 
Hence, the answer is 20.

For the second test case:
The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
So, the total energy lost is 0 which is the minimum. 
Hence, the answer is 0.
Sample Input 2:
2
8
7 4 4 2 6 6 3 4 
6
4 8 3 10 4 4 
Sample Output 2:
7
2
*/
import java.util.Arrays;

public class FrogJump {

	public static void main(String[] args) {

	}

	// Recursion | time = O(2^n) | space = O(n)
	class SolutionRecursion {
		public static int frogJump(int n, int heights[]) {

			// Write your code here..
			return recursion(n - 1, heights);
		}

		private static int recursion(int n, int[] heights) {
			if (n == 0) {
				return 0;
			}
			int singleStep = Math.abs(heights[n] - heights[n - 1]) + recursion(n - 1, heights);
			int doubleStep = Integer.MAX_VALUE;
			if (n - 2 >= 0) {
				doubleStep = Math.abs(heights[n] - heights[n - 2]) + recursion(n - 2, heights);
			}

			return Math.min(singleStep, doubleStep);
		}

	}

	// Recursion with Memoization | time = O(n) | space = O(n) + O(n)
	class SolutionMemoization {
		public static int frogJump(int n, int heights[]) {

			// Write your code here..
			int[] dp = new int[n];
			Arrays.fill(dp, -1);
			return recursionWithMemo(n - 1, heights, dp);
		}

		private static int recursionWithMemo(int n, int[] heights, int[] dp) {
			if (n == 0) {
				return 0;
			}
			if (dp[n] != -1)
				return dp[n];
			int singleStep = Math.abs(heights[n] - heights[n - 1]) + recursionWithMemo(n - 1, heights, dp);
			int doubleStep = Integer.MAX_VALUE;
			if (n - 2 >= 0) {
				doubleStep = Math.abs(heights[n] - heights[n - 2]) + recursionWithMemo(n - 2, heights, dp);
			}

			return dp[n] = Math.min(singleStep, doubleStep);
		}

	}

	// Tabulation | time = O(n) | space = O(n)
	class SolutionTabulation {
		public static int frogJump(int n, int heights[]) {

			int[] dp = new int[n];
			dp[0] = 0;
			for (int i = 1; i < n; i++) {
				int singleStep = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
				int doubleStep = Integer.MAX_VALUE;
				if (i - 2 >= 0) {
					doubleStep = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
				}
				dp[i] = Math.min(singleStep, doubleStep);
			}
			return dp[n - 1];
		}

	}

	// Tabulation with Space Optimization | time = O(n) | space = O(1)
	class SolutionSpaceOptimization {
		public static int frogJump(int n, int heights[]) {

			int prev = 0;
			int prev2 = 0;

			for (int i = 1; i < n; i++) {
				int singleStep = Math.abs(heights[i] - heights[i - 1]) + prev;
				int doubleStep = Integer.MAX_VALUE;
				if (i - 2 >= 0) {
					doubleStep = Math.abs(heights[i] - heights[i - 2]) + prev2;
				}
				int curr = Math.min(singleStep, doubleStep);
				prev2 = prev;
				prev = curr;
			}
			return prev;
		}

	}

}
