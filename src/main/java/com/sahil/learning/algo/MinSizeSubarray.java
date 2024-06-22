package com.sahil.learning.algo;

/*Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.*/
public class MinSizeSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int size = minSubArrayLen(7, nums);
        System.out.println("Min subarray length: " + size);
    }

    // Sliding window approach
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int mn = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                sum -= nums[i];
                mn = Math.min(j - i + 1, mn);
                i++;
            }
            j++;
        }
        if (mn == Integer.MAX_VALUE) {
            return 0;
        }
        return mn;
    }
}
