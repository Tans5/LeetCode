package com.leetcode.practice.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution299 {
    public static String solution(String secret, String guess) {
        Map<Character, Integer> sHistory = new HashMap<>();
        for (int i = 0; i < secret.length(); i ++) {
            Character c = secret.charAt(i);
            sHistory.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> gHistory = new HashMap<>();
        for (int i = 0; i < guess.length(); i ++) {
            Character c = guess.charAt(i);
            gHistory.merge(c, 1, Integer::sum);
        }
        int size = Math.min(secret.length(), guess.length());
        int bullsCount = 0;
        for (int i = 0; i < size; i ++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullsCount ++;
            }
        }
        int cowsCount = 0;
        Set<Character> keys = sHistory.keySet();
        for (Character key: keys) {
            int sCount = sHistory.get(key);
            Integer gCount = gHistory.get(key);
            if (gCount != null) {
                cowsCount += sCount > gCount ? gCount : sCount;
            }
        }
        cowsCount -= bullsCount;
        String result = "";
        result += (bullsCount + "A");
        result += (cowsCount + "B");
        return result;
    }
}
