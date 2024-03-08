package com.sayan.dp.subsequences;

/*
 * https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532
 * 
 Count Subsets with Sum K
Moderate
0/80
Contributed by
343 upvotes
Asked in company
Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.



Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.



Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.



Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible way
		*/
public class CountSubsetSumTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursion | time = O(2^n) exponential | space = O(n) + O(n+k)
	public class SolutionRecursion {
	    private static final int MOD = (int) Math.pow(10, 9) + 7;
	       private static int recursion(int[] nums, int ind, int target) {
	               
	        if(ind == 0) {
	            if(target == 0 && nums[0] == 0) return 2;
	            if(target == 0  || nums[0] == target) return 1;
	            return 0;
	        }        

	        int left = recursion(nums, ind - 1, target);
	        int right = 0;
	        if(nums[ind] <= target) {
	            right = recursion(nums , ind - 1, target - nums[ind]);
	        }
	        return (left + right) % MOD;

	    }
	    public static int findWays(int nums[], int tar) {
	          int n = nums.length;
	        return recursion(nums, n - 1, tar);
	    }
	}

}
