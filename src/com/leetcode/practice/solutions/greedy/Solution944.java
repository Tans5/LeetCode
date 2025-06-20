package com.leetcode.practice.solutions.greedy;

/**
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序非严格递增排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按字典序非严格递增排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * 返回你需要删除的列数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 *   cba
 *   daf
 *   ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 */
public class Solution944 {

    // "rrjk","furt","guzm"
    public int minDeletionSize(String[] strs) {
        int count = 0;
        if (strs.length == 0) {
            return count;
        }
        int rowSize = strs.length;
        int colSize = strs[0].length();
        for (int c = 0; c < colSize; c ++) {
            for (int r = 1; r < rowSize; r ++) {
                if (strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    count ++;
                    break;
                }
            }
        }
        return count;
    }
}
