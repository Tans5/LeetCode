package com.leetcode.practice.solutions;

public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[0];
        }
        int[] result = new int[] {-1, -1};
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (sum > target) {

                while (left < right && numbers[right] == numbers[right - 1]) {
                    right --;
                }
                right --;
            } else {
                while (left < right && numbers[left] == numbers[left + 1]) {
                    left ++;
                }
                left ++;
            }
        }
        return result;
    }
}
