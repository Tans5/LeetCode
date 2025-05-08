package com.leetcode.practice.solutions.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class Hanota {

    private int moveTimes = 0;

    public static void main(String[] args) {
        Hanota h = new Hanota();
        List<Integer> src = new ArrayList<>();
        src.add(1);
        src.add(2);
        src.add(3);
        src.add(4);
        int t = h.solveHanota(src, new ArrayList<>(), new ArrayList<>());
        System.out.println(t);
    }

    public int solveHanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        moveTimes = 0;
        if (!A.isEmpty()) {
            moveToTarget(A.size(), A, B, C);
        }
        return moveTimes;
    }

    private void move(List<Integer> source, List<Integer> target) {
        if (source.isEmpty()) {
            return;
        }
        Integer v = source.remove(0);
        target.add(0, v);
        moveTimes ++;
    }

    private void moveToTarget(int count, List<Integer> source, List<Integer> buffer, List<Integer> target) {
        if (count <= 1) {
            move(source, target);
        } else {
            moveToTarget(count - 1, source, target, buffer);
            move(source, target);
            moveToTarget(count - 1, buffer, source, target);
        }
    }
}
