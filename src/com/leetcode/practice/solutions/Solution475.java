package com.leetcode.practice.solutions;

import java.util.Arrays;

public class Solution475 {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        long minR = -1;
        long maxR = Math.max(Math.abs(houses[houses.length - 1] - heaters[0]), Math.abs(heaters[heaters.length - 1] - houses[0])) + 1;
        int midR;
        int result = (int) maxR;

        while (maxR - minR > 1) {
            midR = (int) ((maxR + minR) / 2);
            if (isCover(houses, heaters, midR)) {
                if (result > midR) {
                    result = midR;
                }
                maxR = midR;
            } else {
                minR = midR;
            }

        }

        return result;
    }

    public static boolean isCover(int[] houses, int[] heaters, int r) {
        int position = 0;
        int start;
        int end;
        int mid;
        for(int house: houses) {
            if (house <= heaters[0]) {
                position = heaters[0];
            } else if (house >= heaters[heaters.length - 1]) {
                position = heaters[heaters.length - 1];
            } else {
                start = 0;
                end = heaters.length;
                while (end - start > 1) {
                    mid = (start + end) / 2;
                    if (heaters[mid] == house) {
                        position = heaters[mid];
                        break;
                    }
                    if (heaters[mid] > house && heaters[mid - 1] < house) {
                        if (heaters[mid] - house > house - heaters[mid - 1]) {
                            position = heaters[mid - 1];
                        } else {
                            position = heaters[mid];
                        }
                        break;
                    }
                    if (heaters[mid] > house) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                }
            }
            if (Math.abs(position - house) > r) {
                return false;
            }
        }
        return true;
    }
}
