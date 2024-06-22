package com.sahil.learning.algo;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
* */
public class RemoveDuplicateFromArray {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] expectedNums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 5, 5, 5, 6};

        int k = removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("Complete : " +  Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // index to keep unique elements. every unique element is inserted at index j and j is incremented
        int prevUniq = 1;
        for(int i = 1; i <nums.length; i++){
            System.out.println("Test : " + i + " " + Arrays.toString(nums));
            if(nums[i] != nums[i-1]){
//                System.out.println("Replace : " + i + " " + prevUniq);
                nums[prevUniq++] = nums[i];
            }
        }
        return prevUniq;
    }
}
