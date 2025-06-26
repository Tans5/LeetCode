package com.leetcode.practice.solutions.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 有 n 个网络节点，标记为 1 到 n。
 *
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 *
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 *
 *
 *
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 *
 * 提示：
 *
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 *
 */
public class Solution743 {

    // 使用迪杰斯特拉算法求到每个节点的最短路径
    public int networkDelayTime(int[][] times, int n, int k) {
        // index 为目标节点，值为它的可到达的相邻节点，每个相邻节点的数组 0 表示节点的 index， 1 表示 weight 耗时
        List[] maps = new ArrayList[n + 1];
        for (int[] time: times) {
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            List<int[]> neighbors = maps[source];
            if (neighbors == null) {
                neighbors = new ArrayList<>();
                maps[source] = neighbors;
            }
            neighbors.add(new int[] {target, weight});
        }

        // k 到达每个节点的最小距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 初始化 k 到达自己的距离为 0
        dist[k] = 0;
        // k 到达最近节点 i 时，i 的前面的一个节点（这样可以构建一个完整的路径，不过本题可以不需要）
        int[] pre = new int[n + 1];

        // k 到达目标节点 v[0] 是耗时 v[1]，耗时最小的节点优先处理.
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        queue.offer(new int[] {k, 0});
        while (!queue.isEmpty()) {
            int node = queue.peek()[0];
            int weight = queue.poll()[1];
            if (dist[node] != weight) { // 二次检查，这步操作不是必须，但是可以提升性能
                continue;
            }
            List<int[]> neighbors = maps[node];
            if (neighbors != null) {
                for (int[] neighbor: neighbors) {
                    int nNode = neighbor[0];
                    int nWeight = neighbor[1] + weight;
                    if (nWeight < dist[nNode]) { // 如果到达当前节点的耗时比前面记录的耗时要低，那么更新后续的数据
                        pre[nNode] = node; // 更新 nNode 的前驱节点为 node
                        dist[nNode] = nWeight; // 更新到达 k 到达 nNode 的最短距离
                        queue.offer(new int[] {nNode, nWeight}); // 将当前节点加入到等待查找的队列中
                    }
                }
            }
        }
        // 只需要找到耗时最长的节点，这个时间就是遍历所有节点的耗时
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dist.length; i ++) {
            if (dist[i] == Integer.MAX_VALUE) {
                // 有无法到达的节点
                return -1;
            }
            if (dist[i] > max) {
                max = dist[i];
            }
        }
        return max;
    }
}
