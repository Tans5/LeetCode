package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;

public class Solution319 {

    public static int solution(int n) {
        Map<Integer, Boolean> history = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            history.put(i, true);
        }

        for (int step = 2; step <= n; step ++) {
            for (int j = step - 1; j < n; j = j + step) {
                history.put(j, !history.get(j));
            }
        }

        int result = 0;
        for (int i = 0; i < n; i ++) {
            if (history.get(i)) {
                result ++;
            }
        }
        return result;
    }
}
