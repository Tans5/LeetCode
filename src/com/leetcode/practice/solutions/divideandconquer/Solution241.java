package com.leetcode.practice.solutions.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 */
public class Solution241 {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Object> parsed = new ArrayList<>();
        parse(0, expression, parsed);
        return calculate(0, parsed.size() - 1, parsed);
    }

    private void parse(int startIndex, String expression, List<Object> parsed) {
        if (startIndex >= expression.length()) {
            return;
        }
        char c = expression.charAt(startIndex);
        if (c <= '9' && c >= '0') {
            List<Integer> numArray = new ArrayList<>();
            do {
                int n = expression.charAt(startIndex) - '0';
                numArray.add(n);
                startIndex ++;
            } while (startIndex < expression.length() && expression.charAt(startIndex) <= '9' && expression.charAt(startIndex) >= '0');
            int n = 0;
            for (int i = 0; i < numArray.size(); i ++) {
                n += (int) (numArray.get(i) * Math.pow(10, numArray.size() - 1 - i));
            }
            parsed.add(n);
            parse(startIndex, expression, parsed);
        } else {
            parsed.add(c);
            parse(++ startIndex, expression, parsed);
        }
    }

    private int mathCalculate(int a, int b, char alt) {
        return switch (alt) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new RuntimeException("Unknown alt " + alt);
        };
    }

    private List<Integer> calculate(int start, int end, List<Object> parsed) {
        List<Integer> result = new ArrayList<>();
        if (start == end) {
            result.add((Integer) parsed.get(start));
        } else if (start < end) {
            for (int i = start; i <= end; i ++) {
                Object v = parsed.get(i);
                if (v instanceof Character) {
                    List<Integer> left = calculate(start, i - 1, parsed);
                    List<Integer> right = calculate(i + 1, end, parsed);
                    for (Integer l: left) {
                        for (Integer r: right) {
                            result.add(mathCalculate(l, r, (char) v));
                        }
                    }
                }
            }
        }
        return result;
    }
}
