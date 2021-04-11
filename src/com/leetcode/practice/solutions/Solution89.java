package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution89 {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n <= 0) {
            return result;
        }
        int lastSize;
        int temp;
        for (int i = 1; i <= n; i ++) {
            lastSize = result.size();
            temp = 1 << (i - 1);
            for (int j = lastSize - 1; j >= 0; j --) {
                result.add(result.get(j) + temp);
            }
        }
        return result;
    }

}
