package com.leetcode.practice.solutions.heap;

import java.util.ArrayList;
import java.util.List;

public class MyPriorityQueue<T> {

    private final List<T> heap = new ArrayList<>();

    private final Priority<T> priority;

    public MyPriorityQueue(Priority<T> p) {
        priority = p;
    }

    public void push(T v) {
        heap.add(v);
        makeHeapFromBottom(heap.size() - 1);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T value = getValue(0);
            swap(0, size() - 1);
            heap.remove(size() - 1);
            makeHeapFromTop(0);
            return value;
        }
    }

    public T peek() {
        return getValue(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private int leftChildIndex(int i) {
        return i * 2 + 1;
    }

    private int rightChildIndex(int i) {
        return i * 2 + 2;
    }

    private int parentIndex(int i) {
        if (i <= 0) {
            return -1;
        } else {
            return (i - 1) / 2;
        }
    }

    private void swap(int indexA, int indexB) {
        int s = size();
        if (indexA >= s || indexB >= s) {
            return;
        }
        T temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }

    private T getValue(int i) {
        if (i >= heap.size() || i < 0) {
            return null;
        } else {
            return heap.get(i);
        }
    }

    private void makeHeapFromBottom(int index) {
        if (index >= size() || index <= 0) {
            return;
        }
        int parentIndex = parentIndex(index);
        T value = getValue(index);
        T parentValue = getValue(parentIndex);
        int p = priority.priority(parentValue, value);
        if (p > 0) {
            swap(index, parentIndex);
            makeHeapFromBottom(parentIndex);
        }

    }

    private void makeHeapFromTop(int index) {
        if (index >= size() || index < 0) {
            return;
        }
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);
        T value = getValue(index);
        T leftChildValue = getValue(leftChildIndex);
        T rightChildValue = getValue(rightChildIndex);
        if (leftChildValue != null && rightChildValue != null) {
            int pl = priority.priority(value, leftChildValue);
            int pr = priority.priority(value, rightChildValue);
            if (pl > 0 && pr > 0) {
                int plr = priority.priority(leftChildValue, rightChildValue);
                if (plr < 0) {
                    swap(index, leftChildIndex);
                    makeHeapFromTop(leftChildIndex);
                } else {
                    swap(index, rightChildIndex);
                    makeHeapFromTop(rightChildIndex);
                }
            } else if (pl > 0) {
                swap(index, leftChildIndex);
                makeHeapFromTop(leftChildIndex);
            } else if (pr > 0) {
                swap(index, rightChildIndex);
                makeHeapFromTop(rightChildIndex);
            }
        } else if (leftChildValue != null) {
            int pl = priority.priority(value, leftChildValue);
            if (pl > 0) {
                swap(index, leftChildIndex);
            }
        } else if (rightChildValue != null) {
            int pr = priority.priority(value, rightChildValue);
            if (pr > 0) {
                swap(index, rightChildIndex);
            }
        }
    }


    public static interface Priority<T> {

        int priority(T a, T b);
    }
}
