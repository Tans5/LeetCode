package com.leetcode.practice.solutions.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定一个图，该图从一棵 n 个节点 (节点值 1～n) 的树中添加一条边后获得。添加的边的两个不同顶点编号在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的
 */
public class Solution684 {

    /**
     * 在边 edge 的两个点 a, b 连接前就已经连通了，说明 [a, b] 就是连接成环的最后一条边，移除这条边，就使图退化成树了。
     * 使用并查集的方式来判断 a, b 是否已经连通了，如果在同一个集合中就表示连通了.
     *
     *
     *
     * 什么是并查集？
     * 并查集（Union-Find）是一种数据结构，主要用于处理一些不相交集合的合并（Union）与查询（Find）问题。它非常高效地支持以下两种操作：
     *
     * Find：查询某个元素属于哪个集合（通常是找到该集合的代表元素）。
     * Union：将两个集合合并成一个集合。
     * 此外，为了保持高效，通常还会使用两种优化技术：
     *
     * 路径压缩（Path Compression）：在Find操作中，将查找路径上的所有节点直接指向根节点，从而降低树的高度。
     * 按秩合并（Union by Rank）：在Union操作时，将深度较小的树连接到深度较大的树，以保持树的平衡，避免退化。
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        // 用于记录树的相对高度（并不是真的树的高度，这个值越大表名它的树越高），i 是树的 root.
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            parent[i] = i;
        }
        for (int[] edge: edges) {
            if (!union(edge[0], edge[1], rank, parent)) {
                return edge;
            }
        }
        return null;
    }


    private boolean union(int a, int b, int[] rank, int[] parent) {
        int aParent = findRootAndCompress(a, parent);
        int bParent = findRootAndCompress(b, parent);
        if (aParent == bParent) { // a, b 同属一个集合，直接返回
            return false;
        }
        // 合并 a, b 所在的集合(合并过程中会保持原有的树的平衡).
        if (rank[aParent] > rank[bParent]) { // a 集合的深度大于 b 集合的深度。将 b 集合合并到 a 集合中，a 集合的树高度不变
            parent[bParent] = aParent;
        } else if (rank[aParent] < rank[bParent]) { // a 集合的深度小于 b 集合的深度。将 a 集合合并到 b 集合中，b 集合的树高度不变
            parent[aParent] = bParent;
        } else { // 如果 a，b 集合的高度相等，将 b 集合合并到 a 集合中（反之也可以），这时 a 集合的高度会增加 1.
            parent[bParent] = aParent;
            rank[aParent] ++;
        }
        return true;
    }

    /**
     * 找到 a 所在集合的 root 节点，同时将这条路径上的节点都压缩，都指向 root 节点
     */
    private int findRootAndCompress(int a, int[] parent) {
        while(parent[a] != a) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }




    public int[] findRedundantConnection2(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] route = new boolean[edges.length + 1];
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            if (canReach(a, b, graph, route)) {
                return edge;
            }
            List<Integer> aNeighbors = graph.computeIfAbsent(a, k -> new ArrayList<>());
            List<Integer> bNeighbors = graph.computeIfAbsent(b, k -> new ArrayList<>());
            aNeighbors.add(b);
            bNeighbors.add(a);
        }
        return null;
    }

    private boolean canReach(int s, int t, Map<Integer, List<Integer>> maps, boolean[] route) {
        if (s == t) {
            return true;
        }
        List<Integer> neighbors = maps.get(s);
        if (neighbors == null) {
            return false;
        }
        route[s] = true;
        for (int neighbor: neighbors) {
            if (route[neighbor]) {
                continue;
            }
            if (canReach(neighbor, t, maps, route)) {
                return true;
            }
        }
        route[s] = false;
        return false;
    }
}
