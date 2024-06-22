package com.sahil.learning.algo;

import java.util.Arrays;

public class RemoveDuplicatesII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9};
        int[] expectedNums = new int[]{1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 5, 5};

        int k = removeDuplicates(nums);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("Complete : " +  Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int prevUniq = 1;

        for(int i = 1; i < nums.length; i ++){

            if(prevUniq == 1 || nums[i] != nums[prevUniq-2]){
                nums[prevUniq++] = nums[i];
            }
        }
        return prevUniq;
    }
}
