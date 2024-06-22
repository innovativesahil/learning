package com.sahil.learning.algo;

import java.util.Arrays;

/*Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.*/
public class MoveZeroToEnd {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int[] expected = new int[]{1,3,12,0,0};
        moveZeroes(nums);
        System.out.println(Arrays.equals(nums, expected));
    }

    public static void moveZeroes(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
