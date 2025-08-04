package com.leetcode.practice.solutions.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 *
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 */
public class Solution210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] learnOrder = new int[numCourses];
        int learnOrderIndex = 0;
        while (!toLearn.isEmpty()) {
            int learned = toLearn.poll();
            learnOrder[learnOrderIndex ++ ] = learned;
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
        if (learnOrderIndex == numCourses) {
            return learnOrder;
        } else {
            return new int[]{};
        }
    }
}
