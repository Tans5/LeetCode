package com.leetcode.practice.solutions.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 *
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * 题目数据确保队列可以被重建
 */
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        int[][] result = null;
        int[][] temp;
        for (int[] toInsert : people) {
            if (result == null) {
                result = new int[][] {toInsert};
            } else {
                int toInsertIndex = toInsert[1];
                temp = result;
                result = new int[temp.length + 1][];
                if (toInsertIndex == 0) {
                    result[0] = toInsert;
                    System.arraycopy(temp, 0, result, 1, temp.length);
                } else if (toInsertIndex == temp.length) {
                    result[temp.length] = toInsert;
                    System.arraycopy(temp, 0, result, 0, temp.length);
                } else {
                    result[toInsertIndex] = toInsert;
                    System.arraycopy(temp, 0, result, 0, toInsertIndex);
                    System.arraycopy(temp, toInsertIndex, result, toInsertIndex + 1, temp.length - toInsertIndex);
                }
            }
        }
        return result;
    }
}
