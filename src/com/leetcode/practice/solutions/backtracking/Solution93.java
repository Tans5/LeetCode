package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class Solution93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        backtracking(chars, 0, new ArrayList<>(), result);
        return result;
    }

    private Integer convertToInt(char[] chars, int from, int to) {
        if (from > to) {
            return null;
        }
        if (from < to && chars[from] == '0') {
            return null;
        }
        String s = new String(chars, from, to - from + 1);
        int num = Integer.parseInt(s);
        if (num <= 255) {
            return num;
        } else {
            return null;
        }
    }

    private void backtracking(char[] chars, int start, List<Integer> state, List<String> result) {
        if (start >= chars.length && state.size() == 4) {
            StringBuilder sb = new StringBuilder();
            sb.append(state.get(0));
            for (int i = 1; i < state.size(); i ++) {
                sb.append('.');
                sb.append(state.get(i));
            }
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < chars.length; i ++) {
            Integer num = convertToInt(chars, start, i);
            if (num != null) {
                state.add(num);
                backtracking(chars, i + 1, state, result);
                state.remove(state.size() - 1);
            } else {
                break;
            }
        }
    }
}
