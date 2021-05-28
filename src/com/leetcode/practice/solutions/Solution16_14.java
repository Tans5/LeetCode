package com.leetcode.practice.solutions;

import java.util.*;

public class Solution16_14 {

    public static class Line {
        final Double rate;
        final Double b;

        final Double x;

        public Line(double rate, double b) {
            this.rate = rate;
            this.b = b;
            x = null;
        }

        public Line(double x) {
            this.x = x;
            rate = null;
            b = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Objects.equals(rate, line.rate) && Objects.equals(b, line.b) && Objects.equals(x, line.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rate, b, x);
        }

        public boolean isInLine(double x, double y) {
            if (this.x != null) {
                return this.x == x;
            }
            if (this.rate != null && b != null) {
                return Math.abs((x * rate + b) - y) < 0.000001;
            }
            return false;
        }
    }

    public static int[] bestLine(int[][] points) {
        Map<Line, List<Integer>> hitPoints = new LinkedHashMap<Line, List<Integer>>(16, 0.75f, true);
        for (int i = 0; i < points.length - 1; i ++) {
            for (int j = i + 1; j < points.length; j ++) {
                Line l = createLine(new double[] {(double) points[i][0], (double) points[i][1]}, new double[] {(double) points[j][0], (double) points[j][1]});
                if (!hitPoints.containsKey(l)) {
                    ArrayList<Integer> ps = new ArrayList<>();
                    ps.add(i);
                    ps.add(j);
                    hitPoints.put(l, ps);
                } else {
                    continue;
                }
                for (int k = j + 1; k < points.length; k++) {
                    if (l.isInLine((double) points[k][0], (double) points[k][1])) {
                        hitPoints.get(l).add(j);
                    }
                }
            }
        }
        List<Integer> maxPointsLine = null;
        for (List<Integer> lines: hitPoints.values()) {
            if (maxPointsLine == null) {
                maxPointsLine = lines;
            } else if(maxPointsLine.size() < lines.size()){
                maxPointsLine = lines;
            }
        }
        return new int[] {maxPointsLine.get(0), maxPointsLine.get(1)};
    }

    public static Line createLine(double[] p1, double[] p2) {
        Line result;
        if (Math.abs(p1[0] - p2[0]) < 0.0000001) {
            result = new Line(p1[0]);
        } else {
            double rate = (p1[1] - p2[1]) / (p1[0] - p2[0]);
            double b = p1[1] - rate * p1[0];
            result = new Line(rate, b);
        }
        return result;
    }

}
