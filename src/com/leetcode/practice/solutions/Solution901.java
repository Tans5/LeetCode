package com.leetcode.practice.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution901 {

    public Solution901() {
    }

    List<Integer> prices = new ArrayList<>();
    public int next(int price) {
        prices.add(price);
        int count = 1;
        int startIndex = prices.size() - 2;
        for (int i = startIndex; i >= 0; i --) {
            if (prices.get(i) > price) {
                break;
            } else {
                count ++;
            }
        }
        return count;
    }

}
