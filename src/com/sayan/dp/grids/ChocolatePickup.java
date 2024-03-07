package com.sayan.dp.grids;

import java.util.Arrays;

/*
 * link 
Chocolate Pickup https://www.codingninjas.com/studio/problems/ninja-and-his-friends_3125885
Hard
0/120
Average time to solve is 29m
Contributed by
421 upvotes
Asked in companies
Problem statement
Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates. Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.

Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid. Each of them can move from their current cell to the cells just below them. When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero. If both stay in the same cell, only one of them will pick the chocolates in it.

If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.

Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.

Example:
Input: ‘R’ = 3, ‘C’ = 4
      ‘GRID’ = [[2, 3, 1, 2], [3, 4, 2, 2], [5, 6, 3, 5]]
Output: 21

Initially Alice is at the position (0,0) he can follow the path (0,0) -> (1,1) -> (2,1) and will collect 2 + 4 + 6 = 12 chocolates.

Initially Bob is at the position (0, 3) and he can follow the path (0, 3) -> (1,3) -> (2, 3) and will colllect 2 + 2 + 5 = 9 chocolates.

Hence the total number of chocolates collected will be 12 + 9 = 21. there is no other possible way to collect a greater number of chocolates than 21.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= ‘T’ <= 10
2 <= 'R', 'C' <= 50
0 <= 'GRID[i][j]'<= 10^2
Time Limit: 1sec
Sample Input 1 :
2
3 4
2 3 1 2
3 4 2 2
5 6 3 5
2 2
1 1
1 2
Sample Output 1 :
21
5
Explanation Of Sample Input 1 :
For the first test case, Initially Alice is at the position (0, 0) he can follow the path (0, 0) -> (1, 1) -> (2, 1) and will collect 2 + 4 + 6 = 12 chocolates.

Initially Bob is at the position (0, 3) and he can follow the path (0, 3) -> (1, 3) -> (2, 3) and will collect 2 + 2 + 5 = 9 chocolates.

Hence the total number of chocolates collected will be 12 + 9 = 21.

For the second test case, Alice will follow the path (0, 0) -> (1, 0) and Bob will follow the path (0, 1) -> (1, 1). total number of chocolates collected will be 1 + 1 + 1 + 2 = 5
Sample Input 2 :
2
2 2
3 7
7 6
3 2
4 5
3 7
4 2
Sample Output 2 :
23
25*/
public class ChocolatePickup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursion | time = O(3^row * 3^row) (exponential) | space = O(row)
	class SolutionRecursion {
		private static int recursion(int i, int j, int row, int r, int c, int[][] grid) {
			if (i < 0 || j < 0 || i > c - 1 || j > c - 1) {
				return Integer.MIN_VALUE;
			}
			if (row == r - 1) {
				if (i == j)
					return grid[row][i];
				return grid[row][i] + grid[row][j];
			}

			int ans = Integer.MIN_VALUE;
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					ans = Math.max(ans, recursion(i + x, j + y, row + 1, r, c, grid));
				}
			}
			if (i == j)
				ans += grid[row][i];
			else
				ans += grid[row][i] + grid[row][j];
			return ans;
		}

		public static int maximumChocolates(int r, int c, int[][] grid) {

			// Write your code here.
			return recursion(0, c - 1, 0, r, c, grid);
		}
	}

	// Recursion | time = O(row * col * col) | space = O(row) + O(row * col * col)
	public class SolutionMemoization {
		private static int recursionMemoization(int i, int j, int row, int r, int c, int[][] grid, int[][][] dp) {
			if (i < 0 || j < 0 || i > c - 1 || j > c - 1) {
				return Integer.MIN_VALUE;
			}
			if (row == r - 1) {
				if (i == j)
					return grid[row][i];
				return grid[row][i] + grid[row][j];
			}
			if (dp[i][j][row] != -1)
				return dp[i][j][row];

			int ans = Integer.MIN_VALUE;
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					ans = Math.max(ans, recursionMemoization(i + x, j + y, row + 1, r, c, grid, dp));
				}
			}
			if (i == j)
				ans += grid[row][i];
			else
				ans += grid[row][i] + grid[row][j];
			return dp[i][j][row] = ans;
		}

		public static int maximumChocolates(int r, int c, int[][] grid) {

			int[][][] dp = new int[c][c][r];
			for (int[][] sec : dp) {
				for (int[] third : sec) {
					Arrays.fill(third, -1);
				}
			}
			return recursionMemoization(0, c - 1, 0, r, c, grid, dp);
		}
	}

}
