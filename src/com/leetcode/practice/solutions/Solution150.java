package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution150 {

    /**
     * 示例 1：
     *
     * 输入：tokens = ["2","1","+","3","*"]
     * 输出：9
     * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
     * 示例 2：
     *
     * 输入：tokens = ["4","13","5","/","+"]
     * 输出：6
     * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
     * @param tokens
     * @return
     */
    Integer result;
    public int evalRPN(String[] tokens) {
        if (tokens.length < 3) {
            return str2Int(tokens[0]);
        }
        result = null;
        List<Object> tokensList = new ArrayList<>();
        for (String t: tokens) {
            if (isOptString(t)) {
                tokensList.add(t);
            } else {
                tokensList.add(str2Int(t));
            }
        }
        go(tokensList);
        if (result == null) {
            return 0;
        } else {
            return result;
        }
    }

    private void go(List<Object> tokens) {
        if (tokens.size() < 3) {
            return;
        }
        int optIndex = -1;
        for (int i = 0; i < tokens.size(); i ++) {
            Object o = tokens.get(i);
            if (isOptString(o)) {
                optIndex = i;
                break;
            }
        }
        if (optIndex < 2) {
            return;
        }
        int a = (int) tokens.get(optIndex - 2);
        int b = (int) tokens.get(optIndex - 1);
        int result;
        String optStr = (String) tokens.get(optIndex);
        if (optStr.equals("+")) {
            result = a + b;
        } else if (optStr.equals("-")) {
            result = a - b;
        } else if (optStr.equals("/")) {
            result = a / b;
        } else {
            result = a * b;
        }
        this.result = result;
        tokens.remove(optIndex);
        tokens.remove(optIndex - 1);
        tokens.set(optIndex - 2, result);
        go(tokens);
    }

    private boolean isOptString(Object o) {
        if (o instanceof String) {
            return o.equals("+") || o.equals("-") || o.equals("*") || o.equals("/");
        } else {
            return false;
        }
    }

    private int str2Int(Object o) {
        if (o instanceof String) {
            String s = (String) o;
            boolean isNegative = false;
            int startIndex = 0;
            if (s.charAt(0) == '-') {
                isNegative = true;
                startIndex = 1;
            } else if (s.charAt(0) == '+') {
                startIndex = 1;
            }
            int result = 0;
            int p = 0;
            for (int i = s.length() - 1; i >= startIndex; i --) {
                char c = s.charAt(i);
                result += (c - '0') * (int) Math.pow(10, p);
                p ++;
            }
            return isNegative ? (result * -1) : result;
        } else {
            return 0;
        }
    }
}
