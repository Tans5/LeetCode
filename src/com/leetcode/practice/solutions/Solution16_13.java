package com.leetcode.practice.solutions;

public class Solution16_13 {

    public static double[] cutSquares(int[] square1, int[] square2) {
        double[] result = new double[4];
        double[] center1 = new double[2];
        double[] center2 = new double[2];

        center1[0] = square1[0] + square1[2] / 2.0;
        center1[1] = square1[1] + square1[2] / 2.0;

        center2[0] = square2[0] + square2[2] / 2.0;
        center2[1] = square2[1] + square2[2] / 2.0;

        if (Math.abs(center1[0] - center2[0]) < 0.0000001) {
            double x = center1[0];
            double[][] points = new double[][]{
                    new double[]{x, center1[1] - square1[2] / 2.0},
                    new double[]{x, center2[1] - square2[2] / 2.0},
                    new double[]{x, center1[1] + square1[2] / 2.0},
                    new double[]{x, center2[1] + square2[2] / 2.0}
            };
            double[] start = points[0];
            double[] end = points[0];
            for (double[] p: points) {
                if (p[1] < start[1]) {
                    start = p;
                }
                if (p[1] > end[1]) {
                    end = p;
                }
            }
            result[0] = start[0];
            result[1] = start[1];
            result[2] = end[0];
            result[3] = end[1];
            return result;
        }

        if (Math.abs(center1[1] - center2[1]) < 0.0000001) {
            double y = center1[1];
            double[][] points = new double[][]{
                    new double[]{center1[0] - square1[2] / 2.0, y},
                    new double[]{center2[0] - square2[2] / 2.0, y},
                    new double[]{center1[0] + square1[2] / 2.0, y},
                    new double[]{center2[0] + square2[2] / 2.0, y}
            };
            double[] start = points[0];
            double[] end = points[0];
            for (double[] p: points) {
                if (p[0] < start[0]) {
                    start = p;
                }
                if (p[0] > end[0]) {
                    end = p;
                }
            }
            result[0] = start[0];
            result[1] = start[1];
            result[2] = end[0];
            result[3] = end[1];
            return result;
        }
        double rate = (center2[1] - center1[1]) / (center2[0] - center1[0]);
        double b = center1[1] - center1[0] * rate;

        if (Math.abs(rate) > 1.0) {
            double y11 = center1[1] + square1[2] / 2.0;
            double y12 = center2[1] + square2[2] / 2.0;

            double y21 = center1[1] - square1[2] / 2.0;
            double y22 = center2[1] - square2[2] / 2.0;

            double[][] points = new double[][]{
                    new double[]{(y11 - b) / rate, y11},
                    new double[]{(y12 - b) / rate, y12},
                    new double[]{(y21 - b) / rate, y21},
                    new double[]{(y22 - b) / rate, y22}
            };
            double[] start = points[0];
            double[] end = points[0];
            for (double[] p: points) {
                if (p[0] < start[0]) {
                    start = p;
                }
                if (p[0] > end[0]) {
                    end = p;
                }
            }
            result[0] = start[0];
            result[1] = start[1];
            result[2] = end[0];
            result[3] = end[1];
            return result;
        } else {
            double x11 = center1[0] + square1[2] / 2.0;
            double x12 = center2[0] + square2[2] / 2.0;
            double x21 = center1[0] - square1[2] / 2.0;
            double x22 = center2[0] - square2[2] / 2.0;

            double[][] points = new double[][]{
                    new double[]{x11, x11 * rate + b},
                    new double[]{x12, x12 * rate + b},
                    new double[]{x21, x21 * rate + b},
                    new double[]{x22, x22 * rate + b}
            };
            double[] start = points[0];
            double[] end = points[0];
            for (double[] p: points) {
                if (p[0] < start[0]) {
                    start = p;
                }
                if (p[0] > end[0]) {
                    end = p;
                }
            }
            result[0] = start[0];
            result[1] = start[1];
            result[2] = end[0];
            result[3] = end[1];
            return result;
        }
    }

}
