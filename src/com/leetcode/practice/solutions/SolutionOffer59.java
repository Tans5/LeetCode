package com.leetcode.practice.solutions;

public class SolutionOffer59 {

    public static void main(String[] args) {
        int[] testA = new int[] {1, 2, 3, 4, 5};
        testA = MaxQueue.growSize(testA);
    }
}

class MaxQueue {
    int[] nums = new int[8];
    int start = 0;
    int len = 0;

    public MaxQueue() {
    }

    public int max_value() {
        int maxResult = -1;
        if (len > 0) {
            for (int i = start; i < start + len; i ++) {
                if (nums[i] > maxResult) {
                    maxResult = nums[i];
                }
            }
        }
        return maxResult;
    }

    public void push_back(int value) {
        len ++;
        if (len + start >= nums.length) {
            nums = growSize(nums);
        }
        nums[start + len - 1] = value;
    }

    public int pop_front() {
        if (len <= 0) {
            return -1;
        }
        len --;
        return nums[start ++];
    }

    public static int[] growSize(int[] array) {
        int[] result = new int[array.length + (array.length >> 2)];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }

}
