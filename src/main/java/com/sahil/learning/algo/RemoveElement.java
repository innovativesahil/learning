package com.sahil.learning.algo;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int k = removeElement(nums, 2);

        int[] expectedNums = Arrays.copyOf(nums, nums.length);
        assert k == expectedNums.length;
        Arrays.sort(nums);// Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        System.out.println("Done : " + Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Check : " + Arrays.toString(nums));

            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
