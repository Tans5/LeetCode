package com.leetcode.practice.solutions.dynamicprograming;


/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Solution416 {

    public boolean canPartition(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int n: nums) {
            sum += n;
            if (max < n) {
                max = n;
            }
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (max > target) {
            return false;
        }
        // nums 中的元素的和是否能够等于 i
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num: nums) {
//            /**
//             * 当从前向后遍历时，假设当前处理的元素是 num，在更新较大的 i（如 i = num + 1）时，会用到已经被当前 num 更新过的 dp[i - num]，这相当于允许重复使用 num，导致逻辑错误。
//             *
//             * 假设 num = 2，target = 5：
//             *
//             * 从前向后遍历时，更新顺序为 i = 2 → 3 → 4 → 5：
//             * dp[2] 更新为 true（使用一次 2）。
//             * dp[4] 会基于 dp[2]（已经被更新）更新为 true（相当于使用了两次 2）。
//             * 从后向前遍历时，更新顺序为 i = 5 → 4 → 3 → 2：
//             * dp[5] 可能基于未被修改的 dp[3]（未被当前 num 影响）。
//             * 确保每个元素仅被使用一次。
//             */

//            for (int i = num; i <= target; i ++) {
//                int pre = i - num;
//                dp[i] = dp[i] || dp[pre];
//            }

            // 更新如果选择 num，在 [num, target] 中可以组合成的数。
            for (int i = target; i >= num; i --) {
                int pre = i - num;
                dp[i] = dp[i] || dp[pre];
            }
            if (dp[target]) {
                break;
            }
        }
        return dp[target];
    }
}

