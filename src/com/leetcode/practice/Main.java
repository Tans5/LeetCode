package com.leetcode.practice;


import com.leetcode.practice.solutions.*;


public class Main {
    public static void main(String[] args) {
        Solution240 s = new Solution240();

        boolean result = s.searchMatrix(
                new int[][]{
                        new int[]{93,157,226,308,365,384,479,539,557,652},
                        new int[]{118,234,287,368,395,432,480,607,634,723},
                        new int[]{132,263,381,453,525,533,577,650,707,800},
                        new int[]{171,307,473,504,526,596,643,719,776,842},
                        new int[]{233,319,514,571,668,710,733,777,875,886},
                        new int[]{318,362,555,605,717,782,809,884,889,940},
                        new int[]{349,415,622,708,787,795,824,921,957,1014},
                        new int[]{414,420,656,789,813,898,954,1052,1095,1175},
                        new int[]{430,477,705,863,961,991,1003,1121,1190,1236},
                        new int[]{524,611,793,868,1027,1111,1112,1123,1252,1253},
                }, 1252);

        System.out.println(result);
    }
}
