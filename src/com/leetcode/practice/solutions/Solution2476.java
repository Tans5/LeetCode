package com.leetcode.practice.solutions;

import com.leetcode.practice.solutions.others.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2476 {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        scanTree(root, sorted);
        for (Integer query : queries) {
            findTarget(sorted, query, result);
        }
        return result;
    }

    void findTarget(List<Integer> sorted, int target, List<List<Integer>> result) {
        if (sorted.isEmpty()) {
            result.add(Arrays.asList(-1, -1));
            return;
        }
        int startIndex = 0;
        int count = sorted.size();
        while (true) {
            if (count == 0) {
                break;
            }
            int midIndex = (startIndex + startIndex + count) / 2;
            int midValue = sorted.get(midIndex);
            if (midValue == target) {
                result.add(Arrays.asList(midValue, midValue));
                break;
            }
            if (midValue > target) {
                int preIndex = midIndex - 1;
                if (preIndex >= 0) {
                    int preValue = sorted.get(preIndex);
                    if (preValue < target) {
                        result.add(Arrays.asList(preValue, midValue));
                        break;
                    } else {
                        count = midIndex - startIndex;
                    }
                } else {
                    result.add(Arrays.asList(-1, midValue));
                    break;
                }
            } else {
                int nextIndex = midIndex + 1;
                if (nextIndex < sorted.size()) {
                    int nextValue = sorted.get(nextIndex);
                    if (nextValue > target) {
                        result.add(Arrays.asList(midValue, nextValue));
                        break;
                    } else {
                        count = count + startIndex - midIndex - 1;
                        startIndex = midIndex + 1;
                    }
                } else {
                    result.add(Arrays.asList(midValue, -1));
                    break;
                }
            }
        }
    }

    private void scanTree(TreeNode tree, List<Integer> sorted) {
        if (tree == null) {
            return;
        }
        scanTree(tree.left, sorted);
        sorted.add(tree.val);
        scanTree(tree.right, sorted);
    }

}






















