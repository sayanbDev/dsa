package com.sayan.dp.oned;

import java.util.Arrays;

/*
link https://leetcode.com/problems/house-robber/
	
	198. House Robber
	Solved
	Medium
	Topics
	Companies
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

	Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

	 

	Example 1:

	Input: nums = [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	Total amount you can rob = 1 + 3 = 4.
	Example 2:

	Input: nums = [2,7,9,3,1]
	Output: 12
	Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	Total amount you can rob = 2 + 9 + 1 = 12.
	 

	Constraints:

	1 <= nums.length <= 100
	0 <= nums[i] <= 400
	*/
public class HouseRobber {

	public static void main(String[] args) {

	}
	// Recursion | time = O(2^n) | space = O(n)
	class SolutionRecursion {
	    public int rob(int[] nums) {
	        int n = nums.length;
	        return recursion(nums, n - 1);  
	    }
	    private static int recursion(int[] nums, int ind) {

	        if(ind == 0) {
	            return nums[ind];
	        }
	        if(ind < 0) {
	            return 0;
	        }

	        int currNotRob = recursion(nums, ind - 1);
	        int currRob = nums[ind] + recursion(nums, ind - 2);
	        return Math.max(currNotRob, currRob);
	    }
	}
	
	// Recursion with Memoization | time = O(n) | space = O(n) + O(n)
	class SolutionMemoization {
	    public int rob(int[] nums) {
	        int n = nums.length;
	        int[] dp = new int[n];
	        Arrays.fill(dp, -1);
	        return recursionWithMemo(nums, n - 1, dp);  
	    }
	    private static int recursionWithMemo(int[] nums, int ind, int[] dp) {

	        if(ind == 0) {
	            return nums[ind];
	        }
	        if(ind < 0) {
	            return 0;
	        }
	        if(dp[ind] != -1)
	            return dp[ind];

	        int currNotRob = recursionWithMemo(nums, ind - 1, dp);
	        int currRob = nums[ind] + recursionWithMemo(nums, ind - 2, dp);
	        return dp[ind] = Math.max(currNotRob, currRob);
	    }
	}

}
