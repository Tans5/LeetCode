package com.leetcode.practice.solutions;

import java.util.*;

public class Solution2034 {


    Map<Integer, Integer> dayToPrice = new HashMap<>();
    int currentTime = Integer.MIN_VALUE;

    List<Integer> pricesSorted = new ArrayList<>();

    public void update(int timestamp, int price) {
        if (timestamp > currentTime) {
            currentTime = timestamp;
        }
        Integer lastValue = dayToPrice.get(timestamp);
        if (lastValue != null) {
            removePriceSorted(lastValue);
        }
        dayToPrice.put(timestamp, price);
        insertPriceSorted(price);
    }

    public void insertPriceSorted(int price) {
        if (pricesSorted.isEmpty()) {
            pricesSorted.add(price);
            return;
        }
        int startIndex = 0;
        int count = pricesSorted.size();
        while (true) {
            if (count <= 0) {
                break;
            }
            int midIndex = (startIndex + startIndex + count) / 2;
            int midValue = pricesSorted.get(midIndex);

            if (midValue >= price) {
                int preIndex = midIndex - 1;
                if (preIndex < 0) {
                    pricesSorted.add(0, price);
                    break;
                } else {
                    if (pricesSorted.get(preIndex) <= price) {
                        pricesSorted.add(midIndex, price);
                        break;
                    }
                }
            } else {
                int nextIndex = midIndex + 1;
                if (nextIndex >= pricesSorted.size()) {
                    pricesSorted.add(nextIndex, price);
                    break;
                } else {
                    if (pricesSorted.get(nextIndex) >= price) {
                        pricesSorted.add(nextIndex, price);
                        break;
                    }
                }
            }

            if (midValue > price) {
                count = midIndex - startIndex;
            } else {
                count = count - (midIndex - startIndex + 1);
                startIndex = midIndex + 1;
            }
        }
    }

    public void removePriceSorted(int price) {
        if (pricesSorted.isEmpty()) {
            return;
        }
        int startIndex = 0;
        int count = pricesSorted.size();
        while (true) {
            if (count == 0) {
                break;
            }
            int midIndex = (count + startIndex + startIndex) / 2;
            int midValue = pricesSorted.get(midIndex);
            if (midValue == price) {
                pricesSorted.remove(midIndex);
                break;
            }
            if (midValue > price) {
                count = midIndex - startIndex;
            } else {
                count = count - (midIndex - startIndex + 1);
                startIndex = midIndex + 1;
            }
        }
    }

    public int current() {
        Integer price = dayToPrice.get(currentTime);
        return price == null ? 0 : price;
    }

    public int maximum() {
        return pricesSorted.isEmpty() ? 0 : pricesSorted.get(pricesSorted.size() - 1);
    }

    public int minimum() {
        return pricesSorted.isEmpty() ? 0 : pricesSorted.get(0);
    }
}
