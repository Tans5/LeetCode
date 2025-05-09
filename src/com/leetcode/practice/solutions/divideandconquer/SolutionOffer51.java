package com.leetcode.practice.solutions.divideandconquer;

public class SolutionOffer51 {

    public int reversePairs(int[] record) {
        int[] buffer = new int[record.length];
        return mergeAndSort(0, record.length - 1, record, buffer);
    }

    private int mergeAndSort(int start, int end, int[] record, int[] buffer) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;

        int leftCount = mergeAndSort(start, mid, record, buffer);
        int rightCount = mergeAndSort(mid + 1, end, record, buffer);
        int crossCount = mergeAndCount(start, end, record, buffer);

        return crossCount + leftCount + rightCount;
    }

    private int mergeAndCount(int start, int end, int[] record, int[] buffer) {
        System.arraycopy(record, start, buffer, start, end - start + 1);
        // 此刻在 record 中 [start, mid] 和 [mid + 1, end] 已经分别完成了排序
        int mid = (start + end) / 2;

        // 此后对 record 进行排序，计算逆序列对数量
        int leftIndex = start;
        int rightIndex = mid + 1;
        int sortedIndex = start;
        int count = 0;
        while (leftIndex <= mid && rightIndex <= end) {
            if (buffer[leftIndex] <= buffer[rightIndex]) {
                record[sortedIndex ++] = buffer[leftIndex ++];
            } else {
                record[sortedIndex ++] = buffer[rightIndex ++];
                // 左边比右边大，需要计算逆序列对数量
                count += (mid - leftIndex + 1);
            }
        }

        while (leftIndex <= mid) {
            record[sortedIndex ++] = buffer[leftIndex ++];
        }
        while (rightIndex <= end) {
            record[sortedIndex ++] = buffer[rightIndex ++];
        }

        return count;
    }
}
