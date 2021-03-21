package com.leetcode.practice.solutions;


import java.util.Arrays;

public class Solution881 {

    public static int numRescueBoats(int[] people, int limit) {
        if (people.length < 1) {
            return 0;
        }
        Arrays.sort(people);
        int result = 0;
        int start = 0;
        int end = people.length - 1;
        while (true) {
            if (start > end) {
                break;
            }
            if (end == start) {
                result ++;
                break;
            }
            if (people[end] + people[start] > limit) {
                end --;
                result ++;
            } else {
                result ++;
                start ++;
                end --;
            }
        }
        return result;
    }

}
