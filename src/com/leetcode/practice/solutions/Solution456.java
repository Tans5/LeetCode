package com.leetcode.practice.solutions;

public class Solution456 {

    public boolean find132pattern(int[] nums) {
        int in, jn, kn;
        int size = nums.length;
        for (int i = 0; i < size; i ++) {
            in = nums[i];
            for (int j = i + 1; j < size; j ++) {
                jn = nums[j];
                if (jn > in) {
                    for (int k = j + 1; k < size; k ++) {
                        kn = nums[k];
                        if (kn < jn && kn > in) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
