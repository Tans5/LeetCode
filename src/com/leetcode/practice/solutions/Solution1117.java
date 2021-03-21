package com.leetcode.practice.solutions;

import java.util.concurrent.*;

public class Solution1117 {


    Semaphore o = new Semaphore(2);
    Semaphore h = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        o.acquire();
        releaseHydrogen.run();
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        h.acquire(2);
        releaseOxygen.run();
        o.release(2);
    }
}
