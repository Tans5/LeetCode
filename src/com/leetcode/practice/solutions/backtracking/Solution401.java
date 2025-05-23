package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 *
 * 小时不会以零开头：
 *
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 *
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *
 * 示例 1：
 *
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 示例 2：
 *
 * 输入：turnedOn = 9
 * 输出：[]
 *
 */
public class Solution401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        int[] watchNum = new int[] {
                // hours
                8,
                4,
                2,
                1,

                // min
                32,
                16,
                8,
                4,
                2,
                1
        };
        backtracking(turnedOn, 0, 0, watchNum, 0, result);
        return result;
    }

    private void backtracking(
            int turnedOn,
            int hours,
            int mins,
            int[] watchNum,
            int fromIndex,
            List<String> result
    ) {
        if (turnedOn <= 0) {
            if (hours <= 11 && mins <= 59) {
                result.add(String.format("%d:%02d", hours, mins));
            }
            return;
        }
        if (fromIndex >= watchNum.length) {
            return;
        }
        for (int i = fromIndex; i < watchNum.length; i ++) {
            int num = watchNum[i];
            if (i <= 3) {
                // Hour
                backtracking(turnedOn - 1, hours + num, mins, watchNum, i + 1, result);
            } else {
                // Min
                backtracking(turnedOn - 1, hours, mins + num, watchNum, i + 1, result);
            }
        }
    }
}
