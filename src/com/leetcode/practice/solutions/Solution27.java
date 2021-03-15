package com.leetcode.practice.solutions;

public class Solution27 {
    public static int removeElement(int[] nums, int val) {
//        int size = nums.length;
//        int[] origin = Arrays.copyOf(nums, size);
//        int allMove = 0;
//        for (int i = 0; i < size; i ++) {
//            int moveTimes = 0;
//            for (int j = i; j < size; j ++) {
//                if (origin[j] == val) {
//                    moveTimes ++;
//                } else {
//                    break;
//                }
//            }
//            i += moveTimes;
//            allMove += moveTimes;
//            if (i < size) {
//                nums[i - allMove] = origin[i];
//            } else {
//                break;
//            }
//        }
//        return size - allMove;
        int count = 0;
        int size = nums.length;
        for (int i = 0; i < size; i ++) {
            if (nums[i] != val) {
                nums[count ++] = nums[i];
            }
        }
        return count;
    }
}
