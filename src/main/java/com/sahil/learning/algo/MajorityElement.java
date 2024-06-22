package com.sahil.learning.algo;

// Given an array nums of size n, return the majority element.
//
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2, 3, 4, 2, 5, 6, 2, 2, 2};

        int candidate = 0;
        int count = 0;

        for(int num : nums) {
            if(count == 0){
                candidate = num;
            }
            if(num == candidate) {
                count ++;
            }else{
                count--;
            }
        }
        System.out.println("Majority Candidate : " + candidate);
    }
}
