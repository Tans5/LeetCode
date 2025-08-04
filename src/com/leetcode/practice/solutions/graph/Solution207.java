package com.leetcode.practice.solutions.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 *
 * 提示：
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class Solution207 {

    // BFS拓扑排序实现（Kahn算法）
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<Integer>[] graph = new ArrayList[numCourses];
        // 入度
        int[] inDegree = new int[numCourses];
        // 被依赖的课程指向依赖的课程
        for (int[] edge: prerequisites) {
            inDegree[edge[0]] ++;
            List<Integer> next = graph[edge[1]];
            if (next == null) {
                next = new ArrayList<>();
                graph[edge[1]] = next;
            }
            next.add(edge[0]);
        }
        Deque<Integer> toLearn = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i ++) {
            if (inDegree[i] == 0) {
                toLearn.offer(i);
            }
        }
        int complete = 0;
        while (!toLearn.isEmpty()) {
            int learned = toLearn.poll();
            complete ++;
            List<Integer> next = graph[learned];
            if (next != null) {
                for (int neighbor: next) {
                    inDegree[neighbor] --;
                    if (inDegree[neighbor] == 0) {
                        toLearn.offer(neighbor);
                    }
                }
            }
        }
        return complete == numCourses;
    }


    // DFS 遍历
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        List[] maps = new ArrayList[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<Integer> dependencies = maps[prerequisite[0]];
            if (dependencies == null) {
                dependencies = new ArrayList<>();
                maps[prerequisite[0]] = dependencies;
            }
            dependencies.add(prerequisite[1]);
        }
        Set<Integer> checkedHistory = new HashSet<>();
        Set<Integer> route = new HashSet<>();
        for (int i = 0; i < numCourses; i ++) {
            if (hasRing(i, maps, checkedHistory, route)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasRing(int startIndex, List[] maps, Set<Integer> checkHistory, Set<Integer> route) {
        if (checkHistory.contains(startIndex)) {
            return false;
        }
        if (route.contains(startIndex)) {
            return true;
        }
        route.add(startIndex);
        List<Integer> dependencies = maps[startIndex];
        if (dependencies != null) {
            for (int i = 0; i < dependencies.size(); i ++) {
                if (hasRing(dependencies.get(i), maps, checkHistory, route)) {
                    return true;
                }
            }
        }
        route.remove(startIndex);
        checkHistory.add(startIndex);
        return false;
    }
}
