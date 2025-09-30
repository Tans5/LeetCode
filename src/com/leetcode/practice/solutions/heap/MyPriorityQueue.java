package com.leetcode.practice.solutions.heap;

import java.util.LinkedList;
import java.util.List;

public class MyPriorityQueue<T> {

    private final List<T> heap = new LinkedList<>();
    private final Priority<T> priority;

    public MyPriorityQueue(Priority<T> p) {
        priority = p;
    }

    public void offer(T v) {
//        heap.add(0, v);
//        sinkDown(0);
        heap.add(v);
        bubbleUp(heap.size() - 1);
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T value = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        sinkDown(0);
        return value;
    }

    public T peek() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private int leftChildIndex(int i) {
        return i * 2 + 1;
    }

    private int rightChildIndex(int i) {
        return i * 2 + 2;
    }

    private void swap(int indexA, int indexB) {
        if (indexA >= heap.size() || indexB >= heap.size() || indexA < 0 || indexB < 0) {
            return;
        }
        T temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }

    private void bubbleUp(int index) {
        if (index <= 0) {
            return;
        }
        int parentIndex = parentIndex(index);
        T current = heap.get(index);
        T parent = heap.get(parentIndex);

        // 如果当前节点的优先级高于父节点，则交换
        if (priority.priority(current, parent) < 0) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void sinkDown(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        int highestPriorityIndex = index;

        // 检查左子节点
        if (leftChildIndex < heap.size()) {
            T current = heap.get(highestPriorityIndex);
            T leftChild = heap.get(leftChildIndex);
            if (priority.priority(current, leftChild) > 0) {
                highestPriorityIndex = leftChildIndex;
            }
        }

        // 检查右子节点
        if (rightChildIndex < heap.size()) {
            T current = heap.get(highestPriorityIndex);
            T rightChild = heap.get(rightChildIndex);
            if (priority.priority(current, rightChild) > 0) {
                highestPriorityIndex = rightChildIndex;
            }
        }

        // 如果需要交换，递归下沉
        if (highestPriorityIndex != index) {
            swap(index, highestPriorityIndex);
            sinkDown(highestPriorityIndex);
        }
    }

    public interface Priority<T> {
        /**
         * 比较两个元素的优先级
         * @param a 第一个元素
         * @param b 第二个元素
         * @return 负数如果a的优先级高于b，正数如果a的优先级低于b，0如果相等
         */
        int priority(T a, T b);
    }
}
