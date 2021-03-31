package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        int num1;
        int num2;
        for (int i = 1; i < numRows; i ++) {
            List<Integer> singleLine = new ArrayList<>();
            for (int j = 0; j < i + 1; j ++) {
                num1 = 0;
                num2 = 0;
                if (j - 1 >= 0) {
                    num1 = result.get(i - 1).get(j - 1);
                }
                if (j < result.get(i - 1).size()) {
                    num2 = result.get(i - 1).get(j);
                }
                singleLine.add(num1 + num2);
            }
            result.add(singleLine);
        }
        return result;
    }

}
