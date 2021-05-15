package com.leetcode.practice.solutions;

public class SolutionOffer21 {

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (true) {
            while (left < right && nums[left] % 2 == 0) {
                left ++;
            }
            if (left == right) {
                break;
            }
            while (left < right && nums[right] % 2 == 1) {
                right --;
            }
            if (left == right) {
                break;
            }
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

}
