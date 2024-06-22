package com.sahil.learning.algo;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        merge2(nums1, m, nums2, n);
    }

    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;

        int k = m + n - 1;

        while(j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums1[j--];
            }
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0 && m == 0) return;

        int len = m + n;
        int[] temp = Arrays.copyOf(nums1, m);

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < len) {
            if (i < m && j < n) {
                if (temp[i] < nums2[j]) {
                    nums1[k++] = temp[i++];
                } else {
                    nums1[k++] = nums2[j++];
                }
            }
            if (i == m) {
                while (j < n) {
                    nums1[k++] = nums2[j++];
                }
            }
            if (j == n) {
                while (i < m) {
                    nums1[k++] = temp[i++];
                }
            }
        }
    }
}
