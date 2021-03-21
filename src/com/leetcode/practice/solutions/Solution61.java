package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution61 {

    public static boolean solution(int[] nums) {
        Arrays.sort(nums);
        int anyCount = 0;
        int d;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                anyCount ++;
                continue;
            }
            if (i > 0 && nums[i - 1] != 0) {
                d = nums[i] - nums[i - 1];
                if (d > 1) {
                    if (d - 1 > anyCount) {
                        return false;
                    } else {
                        anyCount -= d - 1;
                    }
                }
                if (d <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
