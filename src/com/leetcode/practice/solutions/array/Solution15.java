package com.leetcode.practice.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Integer lastNum = null;
        for (int i = nums.length - 1; i > 1; i --) {
            int num = nums[i];
            if (lastNum == null || lastNum != num) {
                lastNum = num;
                targetSum(nums, i - 1, - num, result);
            }
        }

        return result;
    }

    private void targetSum(int[] nums, int endIndex, int targetSum, List<List<Integer>> result) {
        int left = 0;
        int right = endIndex;
        Integer lastLeftNum = null;
        Integer lastRightNum = null;
        while (left < right) {
            int leftNum = nums[left];
            int rightNum = nums[right];
            if (leftNum + rightNum == targetSum) {
                if ((lastLeftNum == null || lastLeftNum != leftNum) && (lastRightNum == null || lastRightNum != rightNum)) {
                    lastLeftNum = leftNum;
                    lastRightNum = rightNum;
                    List<Integer> q = new ArrayList<>();
                    q.add(leftNum);
                    q.add(rightNum);
                    q.add(-targetSum);
                    result.add(q);
                }
                left ++;
                right --;
            } else if (leftNum + rightNum < targetSum) {
                left ++;
            } else {
                right --;
            }
        }
    }


    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        threeSum2(nums, 0, new ArrayList<>(), 0, result);
        return result;
    }

    public void threeSum2(int[] nums, int startIndex, List<Integer> state, int sum, List<List<Integer>> result) {
        if (state.size() == 3) {
            if (sum == 0) {
                result.add(new ArrayList<>(state));
            }
            return;
        }
        Integer lastNum = null;
        for (int i = startIndex; i < nums.length; i ++) {
            int num = nums[i];
            if (num + sum > 0) {
                break;
            }
            if (lastNum == null || lastNum != num) {
                lastNum = num;
                state.add(num);
                threeSum2(nums, i + 1, state, sum + num, result);
                state.remove(state.size() - 1);
            }
        }
    }
}
