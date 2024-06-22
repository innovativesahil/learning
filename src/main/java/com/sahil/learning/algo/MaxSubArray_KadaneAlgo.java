package com.sahil.learning.algo;

/* Leetcode  53
* Given an integer array nums, find the subarray
* with the largest sum, and return its sum.*/
public class MaxSubArray_KadaneAlgo {

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {1};
        int[] arr3 = {5,4,-1,7,8};

        int res1 = maxSubArray(arr1);
        int res2 = maxSubArray(arr2);
        int res3 = maxSubArray(arr3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int curSum = 0;

        for(int num : nums){
            curSum += num;
            maxSum = Math.max(maxSum, curSum);

            if(curSum < 0) curSum = 0;
        }
        return maxSum;
    }
}
