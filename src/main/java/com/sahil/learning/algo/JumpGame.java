package com.sahil.learning.algo;
/*
* You are given an integer array nums.
* You are initially positioned at the array's first index,
* and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
* */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        int reachable = 0;
        int lastIndex = nums.length - 1;
        for(int i = 0; i <= lastIndex && reachable < lastIndex; i ++){

            if(reachable < i){
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
