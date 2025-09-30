package com.leetcode.practice.solutions.greedy;


/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 *
 *
 * 示例 1:
 *
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 */
public class Solution134 {


    /**
     * 高效解法：
     * 我们使用一个叫“一次遍历法”的贪心策略。核心思想是：
     *
     * 如果总油量小于总消耗，那么肯定无法环绕一圈，返回-1。
     * 否则，一定有解（且唯一）。我们模拟从0号加油站开始，遍历过程中记录当前剩余油量（从0开始累加gas[i]-cost[i]），
     * 如果当前剩余油量为负，说明从起点到当前点中的任何一个点出发都不能到达下一个点（因为从起点到当前点的过程中必然有一个点使得剩余油量成为负，
     * 而我们之前可能是正的，所以需要重新选择起点），那么我们就把下一个加油站作为起点，并且将当前剩余油量归0。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length == 0) {
            return -1;
        }
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i ++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (costSum > gasSum) {
            return -1;
        }
        int startIndex = 0;
        int gasTank = 0;
        while (true) {
            for (int i = 0; i < gas.length; i ++) {
                int stationIndex = (startIndex + i) % gas.length;
                gasTank += gas[stationIndex] - cost[stationIndex];
                if (gasTank < 0) {
                    gasTank = 0;
                    startIndex = (stationIndex + 1) % gas.length;
                    break;
                }
                if (i == gas.length - 1) {
                    return startIndex;
                }
            }
        }
    }
}
