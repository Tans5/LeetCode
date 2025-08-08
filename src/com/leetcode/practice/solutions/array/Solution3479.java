package com.leetcode.practice.solutions.array;

import java.util.Arrays;

/**
 * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
 *
 * 你需要对 fruits 数组从左到右按照以下规则放置水果：
 *
 * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
 * 每个篮子只能装 一种 水果。
 * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
 * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
 *
 *
 *
 * 示例 1
 *
 * 输入： fruits = [4,2,5], baskets = [3,5,4]
 *
 * 输出： 1
 *
 * 解释：
 *
 * fruits[0] = 4 放入 baskets[1] = 5。
 * fruits[1] = 2 放入 baskets[0] = 3。
 * fruits[2] = 5 无法放入 baskets[2] = 4。
 * 由于有一种水果未放置，我们返回 1。
 *
 * 示例 2
 *
 * 输入： fruits = [3,6,1], baskets = [6,4,7]
 *
 * 输出： 0
 *
 * 解释：
 *
 * fruits[0] = 3 放入 baskets[0] = 6。
 * fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
 * fruits[2] = 1 放入 baskets[1] = 4。
 * 由于所有水果都已成功放置，我们返回 0。
 *
 *
 *
 * 提示：
 *
 * n == fruits.length == baskets.length
 * 1 <= n <= 105
 * 1 <= fruits[i], baskets[i] <= 109
 */
public class Solution3479 {

    /**
     * 主要思想为：
     *
     * 将 baskets 数组以
     * Math.sqrt(n)=m 的大小进行分块，其中 n 为 baskets 数组的长度，m 为分块的大小。
     *
     * 然后维护块上的最大值 maxV，表示当前块中最大的篮子容量。
     *
     * 我们枚举 fruits 中的每一种水果，然后遍历每个块，会出现以下两种情况：
     *
     * 遍历到某个块的时候，当前块的最大值 maxV 小于当前水果的容量，那么说明当前块中没有容量大于当前水果数量的篮子，继续遍历下一个块。
     * 遍历到某个块的时候，当前块的最大值 maxV 大于等于当前水果的容量，那么说明当前块中存在容量大于等于当前水果数量的篮子。此时从左到右遍历当前块中的每个篮子，如果当前篮子容量大于等于当前水果数量，那么将当前篮子容量置为 0，标记为已被该种水果占用，后续无法再使用。
     * 如果遍历完所有块后，仍然没有找到容量大于等于当前水果数量的篮子，那么计数器 count 加一。
     *
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int m = (int) Math.sqrt(n);
        int section = (n + m - 1) / m;
        int count = 0;
        int[] maxV = new int[section];
        Arrays.fill(maxV, 0);

        for (int i = 0; i < n; i++) {
            maxV[i / m] = Math.max(maxV[i / m], baskets[i]);
        }

        for (int fruit : fruits) {
            int sec;
            int unset = 1;
            for (sec = 0; sec < section; sec++) {
                if (maxV[sec] < fruit) {
                    continue;
                }
                int choose = 0;
                maxV[sec] = 0;
                for (int i = 0; i < m; i++) {
                    int pos = sec * m + i;
                    if (pos < n && baskets[pos] >= fruit && choose == 0) {
                        baskets[pos] = 0;
                        choose = 1;
                    }
                    if (pos < n) {
                        maxV[sec] = Math.max(maxV[sec], baskets[pos]);
                    }
                }
                unset = 0;
                break;
            }
            count += unset;
        }
        return count;
    }

    /**
     * 线段树的核心是将一个大区间递归地分割成若干个小区间，每个节点代表一个区间，并存储该区间的某些关键信息（如最大值、最小值、和等）。通过这种分治的方式，线段树可以将原本需要遍历整个数组的区间操作（如查询或更新），优化到对数时间复杂度（O(log n)）。
     *
     */
    public int numOfUnplacedFruits2(int[] fruits, int[] baskets) {
        SegmentTreeNode tree = buildTree(0, baskets.length - 1, baskets);
        int ret = 0;
        for(int f: fruits) {
            int i = query(tree, f);
            if (i == -1) {
                ret ++;
            } else {
                removeIndex(tree, i);
            }
        }
        return ret;
    }


    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.max = nums[start];
        } else {
            int mid = (start + end) / 2;
            node.left = buildTree(start, mid, nums);
            node.right = buildTree(mid + 1, end, nums);
            node.max = Math.max(node.left.max, node.right.max);
        }
        return node;
    }

    private int query(SegmentTreeNode tree, int n) {
        if (!tree.available || tree.max < n) {
            return -1;
        }
        if (tree.leftIndex == tree.rightIndex) {
            return tree.leftIndex;
        }
        int ret = query(tree.left, n);
        if (ret != -1) {
            return ret;
        }
        return query(tree.right, n);
    }

    private void removeIndex(SegmentTreeNode tree, int index) {
        if (tree.leftIndex == tree.rightIndex) {
            tree.available = false;
            return;
        }
        if (index <= tree.left.rightIndex) {
            removeIndex(tree.left, index);
        } else {
            removeIndex(tree.right, index);
        }
        tree.available = tree.left.available || tree.right.available;
    }

    private class SegmentTreeNode {
        int leftIndex;
        int rightIndex;
        int max = Integer.MIN_VALUE;
        boolean available = true;
        SegmentTreeNode left = null;
        SegmentTreeNode right = null;
        SegmentTreeNode(int leftIndex, int rightIndex) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

}
