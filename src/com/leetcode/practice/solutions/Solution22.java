package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateResult(result, "", n, n);
        return result;
    }

    public void generateResult(List<String> result, String s, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(s);
            return;
        }
        if (leftCount == rightCount) {
            generateResult(result, s + "(", leftCount - 1, rightCount);
        } else {
            if (leftCount > 0) {
                generateResult(result, s + "(", leftCount - 1, rightCount);
            }
            generateResult(result, s + ")", leftCount, rightCount - 1);
        }
    }

}
