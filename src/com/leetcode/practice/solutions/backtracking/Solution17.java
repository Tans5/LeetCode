package com.leetcode.practice.solutions.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        List<String> numToChars = new ArrayList<>(10);
        numToChars.add(""); // 0
        numToChars.add(""); // 1
        numToChars.add("abc"); // 2
        numToChars.add("def"); // 3
        numToChars.add("ghi"); // 4
        numToChars.add("jkl"); // 5
        numToChars.add("mno"); // 6
        numToChars.add("pqrs"); // 7
        numToChars.add("tuv"); // 8
        numToChars.add("wxyz"); // 9
        char[] ds = digits.toCharArray();
        char[] state = new char[ds.length];
        backtracking(ds, 0, numToChars, state, result);
        return result;
    }

    private void backtracking(char[] digits, int digitsIndex, List<String> numToChars, char[] state, List<String> result) {
        if (digitsIndex >= digits.length) {
            result.add(new String(state));
            return;
        }
        int charsIndex = digits[digitsIndex] - '0';
        String chars = numToChars.get(charsIndex);
        for (int i = 0; i < chars.length(); i ++) {
            char c = chars.charAt(i);
            state[digitsIndex] = c;
            backtracking(digits, digitsIndex + 1, numToChars, state, result);
        }
    }
}
