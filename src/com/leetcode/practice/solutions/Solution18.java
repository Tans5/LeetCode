package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        int numLen = nums.length;
        if (numLen < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < numLen - 3; i ++) {
            int a = nums[i];
            boolean isOverFlow = minusIsOverFlow(target, a);
            if (isOverFlow) {
                continue;
            }
            int tempA = target - a;
            if (i > 0) {
                int lastTempA = target - nums[i - 1];
                if (tempA == lastTempA) {
                    continue;
                }
            }
            for (int j = i + 1; j < numLen - 2; j ++) {
                int b = nums[j];
                isOverFlow = minusIsOverFlow(tempA, b);
                if (isOverFlow) {
                    continue;
                }
                int tempB = tempA - b;
                if (j > i + 1) {
                    int lastTempB = tempA - nums[j - 1];
                    if (lastTempB == tempB) {
                        continue;
                    }
                }
                for (int k = j + 1; k < numLen - 1; k ++) {
                    int c = nums[k];
                    isOverFlow = minusIsOverFlow(tempB, c);
                    if (isOverFlow) {
                        continue;
                    }
                    int tempD = tempB - c;
                    if (k > j + 1) {
                        int lastTempD = tempB - nums[k - 1];
                        if (lastTempD == tempD) {
                            continue;
                        }
                    }
                    int targetIndex = Arrays.binarySearch(nums, k + 1, numLen, tempD);
                    if (targetIndex > 0) {
                        List<Integer> list = new ArrayList<>(4);
                        list.add(a);
                        list.add(b);
                        list.add(c);
                        list.add(tempD);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean minusIsOverFlow(int a, int b) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        if (a >= 0 && b >= 0) {
            return false;
        }
        if (a >= 0 && b < 0) {
            return (max - a) < -b;
        }
        if (a < 0 && b >= 0) {
            return (min + b) > a;
        }
        // a < 0 && b < 0
        return false;
    }
}
