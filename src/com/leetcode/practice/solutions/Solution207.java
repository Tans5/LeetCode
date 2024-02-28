package com.leetcode.practice.solutions;

import java.util.*;

public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, int[]> dependencies = new HashMap<>();
        for (int[] cToP: prerequisites) {
            int[] dp = dependencies.get(cToP[0]);
            if (dp == null) {
                dependencies.put(cToP[0], new int[] {cToP[1]});
            } else {
                int[] newDp = Arrays.copyOf(dp, dp.length + 1);
                newDp[dp.length] = cToP[1];
                dependencies.put(cToP[0], newDp);
            }
        }
        Set<Integer> finishedCourses = new HashSet<>();
        for (int[] cToP: prerequisites) {
            int course = cToP[0];
            if (!tryFinishCourse(course, dependencies, finishedCourses, null)) {
                return false;
            }
        }

        return true;
    }

    public boolean tryFinishCourse(
            int course,
            Map<Integer, int[]> dependencies,
            Set<Integer> finished,
            Set<Integer> myDepenciesChain) {
        if (finished.contains(course)) {
            return true;
        }
        if (myDepenciesChain == null) {
            myDepenciesChain = new HashSet<>();
        }
        if (myDepenciesChain.contains(course)) {
            return false;
        }
        myDepenciesChain.add(course);
        int[] currentDependent = dependencies.get(course);
        if (currentDependent == null) {
            myDepenciesChain.remove(course);
            finished.add(course);
            return true;
        }
        for (int d: currentDependent) {
            if (!tryFinishCourse(d, dependencies, finished, myDepenciesChain)) {
                myDepenciesChain.remove(course);
                return false;
            }
        }
        myDepenciesChain.remove(course);
        finished.add(course);
        return true;
    }
}
