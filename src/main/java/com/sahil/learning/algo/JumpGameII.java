package com.sahil.learning.algo;
/*
* You are given an integer array nums.
* You are initially positioned at the array's first index,
* and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.
* */
public class JumpGameII {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {2,3,1,0,4};
        System.out.println(jump(nums1));
        System.out.println(jump(nums2));
    }

    public static int jump(int[] nums) {
        // ladder approach - intuitive BFS
        // keep climbing on the current ladder and store the longest ladder if found
        // swith to longest ladder when current ladder ends

        int jumps = 0;
        int currentLadder = 0;
        int longestLadder = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if (i > longestLadder) return -1;
            longestLadder = Math.max(longestLadder, i + nums[i]);
            System.out.println("longest " + longestLadder);
            System.out.println("current " + currentLadder);
            if(i == currentLadder){
                jumps++;
                currentLadder = longestLadder;
                if(currentLadder >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}
