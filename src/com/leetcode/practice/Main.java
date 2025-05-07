package com.leetcode.practice;


import com.leetcode.practice.solutions.heap.MyPriorityQueue;

public class Main {
    public static void main(String[] args) {
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>((a, b) -> b - a);
        priorityQueue.push(3);
        priorityQueue.push(5);
        priorityQueue.push(4);
        priorityQueue.push(6);
        priorityQueue.push(2);
        priorityQueue.push(1);
        priorityQueue.push(2333);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.pop());
        }
    }
}
